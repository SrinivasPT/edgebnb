package com.edge.hotel.domain.model.aggregates;

import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import com.edge.shared.domain.base.AggregateRoot;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hotels extends AggregateRoot {
    private String name;
    private Long localityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotels hotels = (Hotels) o;
        return Objects.equals(name, hotels.name) && Objects.equals(localityId, hotels.localityId) && Objects.equals(description, hotels.description) && Objects.equals(originalImagePath, hotels.originalImagePath) && Objects.equals(displayImagePath, hotels.displayImagePath) && Objects.equals(rooms, hotels.rooms) && Objects.equals(hotelFacilities, hotels.hotelFacilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, localityId, description, originalImagePath, displayImagePath, rooms, hotelFacilities);
    }

    private String description;
    private String originalImagePath;
    private String displayImagePath;

    @JsonProperty
//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private List<Rooms> rooms = new ArrayList<>();

    @JsonProperty
//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, orphanRemoval = true)
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private List<HotelFacilities> hotelFacilities = new ArrayList<>();

    public Hotels() {
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms.addAll(rooms);
    }

    public List<HotelFacilities> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(List<HotelFacilities> hotelFacilities) {
        this.hotelFacilities.addAll(hotelFacilities);
    }

    public Hotels(CreateHotelCommand command) {
        this.name = command.getName();
        this.description = command.getDescription();
        this.originalImagePath = command.getOriginalImagePath();
        this.displayImagePath = command.getDisplayImagePath();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginalImagePath() {
        return originalImagePath;
    }

    public String getDisplayImagePath() {
        return displayImagePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOriginalImagePath(String originalImagePath) {
        this.originalImagePath = originalImagePath;
    }

    public void setDisplayImagePath(String displayImagePath) {
        this.displayImagePath = displayImagePath;
    }

    @Override
    public String toString() {

        //        String facilitiesStr = hotelFacilities.stream().map(HotelFacilities::toString).collect(Collectors.joining());

        return "Hotels{" +
                "name='" + name + '\'' +
                ", localityId=" + localityId +
                ", description='" + description + '\'' +
                ", originalImagePath='" + originalImagePath + '\'' +
                ", displayImagePath='" + displayImagePath + '\'' +
//                ", rooms=" + rooms +
                ", hotelFacilities=" + hotelFacilities +
                '}';
    }
}
