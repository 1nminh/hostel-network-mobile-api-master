package com.giang.repository;

import com.giang.repository.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    WishList findById(Integer id);

    List<WishList> findAllByUserId(Integer userId);

    WishList findByUserIdAndPostId(Integer userId, Integer postId);

    @Query("SELECT w.postId FROM WishList w WHERE w.userId = ?1")
    List<Integer> findPostIdByUserId(Integer userId);
}
