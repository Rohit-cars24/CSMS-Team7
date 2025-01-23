package com.cars24.csms.controllers;

import com.cars24.csms.services.impl.AppointmentServiceImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.requests.CreateAppointmentRequest;
import com.cars24.csms.data.requests.GetAppointmentRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.CreateAppointmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/appointments")

@Slf4j
@Valid

@RequiredArgsConstructor

@Service
public class AppointmentController {

    private final AppointmentServiceImpl appointmentServiceImpl;

    @PostMapping("/create")
    //public ResponseEntity<CreateAppointmentResponse> createAppointment(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest){
    public ResponseEntity<ApiResponse>       createAppointment(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest){
        log.info("[createAppointment] createAppointmentRequest {}", createAppointmentRequest);
        CreateAppointmentResponse createAppointmentResponse = new CreateAppointmentResponse();

        return appointmentServiceImpl.CreateAppointmentResponse(createAppointmentRequest);
        //return ResponseEntity.ok().body(createAppointmentResponse);
    }

    @GetMapping("/retrieveappointments")
    public ResponseEntity<List<AppointmentsEntity>> getAppointment(@Valid @RequestBody GetAppointmentRequest getAppointmentRequest){
        log.info("[getAppointment] getAppointment {}", getAppointmentRequest);
        int userId = 2;
        return ResponseEntity.ok().body(appointmentServiceImpl.getAppointment(getAppointmentRequest, userId));
    }
}