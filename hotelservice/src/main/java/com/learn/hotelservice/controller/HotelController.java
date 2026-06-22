package com.learn.hotelservice.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learn.hotelservice.dto.HotelRequest;
import com.learn.hotelservice.dto.HotelResponse;
import com.learn.hotelservice.service.HotelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService service;
		@PostMapping
        public ResponseEntity<HotelResponse> addHotel(@Valid @RequestBody HotelRequest request) {
            HotelResponse response = service.addHotel(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @GetMapping
        public ResponseEntity<List<HotelResponse>> getAllHotels() {
            return ResponseEntity.ok(service.getAllHotels());
        }

        @GetMapping("/{id}")
        public ResponseEntity<HotelResponse> getHotelById(@PathVariable Long id) {
            return ResponseEntity.ok(service.getHotelById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<HotelResponse> updateHotel(
                @PathVariable Long id,
                @RequestBody HotelRequest request) {
            return ResponseEntity.ok(service.updateHotel(id, request));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
            service.deleteHotel(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/location/{city}")
        public ResponseEntity<List<HotelResponse>> getByCity(@PathVariable String city) {
            return ResponseEntity.ok(service.getHotelsByCity(city));
        }

        @GetMapping("/category/{category}")
        public ResponseEntity<List<HotelResponse>> getByCategory(@PathVariable String category) {
            return ResponseEntity.ok(service.getHotelsByCategory(category));
        }

        
    }


