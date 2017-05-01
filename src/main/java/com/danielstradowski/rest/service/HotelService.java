package com.danielstradowski.rest.service;

import com.danielstradowski.rest.entity.HotelDTO;

public interface HotelService {

    void saveHotel(HotelDTO hotelDTO);

    boolean isHotelExists(HotelDTO hotelDTO);
}
