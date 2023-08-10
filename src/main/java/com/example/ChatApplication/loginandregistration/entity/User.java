package com.example.ChatApplication.loginandregistration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private Boolean online = true;
    private String fullName;
    private String email;
    private String phoneNumber;

    public User(String userName, String password, Boolean online, String fullName, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.online = online;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
