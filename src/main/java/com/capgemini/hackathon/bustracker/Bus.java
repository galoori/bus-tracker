package com.capgemini.hackathon.bustracker;

/**
 * Created by galoori on 12/10/2016.
 */
public class Bus {

    private Integer id;

    private Bus() {
    }

    public Bus(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        return id.equals(bus.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Bus["+id+']';
    }
}
