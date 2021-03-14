package com.edge.hotel.application.dto;

import lombok.Data;

@Data
public class RoomFacilitiesDto {
    private Long id;
    private Long facilityId;
    private Long version;
    private boolean isActive;
}
