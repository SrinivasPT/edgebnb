package com.edge.hotel.application.dto;

import lombok.Data;

@Data
public class HotelFacilitiesDto {
    private Long id;
    private Long facilityId;
    private Long version;
    private boolean isActive;
}
