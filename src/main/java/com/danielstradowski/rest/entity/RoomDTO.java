package com.danielstradowski.rest.entity;

import java.util.UUID;

public class RoomDTO {

    private UUID id;

    private UUID hotelId;

    private long number;

    public RoomDTO() {
    }

    public RoomDTO(UUID id, UUID hotelId, long number) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
