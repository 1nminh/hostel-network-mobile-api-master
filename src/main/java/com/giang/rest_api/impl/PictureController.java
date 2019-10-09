package com.giang.rest_api.impl;

import com.giang.rest_api.PictureApi;
import com.giang.service.PictureService;
import com.giang.service.dto.PictureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PictureController implements PictureApi {

    @Autowired
    PictureService pictureService;

    @Override
    public ResponseEntity<List<String>> getAllPictureInPost(@RequestParam Integer postId) {
        return ResponseEntity.ok(pictureService.findAllPictureByPostId(postId));
    }

    @Override
    public ResponseEntity<PictureDTO> insertPictureIntoPost(@RequestParam Integer postId,
                                                            @RequestParam String imgLink) {
        return ResponseEntity.ok(pictureService.insertPicture(postId, imgLink));
    }

    @Override
    public ResponseEntity<Boolean> deletePicture(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(pictureService.deletePicture(id));
    }
}
