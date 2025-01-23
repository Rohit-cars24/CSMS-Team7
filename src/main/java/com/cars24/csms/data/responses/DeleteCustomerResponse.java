package com.cars24.csms.data.responses;

import lombok.Data;

@Data
public class DeleteCustomerResponse {
    private String name;

    private String phone;

    private String email;

    private String address;
}
