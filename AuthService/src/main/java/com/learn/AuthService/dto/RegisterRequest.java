package com.learn.AuthService.dto;

import com.learn.AuthService.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
	
	@NotBlank(message="Name is mandatory")
    private String name;
	
	@Email(message="Email must be mandatory")
	@NotBlank(message="Email is mandatory")
    private String email;
	@Size(min=6,message="Password is mandatory",max=16)
    private String password;
    private Role role;
}
