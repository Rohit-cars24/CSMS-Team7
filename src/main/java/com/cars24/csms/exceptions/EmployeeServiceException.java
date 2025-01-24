package com.cars24.csms.exceptions;

public class EmployeeServiceException extends RuntimeException{
    public EmployeeServiceException(String message){
        super(message);
    }
}
