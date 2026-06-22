package com.learn.NotificationService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.NotificationService.dto.NotificationRequest;
import com.learn.NotificationService.entity.Notification;
import com.learn.NotificationService.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	private NotificationService service;
	
	public NotificationController(NotificationService service) {
		this.service=service;
	}
	
	@PostMapping("/send")
    public ResponseEntity<Notification> sendNotification(@Valid @RequestBody NotificationRequest request) {
		
        return ResponseEntity.ok(service.sendNotification(request));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Notification>> getNotificationsByCustomer(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(service.getNotificationsByCustomer(customerId));
    }
}
