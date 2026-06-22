package com.learn.ReviewService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ReviewService.entity.Review;
import com.learn.ReviewService.service.reviewservice;

@RestController 
@RequestMapping("/reviews") 
public class ReviewController{
	
    private final reviewservice service; 
    
    public ReviewController(reviewservice service){
    	this.service=service;
    }
    
    @PostMapping 
    public Review create(@RequestBody Review e){
    	return service.save(e);
    }
    @GetMapping
    public List<Review> all(){
    	return service.all();
    }
    @GetMapping("/{id}")
    public Review one(@PathVariable Long id){
    	return service.findById(id);
    }
    @GetMapping("/hotel/{hotelId}")
    public List<Review> byHotel(@PathVariable Long hotelId){
    	return service.byHotel(hotelId);
    }
  }
