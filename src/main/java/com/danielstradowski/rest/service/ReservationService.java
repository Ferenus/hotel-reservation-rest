package com.danielstradowski.rest.service;

import com.danielstradowski.rest.entity.CustomerDTO;
import com.danielstradowski.rest.entity.ReservationDTO;
import com.danielstradowski.rest.entity.RoomDTO;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    void saveReservation(ReservationDTO reservationDTO);

    void updateReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> findReservationsByCustomerId(UUID customerId);

    ReservationDTO findReservationById(UUID id);

    boolean isReservationExists(ReservationDTO reservationDTO);

    RoomDTO findRoomById(UUID id);

    CustomerDTO findCustomerById(UUID id);
}
