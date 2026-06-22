package com.learn.hotelservice.dto;



import com.learn.hotelservice.entity.HotelCategory;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponse {

    private Long hotelId;

    private String hotelName;

    private String city;

    private String address;

    private String description;

    private HotelCategory category;

    private Long ownerId;
}
