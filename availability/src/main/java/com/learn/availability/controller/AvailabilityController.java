package com.learn.availability.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.availability.dto.AvailabilityRequest;
import com.learn.availability.dto.AvailabilityResponse;
import com.learn.availability.service.AvailabilityService;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    private final AvailabilityService service;

    public AvailabilityController(AvailabilityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addAvailability(
            @RequestBody AvailabilityRequest request) {

        try {
            AvailabilityResponse response =
                    service.addAvailability(request);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getAvailability(
            @PathVariable Long roomId) {

        try {
            AvailabilityResponse response =
                    service.getAvailabilityByRoomId(roomId);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Availability not found for room id: " + roomId);
        }
    }

    @PutMapping("/update/{roomId}")
    public ResponseEntity<?> updateAvailability(
            @PathVariable Long roomId,
            @RequestParam Boolean available) {

        try {
            AvailabilityResponse response =
                    service.updateAvailability(roomId, available);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}