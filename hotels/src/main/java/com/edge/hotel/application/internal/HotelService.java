package com.edge.hotel.application.internal;

import com.edge.hotel.domain.model.aggregates.Hotel;
import com.edge.hotel.domain.model.aggregates.HotelId;
import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import com.edge.hotel.infrastructure.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Long createHotel(CreateHotelCommand command) {
        Hotel hotel = new Hotel(command);
        hotel = hotelRepository.save(hotel);
        System.out.println("Created new hotel and it's ID = " + hotel.getId());
        return hotel.getId();
    }

    public Long updateHotel(CreateHotelCommand command) {
        Hotel hotel = hotelRepository.getOne(command.getId());
        hotel.setName(command.getName());
        hotel.setDescription(command.getDescription());
        hotel.setDisplayImagePath(command.getDisplayImagePath());
        hotel.setOriginalImagePath(command.getOriginalImagePath());
        hotelRepository.save(hotel);
        System.out.println("Created new hotel and it's ID = " + hotel.getId().toString());
        return hotel.getId();
    }
}
