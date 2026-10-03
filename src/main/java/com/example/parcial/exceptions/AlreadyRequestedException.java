package com.example.parcial.exceptions;

public class AlreadyRequestedException extends RuntimeException {
    public AlreadyRequestedException(String message) {
        super(message);
    }
}
