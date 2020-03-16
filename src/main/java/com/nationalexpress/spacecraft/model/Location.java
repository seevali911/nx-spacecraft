package com.nationalexpress.spacecraft.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "spacecraft", name = "location")
@ApiModel (description = "Model class to represent the planet.")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locationId;
    private String locationName;
    private String inUse;
    @ApiModelProperty (notes = "Name of the image representing planet")
    private String thumbnail;

    public Location() {
    }

    public Location(Integer locationId, String locationName, String inUse, String thumbnail) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.inUse = inUse;
        this.thumbnail = thumbnail;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(locationId, location.locationId) &&
                Objects.equals(locationName, location.locationName) &&
                Objects.equals(inUse, location.inUse) &&
                Objects.equals(thumbnail, location.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationName, inUse, thumbnail);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", inUse='" + inUse + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
