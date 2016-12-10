package com.capgemini.hackathon.bustracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by galoori on 12/9/2016.
 */
@Service
public class LocationDataService {

    @Autowired
    LocationDataFeeder locationDataFeeder;

    @Autowired
    LocationDataStub locationDataStub;

    @Scheduled(fixedDelay = 1000)
    public void sendLocationFeed() {
        String feed = JsonUtils.asJson(locationDataStub.getBusLocationTick());
        locationDataFeeder.feedData(feed);
    }
}
