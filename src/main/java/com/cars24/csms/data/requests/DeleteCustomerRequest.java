package com.cars24.csms.data.requests;

import lombok.Data;

@Data
public class DeleteCustomerRequest {
    private String email;
    private String phone;
}
