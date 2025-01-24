package com.cars24.csms.data.requests;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Valid
@Data
public class CreateAppointmentRequest {
    @Valid
    @Min(value = 1, message = "Invalid customer ID")
    private int customer_id;
    @Valid
    @Min(value = 1, message = "Invalid vehicle ID")
    private int vehicle_id;
    @Valid
    @Min(value = 1, message = "Invalid service ID")
    private int service_id;
    @Valid
    @NotBlank
    private String a_date;
    private AppointmentStatus status;
}
