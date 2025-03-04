package com.example.securityex4.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class UserRegisterDTO {
    private String username;
    private String password;
    private String email;

    private List<String> roles;

}
