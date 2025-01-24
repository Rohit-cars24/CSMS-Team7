package com.cars24.csms.data.requests;

import com.cars24.csms.services.impl.CustomerServiceimpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Valid
@Data
@RequiredArgsConstructor
public class CreateCustomerRequest {


    private final CustomerServiceimpl customerServiceImpl;
    @Valid  
    @Size(max=20,message = "Name must not exceed 20 characters.")
    private String name;

    @Valid
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits and can include an optional '+' prefix.")
    private String phone;

    @Valid
    @Email
    @NotNull
    private String email;

    @Valid
    @Size(max = 255, message = "Address must not exceed 255 characters.")
    private String address;

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
