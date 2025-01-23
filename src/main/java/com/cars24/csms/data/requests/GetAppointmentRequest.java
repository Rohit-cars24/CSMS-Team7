package com.cars24.csms.data.requests;

import jakarta.validation.Valid;
import lombok.Data;

@Valid
@Data
public class GetAppointmentRequest {

    private int appointment_id;
    private int customer_id;
    private int vehicle_id;
    private int service_id;
    private String appointment_date;
    private String status;

}
