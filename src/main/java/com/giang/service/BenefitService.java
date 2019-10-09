package com.giang.service;

import com.giang.service.dto.BenefitDTO;

import java.util.List;

public interface BenefitService {

    List<BenefitDTO> getAll();

    List<BenefitDTO> listBenefitByPost(Integer postId);

    Boolean insertBenefitIntoPost(Integer postId, Integer benefitId);

    Boolean deleteBenefitOutOfPost(Integer id);

}
