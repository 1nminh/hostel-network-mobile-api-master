package com.giang.service.impl;

import com.giang.repository.BenefitInPostRepository;
import com.giang.repository.BenefitRepository;
import com.giang.repository.entity.Benefit;
import com.giang.repository.entity.BenefitInPost;
import com.giang.service.BenefitService;
import com.giang.service.dto.BenefitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    private final BenefitInPostRepository benefitInPostRepository;

    public BenefitServiceImpl(BenefitRepository benefitRepository, BenefitInPostRepository benefitInPostRepository) {
        this.benefitRepository = benefitRepository;
        this.benefitInPostRepository = benefitInPostRepository;
    }

    @Override
    public List<BenefitDTO> getAll() {
        return benefitRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BenefitDTO> listBenefitByPost(Integer postId) {
        List<Integer> ids = benefitInPostRepository.findAllBenefitIdByPostId(postId);
        if (Objects.nonNull(ids) && ids.size() > 0) {
            return benefitRepository.findAllByIdIn(ids).stream().map(this::mapToDTO).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Boolean insertBenefitIntoPost(Integer postId, Integer benefitId) {
        BenefitInPost benefitInPost = benefitInPostRepository.findByBenefitIdAndPostId(benefitId, postId);
        if (Objects.nonNull(benefitInPost)) {
            throw new EntityExistsException("This benefit is exist for this post");
        }
        benefitInPost = new BenefitInPost();
        benefitInPost.setPostId(postId);
        benefitInPost.setBenefitId(benefitId);
        benefitInPostRepository.saveAndFlush(benefitInPost);
        return true;
    }

    @Override
    public Boolean deleteBenefitOutOfPost(Integer id) {
        BenefitInPost benefitInPost = benefitInPostRepository.findById(id);
        Optional.ofNullable(benefitInPost).orElseThrow(EntityNotFoundException::new);
        benefitInPostRepository.delete(benefitInPost);
        return true;
    }

    private BenefitDTO mapToDTO(Benefit entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, BenefitDTO.class);
    }
}
