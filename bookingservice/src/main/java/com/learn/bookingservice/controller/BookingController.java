package com.learn.bookingservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.bookingservice.dto.*;
import com.learn.bookingservice.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestBody BookingRequest request) {

        try {
            System.out.println("hi");

            BookingResponse response =
                    service.createBooking(request);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(
            @PathVariable Long id) {

        try {
            BookingResponse response =
                    service.getBookingById(id);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Booking not found with id: " + id);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getBookings(
            @PathVariable Long customerId) {

        try {
            List<BookingResponse> bookings =
                    service.getBookingsByCustomer(customerId);

            return ResponseEntity.ok(bookings);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No bookings found for customer id: " + customerId);
        }
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<?> cancelBooking(
            @PathVariable Long id) {

        try {
            BookingResponse response =
                    service.cancelBooking(id);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}