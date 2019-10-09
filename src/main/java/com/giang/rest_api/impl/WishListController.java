package com.giang.rest_api.impl;

import com.giang.rest_api.WishListApi;
import com.giang.service.WishListService;
import com.giang.service.dto.WishListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishListController implements WishListApi {

    @Autowired
    WishListService wishListService;

    @Override
    public ResponseEntity<List<Integer>> getAllPostIdSavedByUserId(@RequestParam("userId") Integer userId) {
        return ResponseEntity.ok(wishListService.getAllPostIdInWishList(userId));
    }

    @Override
    public ResponseEntity<WishListDTO> savePostToWishList(@RequestParam("userId") Integer userId,
                                                          @RequestParam("postId") Integer postId) {
        return ResponseEntity.ok(wishListService.savePostToWishList(userId, postId));
    }

    @Override
    public ResponseEntity<Boolean> deleteAWishList(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(wishListService.deleteWishListById(id));
    }

    @Override
    public ResponseEntity<Boolean> deletePostOutOfWishListOfUser(Integer userId, Integer postId) {
        return ResponseEntity.ok(wishListService.deleteWishLishByUserIdAndPostId(userId,postId));
    }
}
