package com.cars24.csms.controllers;

import com.cars24.csms.data.dao.impl.ServiceDaoImpl;
import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.response.CreateServiceResponse;

import com.cars24.csms.services.Servicemanagement;
import com.cars24.csms.services.impl.ServiceManagementImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
@Validated
@Slf4j
public class ServiceController {


   private final ServiceManagementImpl serviceManagementimpl;
    @PostMapping
    public ResponseEntity<CreateServiceResponse>  createservice(@Valid @RequestBody CreateServiceRequest createServiceRequest){
//        System.out.println("[createservice] createServiceRequest {}"+ createServiceRequest);
log.info("[createservice] createServiceRequest {}", createServiceRequest);
CreateServiceResponse createServiceResponse =new CreateServiceResponse();
        serviceManagementimpl.createServiceResponse(createServiceRequest);
        return ResponseEntity.ok().body(createServiceResponse);


    }
}
