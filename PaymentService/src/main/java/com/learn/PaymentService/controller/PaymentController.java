package com.learn.PaymentService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.PaymentService.entity.Payment;
import com.learn.PaymentService.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Payment payment) {
        try {
            Payment savedPayment = service.save(payment);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedPayment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> all() {
        List<Payment> payments = service.all();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        try {
            Payment payment = service.findById(id);
            return ResponseEntity.ok(payment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Payment not found with id: " + id);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> byCustomer(@PathVariable Long customerId) {
        try {
            List<Payment> payments = service.byCustomer(customerId);
            return ResponseEntity.ok(payments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No payments found for customer id: " + customerId);
        }
    }
}