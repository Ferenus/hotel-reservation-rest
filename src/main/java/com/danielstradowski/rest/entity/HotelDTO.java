package com.danielstradowski.rest.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HotelDTO {

    private UUID id;

    private String name;

    private Date registrationDate;

    public HotelDTO() {
    }

    public HotelDTO(UUID id, String name, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
