package com.giang.repository;

import com.giang.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneAndPassword(String username, String password);

    User findById(Integer id);

    User findByPhone(String username);





}
