package com.learn.hotelservice.dto;

import com.learn.hotelservice.entity.HotelCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelRequest {

    @NotBlank(message = "Hotel Name Required")
    private String hotelName;

    @NotBlank(message = "City Required")
    private String city;

    @NotBlank(message = "Address Required")
    private String address;

    private String description;

    @NotNull(message = "Category Required")
    private HotelCategory category;

    @NotNull(message = "Owner Id Required")
    private Long ownerId;
}
