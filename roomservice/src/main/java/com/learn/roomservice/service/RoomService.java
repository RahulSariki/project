package com.learn.roomservice.service;

import java.util.List;

import com.learn.roomservice.dto.RoomRequest;
import com.learn.roomservice.dto.RoomResponse;

public interface RoomService {

    RoomResponse addRoom(RoomRequest request);

    RoomResponse getRoomById(Long id);

    List<RoomResponse> getAllRooms();

    RoomResponse updateRoom(
            Long id,
            RoomRequest request);

    void deleteRoom(Long id);

    List<RoomResponse> getRoomsByHotelId(
            Long hotelId);
}