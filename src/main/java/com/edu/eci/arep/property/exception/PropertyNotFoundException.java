package com.edu.eci.arep.property.exception;

public class PropertyNotFoundException extends RuntimeException {

    public PropertyNotFoundException(String id) {
        super("Property with ID " + id + " was not found.");
    }
}
