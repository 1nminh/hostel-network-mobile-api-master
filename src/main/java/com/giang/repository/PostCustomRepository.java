package com.giang.repository;

import com.giang.repository.entity.PostCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCustomRepository extends JpaRepository<PostCustom, Long> {
    @Query("SELECT DISTINCT p.id FROM PostCustom p LEFT JOIN p.listBenefit b ON p.id = b.postId " +
            "WHERE b.benefitId in ?1 " +
            "AND p.typeId = ?2 " +
            "AND p.location LIKE ?3 " +
            "AND p.price >= ?4  AND p.price <= ?5")
    List<Integer> filter(List<Integer> benefitIds, Integer typeId, String location, Double minPrice, Double maxPrice);

    @Query("SELECT DISTINCT p.id FROM PostCustom p LEFT JOIN p.listBenefit b ON p.id = b.postId " +
            "WHERE p.typeId = ?1 " +
            "AND p.location LIKE ?2 " +
            "AND p.price >= ?3  AND p.price <= ?4")
    List<Integer> filterWithoutBenefit(Integer typeId, String location, Double minPrice, Double maxPrice);

    @Query("SELECT DISTINCT p.id FROM PostCustom p LEFT JOIN p.listBenefit b ON p.id = b.postId " +
            "WHERE b.benefitId in ?1 " +
            "AND p.location LIKE ?2 " +
            "AND p.price >= ?3  AND p.price <= ?4")
    List<Integer> filterWithoutType(List<Integer> benefitIds, String location, Double minPrice, Double maxPrice);

    @Query("SELECT DISTINCT p.id FROM PostCustom p LEFT JOIN p.listBenefit b ON p.id = b.postId " +
            "WHERE p.location LIKE ?1 " +
            "AND p.price >= ?2  AND p.price <= ?3")
    List<Integer> filterWithoutTypeAndBenefit(String location, Double minPrice, Double maxPrice);


}
