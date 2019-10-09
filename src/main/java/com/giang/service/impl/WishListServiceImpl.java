package com.giang.service.impl;

import com.giang.repository.WishListRepository;
import com.giang.repository.entity.WishList;
import com.giang.service.WishListService;
import com.giang.service.dto.WishListDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public List<Integer> getAllPostIdInWishList(Integer userId) {
        return wishListRepository.findPostIdByUserId(userId);
    }

    @Override
    public WishListDTO savePostToWishList(Integer userId, Integer postId) {
        WishList wishList = wishListRepository.findByUserIdAndPostId(userId, postId);
        if (Objects.nonNull(wishList)) {
            throw new EntityExistsException("This post is have been in this user's wish list!");
        } else {
            wishList = new WishList();
            wishList.setUserId(userId);
            wishList.setPostId(postId);
            wishList = wishListRepository.saveAndFlush(wishList);
        }

        return mapToDto(wishList);
    }

    @Override
    public Boolean deleteWishListById(Integer id) {
        WishList wishList = wishListRepository.findById(id);
        Optional.ofNullable(wishList).orElseThrow(EntityNotFoundException::new);

        wishListRepository.delete(wishList);
        return true;
    }

    @Override
    public Boolean deleteWishLishByUserIdAndPostId(Integer userId, Integer postId) {
        WishList wishList = wishListRepository.findByUserIdAndPostId(userId, postId);
        if (Objects.isNull(wishList)){
            throw new  EntityNotFoundException("Not found post in wish list of this user");
        }
        wishListRepository.delete(wishList);
        return true;
    }

    private WishListDTO mapToDto(WishList entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, WishListDTO.class);
    }
}
