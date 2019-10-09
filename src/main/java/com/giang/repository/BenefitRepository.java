package com.giang.repository;

import com.giang.repository.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    @Query("SELECT b FROM Benefit b WHERE b.id in ?1")
    List<Benefit> findAllByIdIn(List<Integer> ids);

    @Query("SELECT b.id FROM Benefit b")
    List<Integer> findAllId();
}
