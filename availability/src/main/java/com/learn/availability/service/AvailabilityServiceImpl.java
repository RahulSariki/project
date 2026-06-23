package com.learn.availability.service;

import org.springframework.stereotype.Service;

import com.learn.availability.dto.AvailabilityRequest;
import com.learn.availability.dto.AvailabilityResponse;
import com.learn.availability.entity.Availability;
import com.learn.availability.exception.AvailabilityNotFoundException;
import com.learn.availability.repository.AvailabilityRepository;

@Service
public class AvailabilityServiceImpl
        implements AvailabilityService {

    private final AvailabilityRepository repository;

    public AvailabilityServiceImpl(
            AvailabilityRepository repository) {

        this.repository = repository;
    }

    @Override
    public AvailabilityResponse addAvailability(
            AvailabilityRequest request) {

        Availability availability =
                new Availability();

        availability.setRoomId(
                request.getRoomId());

        availability.setAvailable(
                request.getAvailable());

        return mapToResponse(
                repository.save(availability));
    }

    @Override
    public AvailabilityResponse getAvailabilityByRoomId(
            Long roomId) {

        Availability availability =
                repository.findByRoomId(roomId)
                        .orElseThrow(() ->
                                new AvailabilityNotFoundException(
                                        "Availability Not Found"));

        return mapToResponse(availability);
    }

    @Override
    public AvailabilityResponse updateAvailability(
            Long roomId,
            Boolean available) {

        Availability availability =
                repository.findByRoomId(roomId)
                        .orElseThrow(() ->
                                new AvailabilityNotFoundException(
                                        "Availability Not Found"));

        availability.setAvailable(available);

        return mapToResponse(
                repository.save(availability));
    }

    private AvailabilityResponse mapToResponse(
            Availability availability) {

        AvailabilityResponse response =
                new AvailabilityResponse();

        response.setAvailabilityId(
                availability.getAvailabilityId());

        response.setRoomId(
                availability.getRoomId());

        response.setAvailable(
                availability.getAvailable());

        return response;
    }
}