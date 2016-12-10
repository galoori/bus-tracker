package com.capgemini.hackathon.bustracker.exception;

/**
 * Created by galoori on 12/10/2016.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
