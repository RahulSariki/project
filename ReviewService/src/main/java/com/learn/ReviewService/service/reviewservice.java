package com.learn.ReviewService.service;

import org.springframework.stereotype.Service;

import com.learn.ReviewService.entity.Review;
import com.learn.ReviewService.repository.ReviewRepository;

import java.util.*;
@Service
 public class reviewservice{
    private final ReviewRepository repository;
     public reviewservice(ReviewRepository repository){
    	 this.repository=repository;
     }
     public Review save(Review e){
    	 return repository.save(e);
     }
     public Review findById(Long id){
    	 return repository.findById(id).orElseThrow(()->new RuntimeException("Review not found"));
     }
     public List<Review> all(){
    	 return repository.findAll();
     }
     public List<Review> byHotel(Long id){
    	 return repository.findByHotelId(id);
     }
     }