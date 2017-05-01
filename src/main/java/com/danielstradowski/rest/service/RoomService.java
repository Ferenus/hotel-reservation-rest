package com.danielstradowski.rest.service;

import com.danielstradowski.rest.entity.RoomDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RoomService {

    void saveRoom(RoomDTO roomDTO);

    boolean isRoomExists(RoomDTO roomDTO);

    List<RoomDTO> findAvailableHotelRooms(Date startDate, Date endDate, String city, BigDecimal minDailyPrice, BigDecimal maxDailyPrice);
}
