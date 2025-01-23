package com.cars24.csms.data.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String name;
    private String phone;
    private String email;
    private String address;

}
