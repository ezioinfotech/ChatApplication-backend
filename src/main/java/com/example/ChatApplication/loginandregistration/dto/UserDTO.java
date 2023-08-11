package com.example.ChatApplication.loginandregistration.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class  UserDTO {
    private Long UserId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Boolean online;
}
