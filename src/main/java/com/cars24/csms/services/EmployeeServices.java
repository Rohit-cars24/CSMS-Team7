package com.cars24.csms.services;

import com.cars24.csms.data.requests.CreateEmployeeReq;
import com.cars24.csms.data.requests.DeleteEmployeeRequest;
import com.cars24.csms.data.requests.GetEmployeeRequest;
import com.cars24.csms.data.responses.DeleteEmployeeResponse;
import com.cars24.csms.data.responses.GetEmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeServices {
    public ResponseEntity<com.cars24.csms.data.responses.ApiResponse> createEmployeeResponse(CreateEmployeeReq createEmployeeReq);
    public GetEmployeeResponse getEmployeeResponse(GetEmployeeRequest getEmployeeReq);
    public DeleteEmployeeResponse deleteEmp(DeleteEmployeeRequest delEmployeeRequest);
}


