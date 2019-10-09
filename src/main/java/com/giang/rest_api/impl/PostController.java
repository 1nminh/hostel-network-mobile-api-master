package com.giang.rest_api.impl;

import com.giang.rest_api.PostApi;
import com.giang.service.PostService;
import com.giang.service.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PostController implements PostApi {

    @Autowired
    PostService postService;

//    @Override
//    public ResponseEntity<List<PostDTO>> getAll() {
//        return ResponseEntity.ok(postService.getAll());
//    }

    @Override
    public ResponseEntity<PostDTO> getPost(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @Override
    public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO newPost) {
        return ResponseEntity.ok(postService.createNewPost(newPost));
    }

    @Override
    public ResponseEntity<PostDTO> updatePost(@PathVariable("id")Integer id,
                                              @RequestBody(required = false) PostDTO dto) {
        return ResponseEntity.ok(postService.updatePost(dto));
    }

    @Override
    public ResponseEntity<List<PostDTO>> filterPost(@RequestParam(value = "benefits", required = false) List<Integer> benefitIds,
                                                    @RequestParam(value = "type", required = false) Integer typeId,
                                                    @RequestParam(value = "location", required = false) String location,
                                                    @RequestParam(value = "minPrice", required = false) Double minPrice,
                                                    @RequestParam(value = "maxPrice", required = false) Double maxPrice) {
        if (Objects.isNull(benefitIds) && Objects.isNull(typeId) && Objects.isNull(location) && Objects.isNull(minPrice) && Objects.isNull(maxPrice)) {
            return ResponseEntity.ok(postService.getAll());
        }
        return ResponseEntity.ok(postService.fillterPost(benefitIds, typeId, location, minPrice, maxPrice));
    }

    @Override
    public ResponseEntity<Boolean> deletePost(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

    @Override
    public ResponseEntity<List<PostDTO>> getPostByUser(Integer userId, Boolean created, Boolean saved) {
        if (created != null && created){
            return ResponseEntity.ok(postService.getCreatedPostByUser(userId));
        }
        if (saved != null && saved){
            return ResponseEntity.ok(postService.getSavedPostByUser(userId));
        }
        return ResponseEntity.ok(null);
    }
}
