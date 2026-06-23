package com.learn.bookingservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learn.bookingservice.dto.*;
import com.learn.bookingservice.entity.*;
import com.learn.bookingservice.exception.BookingNotFoundException;
import com.learn.bookingservice.feign.AvailabilityFeignClient;
import com.learn.bookingservice.feign.HotelFeignClient;
import com.learn.bookingservice.feign.RoomFeignClient;
import com.learn.bookingservice.repository.BookingRepository;

@Service
public class BookingServiceImpl
        implements BookingService {

    private final BookingRepository repository;
    private final HotelFeignClient hotelFeignClient;
    private final RoomFeignClient roomFeignClient;
    private final AvailabilityFeignClient availabilityFeignClient;

    public BookingServiceImpl(
            BookingRepository repository,
            HotelFeignClient hotelFeignClient,
            RoomFeignClient roomFeignClient,
            AvailabilityFeignClient availabilityFeignClient) {

        this.repository = repository;
        this.hotelFeignClient = hotelFeignClient;
        this.roomFeignClient = roomFeignClient;
        this.availabilityFeignClient = availabilityFeignClient;
    }
    @Override
   
    public BookingResponse createBooking(
            BookingRequest request) {

        hotelFeignClient.getHotelById(
                request.getHotelId());

        roomFeignClient.getRoomById(
                request.getRoomId());

        AvailabilityResponse availability =
                availabilityFeignClient
                        .getAvailability(
                                request.getRoomId());

        if (!availability.getAvailable()) {

            throw new RuntimeException(
                    "Room Not Available");
        }

        Booking booking = new Booking();

        booking.setCustomerId(
                request.getCustomerId());

        booking.setHotelId(
                request.getHotelId());

        booking.setRoomId(
                request.getRoomId());

        booking.setCheckInDate(
                request.getCheckInDate());

        booking.setCheckOutDate(
                request.getCheckOutDate());

        booking.setBookingStatus(
                BookingStatus.CONFIRMED);

        Booking saved =
                repository.save(booking);

        availabilityFeignClient
                .updateAvailability(
                        request.getRoomId(),
                        false);

        return mapToResponse(saved);
    }

    @Override
    public BookingResponse getBookingById(
            Long bookingId) {

        Booking booking = repository.findById(
                        bookingId)
                .orElseThrow(() ->
                        new BookingNotFoundException(
                                "Booking Not Found"));

        return mapToResponse(booking);
    }

    @Override
    public List<BookingResponse>
    getBookingsByCustomer(
            Long customerId) {

        return repository.findByCustomerId(
                        customerId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse cancelBooking(
            Long bookingId) {

        Booking booking =
                repository.findById(bookingId)
                        .orElseThrow(() ->
                                new BookingNotFoundException(
                                        "Booking Not Found"));

        booking.setBookingStatus(
                BookingStatus.CANCELLED);

        Booking saved =
                repository.save(booking);

        availabilityFeignClient
                .updateAvailability(
                        booking.getRoomId(),
                        true);

        return mapToResponse(saved);
    }

    private BookingResponse mapToResponse(
            Booking booking) {

        BookingResponse response =
                new BookingResponse();

        response.setBookingId(
                booking.getBookingId());

        response.setCustomerId(
                booking.getCustomerId());

        response.setHotelId(
                booking.getHotelId());

        response.setRoomId(
                booking.getRoomId());

        response.setCheckInDate(
                booking.getCheckInDate());

        response.setCheckOutDate(
                booking.getCheckOutDate());

        response.setBookingStatus(
                booking.getBookingStatus());

        return response;
    }
}