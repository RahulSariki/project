package com.learn.NotificationService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.NotificationService.dto.NotificationRequest;
import com.learn.NotificationService.entity.Notification;
import com.learn.NotificationService.repository.NotificationRepository;

@Service
public class NotificationService {
	
	private final NotificationRepository repository;
	
	public NotificationService(NotificationRepository repository) {
		this.repository=repository;
	}
	
	public Notification sendNotification(NotificationRequest request) {
	    Notification notification = Notification.builder()
	            .customerId(request.getCustomerId())
	            .message(request.getMessage())
	            .status(request.getStatus())
	            .build();

	    return repository.save(notification);
	}


	    public List<Notification> getNotificationsByCustomer(Long customerId) {
	        return repository.findBycustomerId(customerId);
	    }
}
