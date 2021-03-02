package com.edge.hotel.application.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HotelsDto {
    private Long id;
    private String name;
    private Long localityId;
    private String description;
    private String originalImagePath;
    private String displayImagePath;
    private List<RoomsDto> rooms = new ArrayList<>();
    private List<HotelFacilitiesDto> hotelFacilitiesDto = new ArrayList<>();
}
