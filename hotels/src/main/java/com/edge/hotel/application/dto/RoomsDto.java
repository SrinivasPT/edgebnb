package com.edge.hotel.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomsDto {
    private Long id;
    private String name;
    private Long quantity;
    private Long maxPrice;
    private Long minPrice;
    private List<RoomFacilitiesDto> roomFacilitiesDto;
}
