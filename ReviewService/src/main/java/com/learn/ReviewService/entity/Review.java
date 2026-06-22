package com.learn.ReviewService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reviews")
public class Review {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private Long bookingId;
	 private Long hotelId;
	 private Long customerId;
	 private Integer rating;
	 private String comments;
	     
}
