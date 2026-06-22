package com.learn.PaymentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.PaymentService.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{
    List<Payment> findByCustomerId(Long customerId);
    }
