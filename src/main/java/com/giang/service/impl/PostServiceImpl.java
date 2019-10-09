package com.giang.service.impl;

import com.giang.repository.*;
import com.giang.repository.entity.Post;
import com.giang.repository.entity.User;
import com.giang.service.PostService;
import com.giang.service.dto.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final PostCustomRepository postCustomRepository;

    private final UserRepository userRepository;

    private final BenefitInPostRepository benefitInPostRepository;

    private final TypeRepository typeRepository;

    private final WishListRepository wishListRepository;

    private final PictureRepository pictureRepository;

    public PostServiceImpl(PostRepository postRepository, PostCustomRepository postCustomRepository, UserRepository userRepository, BenefitInPostRepository benefitInPostRepository, TypeRepository typeRepository, WishListRepository wishListRepository, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.postCustomRepository = postCustomRepository;
        this.userRepository = userRepository;
        this.benefitInPostRepository = benefitInPostRepository;
        this.typeRepository = typeRepository;
        this.wishListRepository = wishListRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<PostDTO> getAll() {
        return postRepository.findAllPost().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPost(Integer id) {
        Post post = postRepository.findById(id);
        Optional.ofNullable(post).orElseThrow(EntityNotFoundException::new);

        return mapToDto(post);
    }

    @Override
    public PostDTO createNewPost(PostDTO newPost) {

        Post post = mapToEntity(newPost);
        post = postRepository.saveAndFlush(post);
        return mapToDto(post);
    }

    @Override
    public PostDTO updatePost(PostDTO dto) {
        Post post = postRepository.findById(dto.getId());
        Optional.ofNullable(post).orElseThrow(EntityNotFoundException::new);

        post = postRepository.saveAndFlush(mapToEntity(dto));
        return mapToDto(post);
    }

    @Override
    public List<PostDTO> fillterPost(List<Integer> benefitIds, Integer typeId, String location, Double minPrice, Double maxPrice) {

        List<Integer> list = null;
        if (Objects.isNull(location)) {
            location = "%";
        } else {
            location = "%" + location + "%";
        }
        if (Objects.isNull(minPrice)) {
            minPrice = 1D;
        }
        if (Objects.isNull(maxPrice)) {
            maxPrice = 100000000D;
        }
        if (Objects.isNull(benefitIds) && Objects.isNull(typeId)) {

            list = postCustomRepository.filterWithoutTypeAndBenefit(location, minPrice, maxPrice);
        } else if (Objects.isNull(typeId)) {
            list = postCustomRepository.filterWithoutType(benefitIds, location, minPrice, maxPrice);
        } else if (Objects.isNull(benefitIds)) {
            list = postCustomRepository.filterWithoutBenefit(typeId, location, minPrice, maxPrice);
        } else {
            list = postCustomRepository.filter(benefitIds, typeId, location, minPrice, maxPrice);
        }

        if (Objects.isNull(list) || list.size() < 1) {
            throw new EntityNotFoundException("Not found post by conditions");
        }

        List<Post> result = postRepository.findByIdIn(list);
        return result.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    @Override
    public Boolean deletePost(Integer id) {
        Post post = postRepository.findById(id);
        Optional.ofNullable(post).orElseThrow(EntityNotFoundException::new);

        postRepository.delete(post);
        pictureRepository.deleteAllByPostId(post.getId());
        benefitInPostRepository.deleteAllByPostId(post.getId());
        return true;
    }

    @Override
    public List<PostDTO> getCreatedPostByUser(Integer userId) {
        return postRepository.findAllCreatedPost(userId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getSavedPostByUser(Integer userId) {
        List<Post> result = new ArrayList<>();
        List<Integer> postIds = wishListRepository.findPostIdByUserId(userId);
        if (postIds != null && postIds.size() > 0){
            result = postRepository.findByIdIn(postIds);
        }
        return result.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private PostDTO mapToDto(Post entity) {
        ModelMapper modelMapper = new ModelMapper();
        PostDTO result = modelMapper.map(entity, PostDTO.class);

        result.setTypeStr(typeRepository.findTypeNameById(entity.getTypeId()));
        return result;
    }

    private Post mapToEntity(PostDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Post.class);
    }

}
