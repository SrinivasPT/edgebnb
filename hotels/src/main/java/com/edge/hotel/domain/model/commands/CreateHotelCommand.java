package com.edge.hotel.domain.model.commands;

import com.edge.hotel.domain.model.aggregates.HotelFacilities;
import com.edge.hotel.domain.model.aggregates.Rooms;

import java.util.List;
import java.util.Objects;

public class CreateHotelCommand {
    private Long id;
    private String name;
    private String description;
    private String originalImagePath;
    private String displayImagePath;
    private List<HotelFacilities> hotelFacilities;
    private List<Rooms> rooms;

    public CreateHotelCommand(String name, String description, String originalImagePath, String displayImagePath) {
        this.name = name;
        this.description = description;
        this.originalImagePath = originalImagePath;
        this.displayImagePath = displayImagePath;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
        return "CreateHotelCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", originalImagePath='" + originalImagePath + '\'' +
                ", displayImagePath='" + displayImagePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateHotelCommand that = (CreateHotelCommand) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(originalImagePath, that.originalImagePath) && Objects.equals(displayImagePath, that.displayImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, originalImagePath, displayImagePath);
    }
}
