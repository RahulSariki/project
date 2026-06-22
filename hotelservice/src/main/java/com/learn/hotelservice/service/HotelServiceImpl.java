package com.learn.hotelservice.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learn.hotelservice.dto.HotelRequest;
import com.learn.hotelservice.dto.HotelResponse;
import com.learn.hotelservice.entity.Hotel;
import com.learn.hotelservice.entity.HotelCategory;
import com.learn.hotelservice.exception.HotelNotFoundException;
import com.learn.hotelservice.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;
    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }
    
   
	@Override
    public HotelResponse addHotel(
            HotelRequest request) {

        Hotel hotel =  Hotel.builder()
                .hotelName(request.getHotelName())
                .city(request.getCity())
                .address(request.getAddress())
                .description(request.getDescription())
                .category(request.getCategory())
                .ownerId(request.getOwnerId())
                .build();
        

        return mapToResponse(
                repository.save(hotel));
    }

    @Override
    public HotelResponse getHotelById(Long id) {

        Hotel hotel = repository.findById(id)
                .orElseThrow(() ->
                        new HotelNotFoundException(
                                "Hotel Not Found"));

        return mapToResponse(hotel);
    }

    @Override
    public List<HotelResponse> getAllHotels() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponse updateHotel(
            Long id,
            HotelRequest request) {

        Hotel hotel = repository.findById(id)
                .orElseThrow(() ->
                        new HotelNotFoundException(
                                "Hotel Not Found"));

        hotel.setHotelName(request.getHotelName());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setDescription(request.getDescription());
        hotel.setCategory(request.getCategory());

        return mapToResponse(
                repository.save(hotel));
    }

    @Override
    public void deleteHotel(Long id) {

        if (!repository.existsById(id)) {

            throw new HotelNotFoundException(
                    "Hotel Not Found");
        }

        repository.deleteById(id);
    }

    @Override
    public List<HotelResponse> getHotelsByCity(
            String city) {

        return repository.findByCityIgnoreCase(city)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelResponse> getHotelsByCategory(
            String category) {

        HotelCategory hotelCategory =
                HotelCategory.valueOf(category);

        return repository.findByCategory(
                        hotelCategory)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private HotelResponse mapToResponse(
            Hotel hotel) {

        return HotelResponse.builder()
                .hotelId(hotel.getHotelId())
                .hotelName(hotel.getHotelName())
                .city(hotel.getCity())
                .address(hotel.getAddress())
                .description(hotel.getDescription())
                .category(hotel.getCategory())
                .ownerId(hotel.getOwnerId())
                .build();
    }
}