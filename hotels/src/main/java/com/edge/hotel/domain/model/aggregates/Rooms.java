package com.edge.hotel.domain.model.aggregates;

import com.edge.shared.domain.base.EntityRoot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Rooms extends EntityRoot {
    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("maxPrice")
    private Long maxPrice;

    @JsonProperty("minPrice")
    private Long minPrice;

    @JsonProperty("roomFacilities")
    @OneToMany(targetEntity = HotelFacilities.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "room_id", nullable = false)
    private List<RoomFacilities> roomFacilities;

    public Rooms() {
    }

    public Rooms(Long hotelId, String name, Long quantity, Long maxPrice, Long minPrice) {
        this.name = name;
        this.quantity = quantity;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms = (Rooms) o;
        return Objects.equals(name, rooms.name) && Objects.equals(quantity, rooms.quantity) && Objects.equals(maxPrice, rooms.maxPrice) && Objects.equals(minPrice, rooms.minPrice) && Objects.equals(roomFacilities, rooms.roomFacilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, maxPrice, minPrice, roomFacilities);
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", hotelFacilities=" + roomFacilities +
                '}';
    }
}
