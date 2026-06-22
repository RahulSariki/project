package com.learn.NotificationService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Long customerId;   

    @Column(nullable = false, length = 100)
    private String message;

    @Column(nullable = false)
    private String status; 
}
