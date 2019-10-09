package com.giang.service;

import com.giang.service.dto.PostDTO;

import java.time.LocalDate;
import java.util.List;

public interface PostService {
    List<PostDTO> getAll();

    PostDTO getPost(Integer id);

    PostDTO createNewPost(PostDTO newPost);

    PostDTO updatePost(PostDTO dto);

    List<PostDTO> fillterPost(List<Integer> benefitIds, Integer typeId, String location, Double minPrice, Double maxPrice);

    Boolean deletePost(Integer id);

    List<PostDTO> getCreatedPostByUser(Integer userId);

    List<PostDTO> getSavedPostByUser(Integer userId);
}
