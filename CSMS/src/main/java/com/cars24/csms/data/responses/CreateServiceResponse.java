package com.cars24.csms.data.response;

import com.cars24.csms.data.enums.Servicenamecheck;
import lombok.Data;


@Data
public class CreateServiceResponse {


    private Servicenamecheck service_name;


    private int price;
}
