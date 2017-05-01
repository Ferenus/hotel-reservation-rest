package com.danielstradowski.persistence.dao;

import com.danielstradowski.persistence.model.Reservation;

import java.util.List;

public interface ReservationDao {

    void create(Reservation reservation);

    void update(Reservation reservation);

    List<Reservation> getReservationsByCustomerId(String id);

    Reservation findReservationById(String id);
}
