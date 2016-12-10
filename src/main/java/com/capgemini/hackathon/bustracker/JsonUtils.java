package com.capgemini.hackathon.bustracker;

import com.capgemini.hackathon.bustracker.model.BusLocationTick;
import com.capgemini.hackathon.bustracker.model.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by galoori on 12/10/2016.
 */
public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String asJson(List<BusLocationTick> locationTicks) {
        final StringWriter sw = new StringWriter();
        try {
            mapper.writeValue(sw, locationTicks);
        } catch (IOException e) {
            System.out.println("Error marshalling location tick: "+e.getMessage());
        }
        return sw.toString();
    }

    public static List<Location> getLocationsFromFile(String jsonFile) {
        List<Location> locations = new ArrayList<Location>();
        InputStream is = LocationDataStub.class.getResourceAsStream(jsonFile);
        try {
            List<Location> locationList = mapper.readValue(is, new TypeReference<List<Location>>() {});
            if (locationList != null) {
                locations.addAll(locationList);
            }
        } catch (IOException e) {
            System.out.println("Error fetching location data: "+e.getMessage());
        }
        return locations;
    }
}
