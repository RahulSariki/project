package com.learn.PaymentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payment")
public class Payment{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    private Long bookingId;
    private Long customerId;
    private Double amount;
    @Enumerated(EnumType.STRING) 
    private PaymentMode mode;
    @Enumerated(EnumType.STRING) 
    private PaymentStatus status=PaymentStatus.SUCCESS;
   
}