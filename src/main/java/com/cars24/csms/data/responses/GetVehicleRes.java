package com.cars24.csms.data.responses;


import lombok.Data;

@Data
public class GetVehicleRes {
    private int vehicleId;

    private int customerId;

    private String licensePlate;

    private String model;

    private String make;

    private int year;

    private String color;
}
