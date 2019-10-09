package com.giang.repository;

import com.giang.repository.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query("SELECT t.id FROM Type t")
    List<Integer> findAllId();

    @Query("SELECT t.typeName FROM Type t WHERE t.id = ?1")
    String findTypeNameById(Integer id);
}
