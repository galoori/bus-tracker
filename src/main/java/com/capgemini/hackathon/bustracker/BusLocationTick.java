package com.capgemini.hackathon.bustracker;

/**
 * Created by galoori on 12/10/2016.
 */
public class BusLocationTick {

    private Bus bus;

    private Location location;

    private BusLocationTick() {
    }

    public BusLocationTick(Bus bus, Location location) {
        this.bus = bus;
        this.location = location;
    }

    public Bus getBus() {
        return bus;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "BusLocationTick{" +
                "bus=" + bus +
                ", location=" + location +
                '}';
    }
}
