package com.learn.hotelservice.service;


import java.util.List;

import com.learn.hotelservice.dto.HotelRequest;
import com.learn.hotelservice.dto.HotelResponse;



public interface HotelService {

    HotelResponse addHotel(
            HotelRequest request);

    HotelResponse getHotelById(Long id);

    List<HotelResponse> getAllHotels();

    HotelResponse updateHotel(
            Long id,
            HotelRequest request);

    void deleteHotel(Long id);

    List<HotelResponse> getHotelsByCity(
            String city);

    List<HotelResponse> getHotelsByCategory(
            String category);
}