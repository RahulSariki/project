package com.learn.roomservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.roomservice.entity.Room;

public interface RoomRepository
        extends JpaRepository<Room, Long> {

    List<Room> findByHotelId(Long hotelId);
}