package com.learn.bookingservice.feign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.learn.bookingservice.dto.AvailabilityResponse;

@FeignClient(name = "availability")
public interface AvailabilityFeignClient {

    @GetMapping("/availability/{roomId}")
    AvailabilityResponse getAvailability(
            @PathVariable Long roomId);

    @PutMapping("/availability/update/{roomId}")
    AvailabilityResponse updateAvailability(
            @PathVariable Long roomId,
            @RequestParam Boolean available);
}