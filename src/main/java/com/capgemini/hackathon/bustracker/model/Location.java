package com.capgemini.hackathon.bustracker.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by galoori on 12/9/2016.
 */
public class Location {

    private double lat;
    private double lng;

    private ObjectMapper mapper = new ObjectMapper();

    private Location() {}

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String asJson() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to convert location data to Json");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Location["+lat+", "+lng+']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.lat, lat) != 0) return false;
        return Double.compare(location.lng, lng) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
