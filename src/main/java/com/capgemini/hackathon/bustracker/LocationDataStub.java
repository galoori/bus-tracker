package com.capgemini.hackathon.bustracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by galoori on 12/9/2016.
 */
public class LocationDataStub {

    public static List<Location> fetchLocationData() {
        List<Location> locationData = new ArrayList<Location>();
        InputStream is = LocationDataStub.class.getResourceAsStream("/static/json/bus2.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Location> locationList = mapper.readValue(is, new TypeReference<List<Location>>() {});
            if (locationList != null) {
                locationData.addAll(locationList);
            }
        } catch (IOException e) {
            System.out.println("Error fetching location data: "+e.getMessage());
        }
        return locationData;
    }

}
