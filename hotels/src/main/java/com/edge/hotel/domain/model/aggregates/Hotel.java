package com.edge.hotel.domain.model.aggregates;

import com.edge.hotel.domain.model.commands.CreateHotelCommand;
import com.edge.shared.domain.base.AggregateRoot;

import javax.persistence.*;

@Entity
public class Hotel extends AggregateRoot {
    private String name;
    //    private LocalityId localityId;
    private String description;
    private String originalImagePath;
    private String displayImagePath;

    public Hotel() {
    }

    public Hotel(CreateHotelCommand command) {
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

}
