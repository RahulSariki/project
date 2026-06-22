package com.learn.PaymentService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.PaymentService.entity.Payment;
import com.learn.PaymentService.service.PaymentService;

@RestController 
@RequestMapping("/payments") 
public class PaymentController{
	
    private final PaymentService service; 
    
    public PaymentController(PaymentService service){
    	this.service=service;
    }
    
    @PostMapping
    public Payment create(@RequestBody Payment pay){
    	return service.save(pay);
    } 
    
    @GetMapping 
    public List<Payment> all(){
    	return service.all();
    }
    
    @GetMapping("/{id}") 
    public Payment one(@PathVariable Long id){
    	 return service.findById(id);
    }
    
    @GetMapping("/customer/{customerId}") 
    public List<Payment> byCustomer(@PathVariable Long customerId){
    	 return service.byCustomer(customerId);
    }
    
 }

