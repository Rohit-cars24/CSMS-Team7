package com.cars24.csms.exceptions;

public class ProfileExistException extends RuntimeException {
    public ProfileExistException(String message) {
        super(message);
    }
}
