package com.learn.bookingservice.exception;


public class BookingNotFoundException
        extends RuntimeException {

    public BookingNotFoundException(String message) {
        super(message);
    }
}
