package com.example.ChatApplication.loginandregistration.service;

import com.example.ChatApplication.loginandregistration.dto.UserDTO;
import com.example.ChatApplication.loginandregistration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ChatApplication.loginandregistration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getPassword(), true,
                userDTO.getFullName(), userDTO.getEmail(), userDTO.getPhoneNumber());
        return userRepository.save(user);
    }

    @Override
    public Boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void editOnlineStatus(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setOnline(!user.getOnline());
            userRepository.save(user);
        }
    }

}
