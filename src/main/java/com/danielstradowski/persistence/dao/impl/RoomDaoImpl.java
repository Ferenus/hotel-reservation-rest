package com.danielstradowski.persistence.dao.impl;

import com.danielstradowski.persistence.dao.RoomDao;
import com.danielstradowski.persistence.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Room room) {
        entityManager.persist(room);
    }

    @Override
    public Room getRoomById(UUID id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public List<Room> findAvailableHotelRooms(Date startDate, Date endDate, String city, BigDecimal minDailyPrice, BigDecimal maxDailyPrice) {
        return entityManager.createQuery(
                "SELECT c FROM Room c")
                .getResultList();
    }
}
