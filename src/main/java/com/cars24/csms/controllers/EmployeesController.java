package com.cars24.csms.controllers;

import com.cars24.csms.data.requests.CreateEmployeeReq;
import com.cars24.csms.data.requests.DeleteEmployeeRequest;
import com.cars24.csms.data.requests.GetEmployeeRequest;
import com.cars24.csms.data.responses.CreateEmployeeResp;
import com.cars24.csms.data.responses.DeleteEmployeeResponse;
import com.cars24.csms.data.responses.GetEmployeeResponse;
import com.cars24.csms.services.impl.EmployeeServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
@Validated
@Slf4j
@Service
@RequiredArgsConstructor

public class EmployeesController {

    private final EmployeeServicesImpl employeeServicesImpl;

    @PostMapping
    public ResponseEntity<com.cars24.csms.data.responses.ApiResponse> createEmp(@Valid @RequestBody CreateEmployeeReq createEmployeeReq){
        //System.out.println("[createEmp] createEmployeeReq {}" + createEmployeeReq);
        log.info("[createEmp] createEmployeeReq {}", createEmployeeReq);
        CreateEmployeeResp createEmployeeResp = new CreateEmployeeResp();

        return employeeServicesImpl.createEmployeeResponse(createEmployeeReq);

    }

    @GetMapping("/get")
    public ResponseEntity<GetEmployeeResponse> getEmp(@Valid @RequestBody GetEmployeeRequest getEmployeeRequest){

        log.info("[getEmp] getEmployeeReq {}", getEmployeeRequest);
        GetEmployeeResponse getEmployeeResponse = employeeServicesImpl.getEmployeeResponse(getEmployeeRequest);

        return ResponseEntity.ok().body(getEmployeeResponse);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<DeleteEmployeeResponse> deleteEmp(@Valid @RequestBody DeleteEmployeeRequest delEmployeeRequest){
        DeleteEmployeeResponse delEmployeeResponse = employeeServicesImpl.deleteEmp(delEmployeeRequest);
        return ResponseEntity.ok().body(delEmployeeResponse);
    }

    //@DeleteMapping("/delete")
    //public ResponseEntity<APIResp> deleteEmp(@Valid @RequestBody)

}
