package com.giang.rest_api;

import com.giang.service.dto.WishListDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("wishLists")
public interface WishListApi {

    @ApiOperation(tags = "WISH LIST", value = "Get all save post of an user")
    @GetMapping("")
    ResponseEntity<List<Integer>> getAllPostIdSavedByUserId(@RequestParam("userId") Integer userId);

    @ApiOperation(tags = "WISH LIST", value = "Add a post to wish list of an user")
    @PostMapping("")
    ResponseEntity<WishListDTO> savePostToWishList(@RequestParam("userId") Integer userId,
                                                   @RequestParam("postId") Integer postId);

    @ApiOperation(tags = "WISH LIST", value = "Delete a wish list by id")
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteAWishList(@PathVariable("id") Integer id);

    @ApiOperation(tags = "WISH LIST", value = "Delete a post out of a wish list of an user")
    @DeleteMapping("")
    ResponseEntity<Boolean> deletePostOutOfWishListOfUser(@RequestParam("userId") Integer userId,
                                                          @RequestParam("postId") Integer postId);
}
