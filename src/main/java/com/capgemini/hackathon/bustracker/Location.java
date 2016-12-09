package com.capgemini.hackathon.bustracker;

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
}
