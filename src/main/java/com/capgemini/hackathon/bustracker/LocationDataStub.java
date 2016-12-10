package com.capgemini.hackathon.bustracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by galoori on 12/9/2016.
 */
@Component
public class LocationDataStub {

    private static String[] stubFiles = new String[]{"/static/json/bus1.json", "/static/json/bus2.json"};
    private static List<List<Location>> allBusesLocationData = new ArrayList<List<Location>>();

    private AtomicInteger counter = new AtomicInteger(0);

    static {
        for (String stubFile : stubFiles) {
            allBusesLocationData.add(JsonUtils.getLocationsFromFile(stubFile));
        }
    }

    public List<BusLocationTick> getBusLocationTick() {
        int index = getDataIndex();
        List<BusLocationTick> locationTicks = new ArrayList<BusLocationTick>();
        for (int i=0; i<allBusesLocationData.size(); i++) {
            List<Location> locations = allBusesLocationData.get(i);
            BusLocationTick locationTick = new BusLocationTick(new Bus(i), locations.get(index));
            locationTicks.add(locationTick);
        }
        return locationTicks;
    }

    public int getDataIndex() {
        int index = counter.getAndIncrement();
        //TOO: calculate the smallest list size and use it as the max value
        if (index < allBusesLocationData.get(0).size()) {
            return index;
        } else {
            return allBusesLocationData.get(0).size()-1;
        }
    }

}
