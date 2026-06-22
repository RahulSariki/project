package com.learn.hotelservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.hotelservice.entity.Hotel;
import com.learn.hotelservice.entity.HotelCategory;

public interface HotelRepository
        extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCityIgnoreCase(String city);

    List<Hotel> findByCategory(HotelCategory category);
}
