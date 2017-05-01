package com.danielstradowski.rest.controller;

import com.danielstradowski.rest.entity.HotelDTO;
import com.danielstradowski.rest.service.HotelService;
import com.danielstradowski.rest.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    public static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> registerHotel(@RequestBody HotelDTO hotel) {
        logger.info("Creating hotel : {}", hotel);

        if (hotelService.isHotelExists(hotel)) {
            logger.error("Hotel with name {} already exists.", hotel.getName());
            return new ResponseEntity<>(new CustomErrorType("Hotel with name " +
                    hotel.getName() + " already exists."), HttpStatus.CONFLICT);
        }
        hotelService.saveHotel(hotel);

        return new ResponseEntity<HotelDTO>(HttpStatus.CREATED);
    }
}
