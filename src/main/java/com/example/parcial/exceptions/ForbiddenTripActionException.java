package com.example.parcial.exceptions;

public class ForbiddenTripActionException extends RuntimeException {
    public ForbiddenTripActionException(String message) {
        super(message);
    }
}
