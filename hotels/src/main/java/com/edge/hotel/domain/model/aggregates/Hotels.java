package com.edge.hotel.domain.model.aggregates;

import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import com.edge.shared.domain.base.AggregateRoot;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotels extends AggregateRoot {
    @JsonProperty("name")
    private String name;

    @JsonProperty("localityId")
    private Long localityId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("originalImagePath")
    private String originalImagePath;

    @JsonProperty("displayImagePath")
    private String displayImagePath;

    @JsonProperty("rooms")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private List<Rooms> rooms = new ArrayList<>();

    @JsonProperty("hotelFacilities")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private List<HotelFacilities> hotelFacilities = new ArrayList<>();

    public Hotels() {
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
                ", rooms=" + rooms +
                ", hotelFacilities=" + hotelFacilities +
                '}';
    }
}
