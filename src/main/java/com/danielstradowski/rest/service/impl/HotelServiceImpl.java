package com.danielstradowski.rest.service.impl;

import com.danielstradowski.rest.entity.HotelDTO;
import com.danielstradowski.rest.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    @Override
    public void saveHotel(HotelDTO hotelDTO) {

    }

    @Override
    public boolean isHotelExists(HotelDTO hotelDTO) {
        return false;
    }
}
