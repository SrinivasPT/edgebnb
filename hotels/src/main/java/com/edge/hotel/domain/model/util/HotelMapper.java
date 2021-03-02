package com.edge.hotel.domain.model.util;

import com.edge.hotel.application.dto.HotelsDto;
import com.edge.hotel.domain.model.aggregates.Hotels;
import org.mapstruct.Mapper;

@Mapper
public interface HotelMapper {
    Hotels toEntity(HotelsDto hotelsDto);
}
