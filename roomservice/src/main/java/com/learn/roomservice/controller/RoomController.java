package com.learn.roomservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.learn.roomservice.dto.RoomRequest;
import com.learn.roomservice.dto.RoomResponse;
import com.learn.roomservice.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public RoomResponse addRoom(
            @RequestBody RoomRequest request) {

        return service.addRoom(request);
    }

    @GetMapping
    public List<RoomResponse> getAllRooms() {

        return service.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomResponse getRoomById(
            @PathVariable Long id) {

        return service.getRoomById(id);
    }

    @PutMapping("/{id}")
    public RoomResponse updateRoom(
            @PathVariable Long id,
            @RequestBody RoomRequest request) {

        return service.updateRoom(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(
            @PathVariable Long id) {

        service.deleteRoom(id);

        return "Room Deleted Successfully";
    }

    @GetMapping("/hotel/{hotelId}")
    public List<RoomResponse> getRoomsByHotelId(
            @PathVariable Long hotelId) {

        return service.getRoomsByHotelId(hotelId);
    }
}
