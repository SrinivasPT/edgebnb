package com.edge.hotel.domain.model.util;

import com.edge.hotel.application.dto.HotelFacilitiesDto;
import com.edge.hotel.application.dto.HotelsDto;
import com.edge.hotel.application.dto.RoomsDto;
import com.edge.hotel.domain.model.aggregates.HotelFacilities;
import com.edge.hotel.domain.model.aggregates.Hotels;
import com.edge.hotel.domain.model.aggregates.Rooms;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface HotelMapper {
    @Mapping(source = "hotelsDto.hotelFacilitiesDto", target = "hotels.hotelFacilities")
    @Mapping(source = "hotelsDto.roomsDto", target = "hotels.rooms")
    Hotels toEntity(HotelsDto hotelsDto, @MappingTarget Hotels hotels);

    @Mapping(source = "hotelFacilitiesDto", target = "hotelFacilities")
    @Mapping(source = "roomsDto", target = "rooms")
    Hotels toEntity(HotelsDto hotelsDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "hotelFacilitiesDto.id", target = "hotelFacilities.id")
    List<HotelFacilities> fromHotelFacilitiesDtoToHotelFacilities(List<HotelFacilitiesDto> hotelFacilitiesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "roomsDto.id", target = "rooms.id")
    List<Rooms> fromRoomsDtoToRooms(List<RoomsDto> roomsDto);
}
