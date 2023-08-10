package com.example.ChatApplication.loginandregistration.service;


import com.example.ChatApplication.loginandregistration.dto.UserDTO;
import com.example.ChatApplication.loginandregistration.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUsername(String userName);
    User save(UserDTO userDTO);

    Boolean existByEmail(String email);

    User findUserByEmail(String email);

    List<User> findAll();

    Optional<User> findByUserId(Long userId);

    void editOnlineStatus(Long userId);

}
