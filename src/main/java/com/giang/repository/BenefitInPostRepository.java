package com.giang.repository;

import com.giang.repository.entity.BenefitInPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitInPostRepository extends JpaRepository<BenefitInPost, Long> {

    @Query("SELECT bp.benefitId FROM BenefitInPost bp WHERE bp.postId = ?1")
    List<Integer> findAllBenefitIdByPostId(Integer postId);

    BenefitInPost findByBenefitIdAndPostId(Integer benefitId, Integer postId);

    BenefitInPost findById(Integer id);

    @Query("DELETE FROM BenefitInPost b WHERE b.postId = ?1")
    @Modifying
    void deleteAllByPostId(Integer postId);
}
