package com.cars24.csms.data.requests;

import com.cars24.csms.data.enums.EmployeeRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
// import org.hibernate.validator.constraints.Length;

@Valid
@Data
public class CreateEmployeeReq {

    @Valid
    @Length(min = 2, max = 100, message = "Invalid name length")
    private String name;

    @Valid
    @Length(min = 10, max = 10, message = "Invalid phone number")
    private String phone;

    @Valid
    @Email
    private String email;

    @Valid
    @NotNull(message = "Role cannot be null")
    private EmployeeRole role;

    @Valid
    @Min(value = 0,message = "Salary cannot be negative")
    private double salary;

}
