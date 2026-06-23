package com.learn.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.bookingservice.entity.Booking;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);
}
