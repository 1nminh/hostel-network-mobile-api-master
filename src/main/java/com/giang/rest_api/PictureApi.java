package com.giang.rest_api;

import com.giang.service.dto.PictureDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/pictures")
public interface PictureApi {

    @ApiOperation(tags = "PICTURES", value = "Get all picture in a post", response = String.class)
    @GetMapping("")
    ResponseEntity<List<String>> getAllPictureInPost(@RequestParam Integer postId);

    @ApiOperation(tags = "PICTURES", value = "Insert all picture into a post", response = PictureDTO.class)
    @PostMapping("")
    ResponseEntity<PictureDTO> insertPictureIntoPost(@RequestParam Integer postId,
                                                     @RequestParam String imgLink);

    @ApiOperation(tags = "PICTURES", value = "Delete a picture", response = Boolean.class)
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deletePicture(@PathVariable("id") Integer id);
}
