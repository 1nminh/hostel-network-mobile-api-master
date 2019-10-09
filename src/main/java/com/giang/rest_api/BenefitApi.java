package com.giang.rest_api;

import com.giang.service.dto.BenefitDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/benefits")
public interface BenefitApi {

//    @ApiOperation(tags = "BENEFIT", value = "Get all benefit ", response = BenefitDTO.class)
//    @GetMapping("")
//    ResponseEntity<List<BenefitDTO>> getAllBenefit();

    @ApiOperation(tags = "BENEFIT", value = "Get all benefit in a post", response = BenefitDTO.class)
    @GetMapping("")
    ResponseEntity<List<BenefitDTO>> getAllBenefitInPost(@RequestParam(value = "postId", required = false) Integer postId);

    @ApiOperation(tags = "BENEFIT", value = "Insert a benefit into a post", response = Boolean.class)
    @PostMapping("")
    ResponseEntity<Boolean> insertBenefitIntoPost(@RequestParam Integer postId,
                                                  @RequestParam Integer benefitId);

    @ApiOperation(tags = "BENEFIT", value = "Delete a benefit out of post", response = Boolean.class)
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteBenefit(@PathVariable("id") Integer id);

}
