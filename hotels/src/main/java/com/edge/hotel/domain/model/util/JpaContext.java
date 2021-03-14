//package com.edge.hotel.domain.model.util;
//
//import com.edge.hotel.domain.model.aggregates.HotelFacilities;
//import com.edge.hotel.domain.model.aggregates.Hotels;
//import com.edge.hotel.domain.model.aggregates.Rooms;
//import org.mapstruct.AfterMapping;
//import org.mapstruct.BeforeMapping;
//import org.mapstruct.MappingTarget;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//public class JpaContext {
//    private final EntityManager em;
//
//    private Hotels hotels;
//
//    public JpaContext(EntityManager em) {
//        this.em = em;
//    }
//
//    @BeforeMapping
//    public void setEntity(@MappingTarget Hotels hotels) {
//        this.hotels = hotels;
//    }
//
//    @AfterMapping
//    public void establishRelation(@MappingTarget Hotels hotels) {
//        hotels.setRooms( rooms );
//        // you could do stuff with the EntityManager here
//    }
//}
