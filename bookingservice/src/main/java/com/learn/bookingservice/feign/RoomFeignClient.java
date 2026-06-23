package com.learn.bookingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.learn.bookingservice.dto.RoomResponse;

@FeignClient(name = "roomservice")
public interface RoomFeignClient {

    @GetMapping("/rooms/{id}")
    RoomResponse getRoomById(
            @PathVariable Long id);
}