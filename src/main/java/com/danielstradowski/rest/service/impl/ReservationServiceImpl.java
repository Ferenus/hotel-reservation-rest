package com.danielstradowski.rest.service.impl;

import com.danielstradowski.rest.entity.CustomerDTO;
import com.danielstradowski.rest.entity.ReservationDTO;
import com.danielstradowski.rest.entity.RoomDTO;
import com.danielstradowski.rest.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Override
    public void saveReservation(ReservationDTO reservationDTO) {

    }

    @Override
    public void updateReservation(ReservationDTO reservationDTO) {

    }

    @Override
    public List<ReservationDTO> findReservationsByCustomerId(UUID customerId) {
        return null;
    }

    @Override
    public ReservationDTO findReservationById(UUID id) {
        return null;
    }

    @Override
    public boolean isReservationExists(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public RoomDTO findRoomById(UUID id) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(UUID id) {
        return null;
    }
}
