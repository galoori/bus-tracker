package com.capgemini.hackathon.bustracker;

/**
 * Created by galoori on 12/9/2016.
 */
public class Location {

    private double lat;
    private double lng;

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

    @Override
    public String toString() {
        return "Location["+lat+", "+lng+']';
    }
}
