package com.giang.rest_api.impl;

import com.giang.rest_api.BenefitApi;
import com.giang.service.BenefitService;
import com.giang.service.dto.BenefitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class BenefitController implements BenefitApi {

    @Autowired
    BenefitService benefitService;
//
//    @Override
//    public ResponseEntity<List<BenefitDTO>> getAllBenefit() {
//        return
//    }

    @Override
    public ResponseEntity<List<BenefitDTO>> getAllBenefitInPost(@RequestParam(value = "postId", required = false) Integer postId) {
        return Objects.nonNull(postId) ?
                ResponseEntity.ok(benefitService.listBenefitByPost(postId))
                : ResponseEntity.ok(benefitService.getAll());
    }

    @Override
    public ResponseEntity<Boolean> insertBenefitIntoPost(@RequestParam Integer postId,
                                                         @RequestParam Integer benefitId) {
        return ResponseEntity.ok(benefitService.insertBenefitIntoPost(postId, benefitId));
    }

    @Override
    public ResponseEntity<Boolean> deleteBenefit(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(benefitService.deleteBenefitOutOfPost(id));
    }
}
