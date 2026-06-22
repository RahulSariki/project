package com.learn.AuthService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.learn.AuthService.dto.AuthResponse;
import com.learn.AuthService.dto.LoginRequest;
import com.learn.AuthService.dto.RegisterRequest;
import com.learn.AuthService.dto.UserResponse;
import com.learn.AuthService.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}
