package com.cars24.csms.data.responses;

import lombok.Data;

@Data
public class DeleteEmployeeResponse {

    private String name;

    private String phone;

    private String email;

    private String role;

    private double salary;

}
