package com.giang.service;

import com.giang.service.dto.WishListDTO;

import java.util.List;

public interface WishListService {
    List<Integer> getAllPostIdInWishList(Integer userId);

    WishListDTO savePostToWishList(Integer userId, Integer postId);

    Boolean deleteWishListById(Integer id);

    Boolean deleteWishLishByUserIdAndPostId(Integer userId, Integer postId);
}
