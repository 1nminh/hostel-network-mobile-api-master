package com.giang.service;

import com.giang.service.dto.PictureDTO;

import java.util.List;

public interface PictureService {
    List<String> findAllPictureByPostId(Integer postId);

    PictureDTO insertPicture(Integer postId, String imgLink);

    Boolean deletePicture(Integer id);
}
