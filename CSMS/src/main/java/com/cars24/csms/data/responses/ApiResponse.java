package com.cars24.csms.data.responses;


import lombok.Data;

@Data
public class ApiResponse {

    private int Statuscode;
    private boolean Success;
    private String message;
    private Object data;

    private String service;
}
