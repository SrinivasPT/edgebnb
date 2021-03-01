package com.edge.hotel.infrastructure.repository;

import com.edge.hotel.domain.model.aggregates.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels, Long> {
}
