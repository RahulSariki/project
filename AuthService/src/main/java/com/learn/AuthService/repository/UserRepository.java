package com.learn.AuthService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.AuthService.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    
}
