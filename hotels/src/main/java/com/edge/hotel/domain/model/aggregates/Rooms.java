package com.edge.hotel.domain.model.aggregates;

import com.edge.shared.domain.base.EntityRoot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rooms extends EntityRoot {
    private String name;
    private Long quantity;
    private Long maxPrice;
    private Long minPrice;

    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "room_id", nullable = false)
    private List<RoomFacilities> roomFacilities = new ArrayList<>();

    public List<RoomFacilities> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<RoomFacilities> roomFacilities) {
        this.roomFacilities.addAll(roomFacilities);
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Rooms rooms = (Rooms) o;
//        return Objects.equals(name, rooms.name) && Objects.equals(quantity, rooms.quantity) &&
//                Objects.equals(maxPrice, rooms.maxPrice) && Objects.equals(minPrice, rooms.minPrice)
//                && Objects.equals(roomFacilities, rooms.roomFacilities);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, quantity, maxPrice, minPrice, roomFacilities);
//    }

    @Override
    public String toString() {
        return "Rooms{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
//                ", hotelFacilities=" + roomFacilities +
                '}';
    }

}
