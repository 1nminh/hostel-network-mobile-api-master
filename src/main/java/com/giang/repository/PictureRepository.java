package com.giang.repository;

import com.giang.repository.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query("SELECT p FROM Picture p WHERE p.id = ?1")
    Picture findById(Integer id);

    @Query("SELECT p.imgLink FROM Picture p WHERE p.postId = ?1")
    List<String> findImgByPostId(Integer postId);

    @Query("SELECT p FROM Picture p WHERE p.id = ?1 AND p.imgLink = ?2")
    Picture findByAndPostIdAndAndImgLink(Integer id, String imgLink);

    @Query("DELETE FROM Picture p WHERE p.postId = ?1")
    @Modifying
    void deleteAllByPostId(Integer postId);
}
