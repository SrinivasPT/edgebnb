package com.edge.hotel.interfaces.rest;

import com.edge.hotel.application.dto.HotelsDto;
import com.edge.hotel.application.internal.HotelService;
import com.edge.hotel.domain.model.aggregates.Hotels;
import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("v1")
    public Long createHotel(@RequestBody CreateHotelCommand command) {
        return hotelService.createHotel(command);
    }

    @PostMapping("v2")
    public Long createHotel(@RequestBody HotelsDto command) {
        System.out.println("command.toString() = " + command.toString());
        return hotelService.createHotelv1(command);
    }

//    @PutMapping("v1")
//    public ResponseEntity<Long> updateHotel(@RequestBody CreateHotelCommand command) {
//        Long hotelId = hotelService.updateHotel(command);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @PutMapping("v2")
    public ResponseEntity<Long> updateHotel(@RequestBody HotelsDto hotelsDto) {
        hotelService.updateHotelv2(hotelsDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
