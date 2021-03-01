package com.edge.hotel.domain.model.aggregates;

import com.edge.shared.domain.base.EntityRoot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class HotelFacilities extends EntityRoot {
    @JsonProperty("facilityId")
    private Long facilityId;

    public HotelFacilities() {
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public Long FacilityId() {
        return facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelFacilities that = (HotelFacilities) o;
        return Objects.equals(facilityId, that.facilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityId);
    }

    @Override
    public String toString() {
        return "HotelFacilities{" +
                "facilityId=" + facilityId +
                '}';
    }
}
