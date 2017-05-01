package com.danielstradowski.persistence.dao;

import com.danielstradowski.persistence.model.Room;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface RoomDao {
    void create(Room room);

    Room getRoomById(UUID id);

    List<Room> findAvailableHotelRooms(Date startDate, Date endDate, String city, BigDecimal minDailyPrice, BigDecimal maxDailyPrice);
}
