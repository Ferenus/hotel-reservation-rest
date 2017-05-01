package com.danielstradowski.rest.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class CustomerDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String telephone;

    private Date registrationDate;

    public CustomerDTO() {
    }

    public CustomerDTO(UUID id, String firstName, String lastName, String telephone, Date registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
