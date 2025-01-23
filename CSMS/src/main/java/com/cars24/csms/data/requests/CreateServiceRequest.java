package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.Servicenamecheck;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;



@Valid
@Data
public class CreateServiceRequest {

@Valid
    private Servicenamecheck service_name;
@Valid
    @Min(value = 1,message = "invalid price")
    private int price;


}
