package com.capgemini.hackathon.bustracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by galoori on 12/9/2016.
 */
@Service
public class LocationDataService {

    private static List<Location> locationData = new ArrayList<Location>();
    static {
        locationData.addAll(LocationDataStub.fetchLocationData());
    }

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    LocationDataFeeder locationDataFeeder;

    @Scheduled(fixedDelay = 1000)
    public void sendLocationFeed() {
        locationDataFeeder.feedData(getNextLocationData());
    }

    public Location getNextLocationData() {
        int index = counter.getAndIncrement();
        if (index < locationData.size()) {
            return locationData.get(index);
        } else {
            return locationData.get(locationData.size()-1);
        }
    }

}
