package com.cars24.csms.exceptions;

public class AppointmentServiceException extends RuntimeException {
    public AppointmentServiceException(String message) {
        super(message);
    }
}
