package com.giang.repository;

import com.giang.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(Integer id);

    @Query("SELECT p FROM Post p WHERE p.id in ?1 ORDER BY p.postDate desc ")
    List<Post> findByIdIn(List<Integer> ids);

    @Query("SELECT p FROM Post p ORDER BY p.postDate desc ")
    List<Post> findAllPost();

    @Query("SELECT p FROM Post p WHERE p.userId = ?1 ORDER BY p.postDate desc ")
    List<Post> findAllPostByUserId(Integer userId);

    @Query("SELECT p FROM Post p WHERE p.userId = ?1")
    List<Post> findAllCreatedPost(Integer userId);
}
