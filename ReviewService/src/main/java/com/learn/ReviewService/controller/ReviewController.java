package com.learn.ReviewService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.ReviewService.entity.Review;
import com.learn.ReviewService.service.reviewservice;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final reviewservice service;

    public ReviewController(reviewservice service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Review review) {
        try {
            Review savedReview = service.save(review);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedReview);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> all() {
        List<Review> reviews = service.all();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        try {
            Review review = service.findById(id);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Review not found with id: " + id);
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<?> byHotel(@PathVariable Long hotelId) {
        List<Review> reviews = service.byHotel(hotelId);
        return ResponseEntity.ok(reviews);
    }
}