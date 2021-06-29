package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;
}
