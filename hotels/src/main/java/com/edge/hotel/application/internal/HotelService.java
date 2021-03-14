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

    private HotelMapper mapper = Mappers.getMapper(HotelMapper.class);

    public Long createHotel(CreateHotelCommand command) {
        Hotels hotels = new Hotels(command);
        hotels = hotelRepository.save(hotels);
        System.out.println("Created new hotel and it's ID = " + hotels.getId());
        return hotels.getId();
    }

    public Long createHotelv1(HotelsDto hotelsDto) {
        System.out.println("hotel.toString() = " + hotelsDto.toString());
        Hotels hotels = mapper.toEntity(hotelsDto);
        hotels = hotelRepository.save(hotels);
        System.out.println("Created new hotel and it's ID = " + hotels.getId());
        return hotels.getId();
    }

//    public Long updateHotel(CreateHotelCommand command) {
//        Hotels hotels = hotelRepository.getOne(command.getId());
//        createUpdateHotelCommand(command, hotels);
//        hotelRepository.save(hotels);
//        System.out.println("Created new hotel and it's ID = " + hotels.getId().toString());
//        return hotels.getId();
//    }

    public void updateHotelv2(HotelsDto hotelsDto) {
        System.out.println("hotelsDto = " + hotelsDto);
        Hotels hotels = hotelRepository.getOne(hotelsDto.getId());
        hotels = mapper.toEntity(hotelsDto, hotels);
        System.out.println("hotels = " + hotels);
        hotelRepository.save(hotels);
    }

}
