package com.learn.AuthService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank(message="Name is mandatory")
    private String name;
	@NotBlank(message="Password is mandatory")
    private String password;
}
