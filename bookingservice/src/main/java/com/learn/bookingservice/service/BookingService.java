package com.learn.bookingservice.service;


import java.util.List;

import com.learn.bookingservice.dto.*;

public interface BookingService {

    BookingResponse createBooking(
            BookingRequest request);

    BookingResponse getBookingById(
            Long bookingId);

    List<BookingResponse> getBookingsByCustomer(
            Long customerId);

    BookingResponse cancelBooking(
            Long bookingId);
    
}

