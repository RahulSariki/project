package com.learn.AuthService.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.AuthService.dto.AuthResponse;
import com.learn.AuthService.dto.LoginRequest;
import com.learn.AuthService.dto.RegisterRequest;
import com.learn.AuthService.dto.UserResponse;
import com.learn.AuthService.entity.User;
import com.learn.AuthService.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(UserRepository repository, PasswordEncoder encoder, JwtService jwt) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        User savedUser = repository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getRole());
    }

    public AuthResponse login(LoginRequest request) {
        User user = repository.findByName(request.getName())
                .orElseThrow(() -> new RuntimeException("Invalid login"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid login");
        }

        String token = jwt.token(user);
        return new AuthResponse(token, user.getId(), user.getRole().name());
    }

}
