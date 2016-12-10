package com.capgemini.hackathon.bustracker;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by galoori on 12/9/2016.
 */
@Component
@EnableWebSocket
@EnableScheduling
public class LocationDataFeeder extends TextWebSocketHandler {

    private WebSocketSession session;
    private AtomicInteger counter = new AtomicInteger(0);

    public void feedData(String feed) {
        if (isSessionOpen() && feed != null) {
            try {
                System.out.println("Sending Json: "+feed);
                this.session.sendMessage(new TextMessage(feed));
            } catch (IOException e) {
                System.out.println("Could feed data to client. Error: "+e.getMessage());
            }
        } else {
            System.out.println("No connected clients to feed the data.");
        }
    }

    private boolean isSessionOpen() {
        return this.session != null && this.session.isOpen();
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
