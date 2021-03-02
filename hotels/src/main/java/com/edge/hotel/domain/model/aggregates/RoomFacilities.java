package com.edge.hotel.domain.model.aggregates;

import com.edge.shared.domain.base.EntityRoot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class RoomFacilities extends EntityRoot {
    private Long facilityId;

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomFacilities that = (RoomFacilities) o;
        return Objects.equals(facilityId, that.facilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityId);
    }

    @Override
    public String toString() {
        return "RoomFacilities{" +
                "facilityId=" + facilityId +
                '}';
    }
}
