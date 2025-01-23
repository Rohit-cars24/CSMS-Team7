package com.cars24.csms.services;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.requests.CreateAppointmentRequest;
import com.cars24.csms.data.requests.GetAppointmentRequest;
import com.cars24.csms.data.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    public ResponseEntity<ApiResponse> CreateAppointmentResponse(CreateAppointmentRequest createAppointmentRequest);
    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest, int userid);
}
