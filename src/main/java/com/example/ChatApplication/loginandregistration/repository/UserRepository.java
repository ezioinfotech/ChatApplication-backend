package com.example.ChatApplication.loginandregistration.repository;

import com.example.ChatApplication.loginandregistration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String user_name);

    Boolean existsByEmail(String email);

    User findUserByEmail(String email);

//    User updateUserByUserId(Long user_id);

}
