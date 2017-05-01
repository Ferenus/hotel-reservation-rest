package com.danielstradowski.persistence.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Room {

    @Id
    @Type(type="uuid-char")
    private UUID id;

    @Column
    private long number;

    @Column
    @Type(type="uuid-char")
    private UUID hotelId;

    public Room() {
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
