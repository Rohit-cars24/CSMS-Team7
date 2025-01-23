package com.cars24.csms.data.responses;

import com.cars24.csms.data.enums.AppointmentStatus;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@Valid
public class CreateAppointmentResponse {

    private int c_id;
    private int v_id;
    private int s_id;
    private String a_date;
    private AppointmentStatus status;

}
