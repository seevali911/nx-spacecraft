package com.nationalexpress.spacecraft.model;

import com.nationalexpress.spacecraft.services.IEntertainment;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(schema = "spacecraft", name = "route")
@ApiModel(description = "Model class to represent the route to a destination")
public class Route implements IEntertainment {
    @Id
    private String routeId;
    private Integer departure;
    private Integer destination;
    private String departingDay;
    private Integer leg1;
    private Integer leg2;
    private Integer leg3;
    private Integer leg4;
    private String entertainmentProvider;

    private Route() {
    }

    public Route(Builder builder) {
        this.routeId = builder.routeId;
        this.departure = builder.departure;
        this.destination = builder.destination;
        this.departingDay = builder.departingDay;
        this.leg1 = builder.leg1;
        this.leg2 = builder.leg2;
        this.leg3 = builder.leg3;
        this.leg4 = builder.leg4;
        this.entertainmentProvider = builder.entertainmentProvider;
    }

    @Override
    public String providers() {
        return this.entertainmentProvider;
    }

    public static class Builder {
        private String routeId;
        private Integer departure;
        private Integer destination;
        private String departingDay;
        private Integer leg1;
        private Integer leg2;
        private Integer leg3;
        private Integer leg4;
        private String entertainmentProvider;

        public Builder(String routeId) {
            this.routeId = routeId;
        }

        public Builder departure(Integer departure) {
            this.departure = departure;
            return this;
        }

        public Builder destination(Integer destination) {
            this.destination = destination;
            return this;
        }

        public Builder departingDay(String departingDay) {
            this.departingDay = departingDay;
            return this;
        }

        public Builder leg1(Integer leg1) {
            this.leg1 = leg1;
            return this;
        }

        public Builder leg2(Integer leg2) {
            this.leg2 = leg2;
            return this;
        }

        public Builder leg3(Integer leg3) {
            this.leg3 = leg3;
            return this;
        }

        public Builder leg4(Integer leg4) {
            this.leg4 = leg4;
            return this;
        }

        public Builder entertainment (String entertainment){
            this.entertainmentProvider = entertainment;
            return this;
        }

        public Route build (){
            return new Route (this);
        }

    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public String getDepartingDay() {
        return departingDay;
    }

    public void setDepartingDay(String departingDay) {
        this.departingDay = departingDay;
    }

    public Integer getLeg1() {
        return leg1;
    }

    public void setLeg1(Integer leg1) {
        this.leg1 = leg1;
    }

    public Integer getLeg2() {
        return leg2;
    }

    public void setLeg2(Integer leg2) {
        this.leg2 = leg2;
    }

    public Integer getLeg3() {
        return leg3;
    }

    public void setLeg3(Integer leg3) {
        this.leg3 = leg3;
    }

    public Integer getLeg4() {
        return leg4;
    }

    public void setLeg4(Integer leg4) {
        this.leg4 = leg4;
    }

    public String getEntertainmentProvider() {
        return entertainmentProvider;
    }

    public void setEntertainmentProvider(String entertainmentProvider) {
        this.entertainmentProvider = entertainmentProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(routeId, route.routeId) &&
                Objects.equals(departure, route.departure) &&
                Objects.equals(destination, route.destination) &&
                Objects.equals(departingDay, route.departingDay) &&
                Objects.equals(leg1, route.leg1) &&
                Objects.equals(leg2, route.leg2) &&
                Objects.equals(leg3, route.leg3) &&
                Objects.equals(leg4, route.leg4) &&
                Objects.equals(entertainmentProvider, route.entertainmentProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, departure, destination, departingDay, leg1, leg2, leg3, leg4, entertainmentProvider);
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", departure=" + departure +
                ", destination=" + destination +
                ", departingDay='" + departingDay + '\'' +
                ", leg1=" + leg1 +
                ", leg2=" + leg2 +
                ", leg3=" + leg3 +
                ", leg4=" + leg4 +
                ", entertainment='" + entertainmentProvider + '\'' +
                '}';
    }
}
