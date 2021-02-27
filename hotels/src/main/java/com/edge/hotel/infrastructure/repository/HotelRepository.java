package com.edge.hotel.infrastructure.repository;

import com.edge.hotel.domain.model.aggregates.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
