package com.danielstradowski.persistence.dao;

import com.danielstradowski.persistence.model.Hotel;

public interface HotelDao {

    void create(Hotel hotel);

    Hotel getHotelById(String id);
}
