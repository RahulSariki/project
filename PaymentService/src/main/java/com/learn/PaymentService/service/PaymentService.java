package com.learn.PaymentService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.PaymentService.entity.Payment;
import com.learn.PaymentService.repository.PaymentRepository;

@Service 
public class PaymentService{
	
    private final PaymentRepository repository; 
    public PaymentService(PaymentRepository repository){
    	this.repository=repository;
    }
    
    public Payment save(Payment e){
    	return repository.save(e);
    }
    
    public Payment findById(Long id){
    	return repository.findById(id).orElseThrow(()->new RuntimeException("Payment not found"));
    }
    
    public List<Payment> all(){
    	return repository.findAll();
    }
    
    public List<Payment> byCustomer(Long id){
    	return repository.findByCustomerId(id);
    }
  }
