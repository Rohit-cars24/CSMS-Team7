package com.cars24.csms.data.requests;

import com.cars24.csms.data.enums.Servicenamecheck;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;


@Valid
@Data
public class CreateServiceRequest {

@Valid
    private Servicenamecheck service_name;
@Valid
    @Min(value = 1,message = "invalid price")
    private int price;


}
