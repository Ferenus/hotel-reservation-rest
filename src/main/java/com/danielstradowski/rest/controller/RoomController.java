package com.danielstradowski.rest.controller;

import com.danielstradowski.rest.entity.RoomDTO;
import com.danielstradowski.rest.service.RoomService;
import com.danielstradowski.rest.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    public static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewRoom(@RequestBody RoomDTO room) {
        logger.info("Creating room : {}", room);

        if (roomService.isRoomExists(room)) {
            logger.error("Room with number {} already exists in the hotel with id {}.", room.getNumber(), room.getHotelId());
            return new ResponseEntity<>(new CustomErrorType("Room with number " +
                    room.getNumber() + " already exists in the hotel with id " + room.getHotelId()), HttpStatus.CONFLICT);
        }
        roomService.saveRoom(room);

        return new ResponseEntity<RoomDTO>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<RoomDTO>> getAvailableHotelRooms(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                                @RequestParam("city") String city,
                                                                @RequestParam("minDailyPrice") BigDecimal minDailyPrice, //@NumberFormat(pattern = "###.###,##")
                                                                @RequestParam("maxDailyPrice") BigDecimal maxDailyPrice) {
        List<RoomDTO> rooms = roomService.findAvailableHotelRooms(startDate, endDate, city, minDailyPrice, maxDailyPrice);

        return rooms.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
