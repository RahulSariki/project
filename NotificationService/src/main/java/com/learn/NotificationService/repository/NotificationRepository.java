package com.learn.NotificationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.NotificationService.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	 List<Notification> findBycustomerId(Long customerId);

}
