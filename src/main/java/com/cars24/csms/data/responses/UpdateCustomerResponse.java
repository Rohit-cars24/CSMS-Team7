package com.cars24.csms.data.responses;

import lombok.Data;

@Data
public class UpdateCustomerResponse {

    private String name;

    private String phone;

    private String email;

    private String address;
}
