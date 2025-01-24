package com.cars24.csms.data.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GetCustomerRequest {
    @Valid
    @Size(min=10,max=10,message = "Phone number should be 10 digits")
    private String phone;

    @Valid
    @Email
    private  String email;
}
