package com.cars24.csms.data.responses;

import com.cars24.csms.data.enums.EmployeeRole;
import lombok.Data;


@Data
public class CreateEmployeeResp {

    private String name;

    private String phone;

    private String email;

    private EmployeeRole role;

    private double salary;

}
