package com.edu.eci.arep.secureapp.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String id) {
        super("Property with ID " + id + " was not found.");
    }
}
