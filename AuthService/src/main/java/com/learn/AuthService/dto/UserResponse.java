package com.learn.AuthService.dto;

import com.learn.AuthService.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
	
    private Long id;
    private String name;
    private String email;
    private Role role;
}
