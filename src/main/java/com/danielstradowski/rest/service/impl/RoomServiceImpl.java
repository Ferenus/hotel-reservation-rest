package com.danielstradowski.rest.service.impl;

import com.danielstradowski.rest.entity.RoomDTO;
import com.danielstradowski.rest.service.RoomService;
import com.danielstradowski.persistence.dao.RoomDao;
import com.danielstradowski.persistence.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public void saveRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setHotelId(roomDTO.getHotelId());
        room.setNumber(roomDTO.getNumber());
        roomDao.create(room);
    }

    @Override
    public boolean isRoomExists(RoomDTO roomDTO) {
        return roomDao.getRoomById(roomDTO.getId()) != null;
    }

    @Override
    public List<RoomDTO> findAvailableHotelRooms(Date startDate, Date endDate, String city, BigDecimal minDailyPrice, BigDecimal maxDailyPrice) {
        return roomDao.findAvailableHotelRooms(startDate, endDate, city, minDailyPrice, maxDailyPrice)
                .stream().map(this::mapRoomToRoomDTO).collect(Collectors.toList());
    }

    private RoomDTO mapRoomToRoomDTO(Room room) {
        return new RoomDTO(room.getId(), room.getHotelId(), room.getNumber());
    }
}
