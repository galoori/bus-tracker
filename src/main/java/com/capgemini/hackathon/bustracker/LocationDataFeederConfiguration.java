package com.capgemini.hackathon.bustracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by galoori on 12/9/2016.
 */
@Configuration
public class LocationDataFeederConfiguration implements WebSocketConfigurer {

    @Autowired
    private LocationDataFeeder locationDataFeeder;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(locationDataFeeder, "/location/feed");
    }
}
