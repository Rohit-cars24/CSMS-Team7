package com.cars24.csms.data.responses;

import com.cars24.csms.data.enums.Servicenamecheck;
import lombok.Data;


@Data
public class CreateServiceResponse {


    private Servicenamecheck service_name;


    private int price;
}
