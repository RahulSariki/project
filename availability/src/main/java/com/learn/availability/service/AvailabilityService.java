package com.learn.availability.service;

import com.learn.availability.dto.AvailabilityRequest;
import com.learn.availability.dto.AvailabilityResponse;

public interface AvailabilityService {

    AvailabilityResponse addAvailability(
            AvailabilityRequest request);

    AvailabilityResponse getAvailabilityByRoomId(
            Long roomId);

    AvailabilityResponse updateAvailability(
            Long roomId,
            Boolean available);
}