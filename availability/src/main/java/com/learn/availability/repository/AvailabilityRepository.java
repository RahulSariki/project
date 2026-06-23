package com.learn.availability.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.availability.entity.Availability;

public interface AvailabilityRepository
        extends JpaRepository<Availability, Long> {

    Optional<Availability> findByRoomId(Long roomId);
}
