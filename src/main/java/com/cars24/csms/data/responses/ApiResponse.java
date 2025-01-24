package com.cars24.csms.data.responses;

import lombok.Data;

@Data
public class ApiResponse {
    private int statuscode;
    private boolean success;
    private String message;
    private String service;
    private Object data;

}
