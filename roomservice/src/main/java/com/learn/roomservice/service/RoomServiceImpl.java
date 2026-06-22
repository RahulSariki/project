package com.learn.roomservice.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learn.roomservice.dto.RoomRequest;
import com.learn.roomservice.dto.RoomResponse;
import com.learn.roomservice.entity.Room;
import com.learn.roomservice.exception.RoomNotFoundException;
import com.learn.roomservice.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomResponse addRoom(RoomRequest request) {

        Room room = new Room();

        room.setHotelId(request.getHotelId());
        room.setRoomType(request.getRoomType());
        room.setPrice(request.getPrice());
        room.setCapacity(request.getCapacity());

        return mapToResponse(repository.save(room));
    }

    @Override
    public RoomResponse getRoomById(Long id) {

        Room room = repository.findById(id)
                .orElseThrow(() ->
                        new RoomNotFoundException(
                                "Room Not Found"));

        return mapToResponse(room);
    }

    @Override
    public List<RoomResponse> getAllRooms() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponse updateRoom(
            Long id,
            RoomRequest request) {

        Room room = repository.findById(id)
                .orElseThrow(() ->
                        new RoomNotFoundException(
                                "Room Not Found"));

        room.setHotelId(request.getHotelId());
        room.setRoomType(request.getRoomType());
        room.setPrice(request.getPrice());
        room.setCapacity(request.getCapacity());

        return mapToResponse(repository.save(room));
    }

    @Override
    public void deleteRoom(Long id) {

        if (!repository.existsById(id)) {

            throw new RoomNotFoundException(
                    "Room Not Found");
        }

        repository.deleteById(id);
    }

    @Override
    public List<RoomResponse> getRoomsByHotelId(
            Long hotelId) {

        return repository.findByHotelId(hotelId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RoomResponse mapToResponse(
            Room room) {

        RoomResponse response =
                new RoomResponse();

        response.setRoomId(room.getRoomId());
        response.setHotelId(room.getHotelId());
        response.setRoomType(room.getRoomType());
        response.setPrice(room.getPrice());
        response.setCapacity(room.getCapacity());

        return response;
    }
}
