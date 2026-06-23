package com.learn.availability.dto;

public class AvailabilityRequest {

    private Long roomId;
    private Boolean available;

    public AvailabilityRequest() {
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
