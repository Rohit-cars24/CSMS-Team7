package com.cars24.csms.services.impl;

import com.cars24.csms.exceptions.EmployeeServiceException;
import com.cars24.csms.data.dao.impl.EmployeeDaoImpl;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.repositories.EmployeeRepository;
import com.cars24.csms.data.requests.CreateEmployeeReq;
import com.cars24.csms.data.requests.DeleteEmployeeRequest;
import com.cars24.csms.data.requests.GetEmployeeRequest;
import com.cars24.csms.data.responses.DeleteEmployeeResponse;
import com.cars24.csms.data.responses.GetEmployeeResponse;
import com.cars24.csms.services.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EmployeeServicesImpl implements EmployeeServices {


    private final EmployeeDaoImpl employeeDaoImpl;
    private final AppUserRepository appUserRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<com.cars24.csms.data.responses.ApiResponse> createEmployeeResponse(CreateEmployeeReq createEmployeeReq) {


        boolean userExistsInUserTable = true;
        boolean employeeExistsInEmployeeTable = true;
        com.cars24.csms.data.responses.ApiResponse resp = new com.cars24.csms.data.responses.ApiResponse();

        userExistsInUserTable = appUserRepository.existsByUsername(createEmployeeReq.getEmail());
        employeeExistsInEmployeeTable = employeeRepository.existsByEmail(createEmployeeReq.getEmail());

        //String usertype = appUserRepository.getUser_idByUsername(createEmployeeReq.getEmail()).getUserType();

        if(userExistsInUserTable && !employeeExistsInEmployeeTable){

            resp.setStatuscode(HttpStatus.OK.value());
            resp.setSuccess(true);
            resp.setMessage("User id exists for the employee. Profile creation successful ");
            resp.setService("EMPSRVC - " + HttpStatus.OK.value());
            resp.setData(null);

            employeeDaoImpl.createEmployee(createEmployeeReq);

            return ResponseEntity.ok().body(resp);

        }

        else{
            if(employeeExistsInEmployeeTable){
                throw new EmployeeServiceException("This employee profile is already present");
            }
            else {
                throw new EmployeeServiceException("Please create user account first");
            }
        }

    }


    public GetEmployeeResponse getEmployeeResponse(GetEmployeeRequest getEmployeeReq) {

        boolean employeeExistsInEmployeeTable = employeeRepository.existsByEmail(getEmployeeReq.getEmail());

        if(!employeeExistsInEmployeeTable){
            throw new EmployeeServiceException("Employee doesn't exist");
        }
        else{
            return employeeDaoImpl.getEmployeeResponse(getEmployeeReq);
        }
    }

    public DeleteEmployeeResponse deleteEmp(DeleteEmployeeRequest delEmployeeRequest){

        boolean employeeExistsInEmployeeTable = employeeRepository.existsByEmailAndPhone(delEmployeeRequest.getEmail() , delEmployeeRequest.getPhone());

        if(!employeeExistsInEmployeeTable){
            throw new EmployeeServiceException("Employee doesn't exist");
        }
        else {
            return employeeDaoImpl.deleteEmp(delEmployeeRequest);
        }

    }

}
