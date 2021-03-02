package com.edge.hotel.application.internal;

import com.edge.hotel.application.dto.HotelsDto;
import com.edge.hotel.domain.model.aggregates.Hotels;
import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import com.edge.hotel.domain.model.util.HotelMapper;
import com.edge.hotel.infrastructure.repository.HotelRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelMapper mapper;

    public Long createHotel(CreateHotelCommand command) {
        Hotels hotels = new Hotels(command);
        hotels = hotelRepository.save(hotels);
        System.out.println("Created new hotel and it's ID = " + hotels.getId());
        return hotels.getId();
    }

    public Long createHotelv1(Hotels hotel) {
        System.out.println("hotel.toString() = " + hotel.toString());
        hotel = hotelRepository.save(hotel);
        System.out.println("Created new hotel and it's ID = " + hotel.getId());
        return hotel.getId();
    }

//    public Long updateHotel(CreateHotelCommand command) {
//        Hotels hotels = hotelRepository.getOne(command.getId());
//        createUpdateHotelCommand(command, hotels);
//        hotelRepository.save(hotels);
//        System.out.println("Created new hotel and it's ID = " + hotels.getId().toString());
//        return hotels.getId();
//    }

    public Long updateHotelv2(HotelsDto hotelsDto) {
        Hotels hotels = hotelRepository.getOne(hotelsDto.getId());
        mapper.toEntity(hotelsDto);
        hotelRepository.save(hotels);
        System.out.println("Created new hotel and it's ID = " + hotels.getId().toString());
        return hotels.getId();
    }

}
