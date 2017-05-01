package com.danielstradowski.rest.controller;

import com.danielstradowski.rest.entity.ReservationDTO;
import com.danielstradowski.rest.service.ReservationService;
import com.danielstradowski.rest.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    public static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> reserveRoom(@RequestBody ReservationDTO reservation) {
        logger.info("Creating reservation : {}", reservation);

        UUID roomId = reservation.getRoomId();
        if (reservationService.findRoomById(roomId) == null) {
            logger.error("Unable to make a reservation. Room with id {} not found.", roomId);
            return new ResponseEntity<>(new CustomErrorType("Unable to make a reservation. Room with id " + roomId + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        UUID customerId = reservation.getCustomerId();
        if (reservationService.findCustomerById(customerId) == null) {
            logger.error("Unable to make a reservation. Customer with id {} not found.", customerId);
            return new ResponseEntity<>(new CustomErrorType("Unable to make a reservation. Customer with id " + customerId + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        if (reservationService.isReservationExists(reservation)) {
            logger.error("Reservation {} already exists.", reservation);
            return new ResponseEntity<>(new CustomErrorType("Reservation already exists."), HttpStatus.CONFLICT);
        }
        reservationService.saveReservation(reservation);

        return new ResponseEntity<ReservationDTO>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerReservations(@RequestParam("customerId") UUID customerId) {
        if (reservationService.findCustomerById(customerId) == null) {
            logger.error("Customer with id {} not found.", customerId);
            return new ResponseEntity<>(new CustomErrorType("Customer with id " + customerId + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        List<ReservationDTO> reservations = reservationService.findReservationsByCustomerId(customerId);

        return reservations.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/cancel", method = RequestMethod.PUT)
    public ResponseEntity<?> cancelReservation(@PathVariable("id") UUID id) {
        logger.info("Canceling reservation with id {}", id);

        ReservationDTO reservation = reservationService.findReservationById(id);
        if (reservation == null) {
            logger.error("Unable to cancel. Reservation with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to cancel. Reservation with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        reservation.setCanceled(true);
        reservationService.updateReservation(reservation);

        return new ResponseEntity<ReservationDTO>(reservation, HttpStatus.OK);
    }
}
