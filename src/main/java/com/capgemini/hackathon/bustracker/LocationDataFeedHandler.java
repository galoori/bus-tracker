package com.capgemini.hackathon.bustracker;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by galoori on 12/9/2016.
 */
@Component
@EnableWebSocket
@EnableScheduling
public class LocationDataFeedHandler extends TextWebSocketHandler {

    private WebSocketSession session;
    private AtomicInteger counter = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000)
    public void sendLocationFeed() {
        if (this.session != null && this.session.isOpen()) {
            try {
                this.session.sendMessage(new TextMessage(String.valueOf(counter.incrementAndGet())));
            } catch (IOException e) {
                System.out.println("Could feed data to client. Error: "+e.getMessage());
            }
        } else {
            System.out.println("No connected clients to feed the data.");
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.session = session;
        System.out.println("Connection ("+session.getId()+") established");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.session = null;
        System.out.println("Connection ("+session.getId()+") closed");
    }
}
