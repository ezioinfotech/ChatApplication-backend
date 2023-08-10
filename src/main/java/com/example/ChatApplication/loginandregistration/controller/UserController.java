package com.example.ChatApplication.loginandregistration.controller;

import com.example.ChatApplication.handler.ResponseHandler;
import com.example.ChatApplication.loginandregistration.dto.UserDTO;
import com.example.ChatApplication.loginandregistration.entity.User;
import com.example.ChatApplication.loginandregistration.exceptions.LoginExceptions;
import com.example.ChatApplication.loginandregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "helloworld";
    }


    @PostMapping("/register")
    public User getLoginSaved(@RequestBody UserDTO userDTO) throws LoginExceptions {

        if (userService.existByEmail(userDTO.getEmail())) {
            throw new LoginExceptions(("User Already Registered"));
        }
        return userService.save(userDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<Object> getLogin(@RequestBody UserDTO userDTO) throws LoginExceptions {
        User user = userService.findUserByEmail(userDTO.getEmail());

        if (Objects.equals(user.getPassword(), userDTO.getPassword())) {
            return ResponseHandler.generateResponse("Successfully login", HttpStatus.OK, user);
        } else {
            throw new LoginExceptions(("Password incorrect"));
        }

    }

    @GetMapping("/logout")
    public ResponseEntity<Object> getSignOut() {
        return ResponseHandler.generateResponse("Successfully Sign Out", HttpStatus.OK);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PutMapping("/change-status/{userId}")
    public ResponseEntity<Object> changeStatus(@PathVariable Long userId) throws Exception {
        Optional<User> user = userService.findByUserId(userId);

        if (user.isPresent()) {
            userService.editOnlineStatus(userId);
            return ResponseHandler.generateResponse("Active Status Changed", HttpStatus.OK, user);
        }
        throw new LoginExceptions("Couldn't find");

    }
}
