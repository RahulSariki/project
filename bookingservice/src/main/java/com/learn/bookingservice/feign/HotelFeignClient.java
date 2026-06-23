package com.learn.bookingservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.learn.bookingservice.dto.HotelResponse;

@FeignClient(name = "hotelservice")
public interface HotelFeignClient {

    @GetMapping("/hotels/{id}")
    HotelResponse getHotelById(
            @PathVariable Long id);
}
