package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.EmployeeDao;
import com.cars24.csms.data.entities.EmployeeEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.repositories.EmployeeRepository;
import com.cars24.csms.data.requests.CreateEmployeeReq;
import com.cars24.csms.data.requests.DeleteEmployeeRequest;
import com.cars24.csms.data.requests.GetEmployeeRequest;
import com.cars24.csms.data.responses.DeleteEmployeeResponse;
import com.cars24.csms.data.responses.GetEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeDaoImpl implements EmployeeDao {


    private final EmployeeRepository employeeRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public int createEmployee(CreateEmployeeReq createEmployeeReq) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(createEmployeeReq.getName());
        employeeEntity.setPhone(createEmployeeReq.getPhone());
        employeeEntity.setEmail(createEmployeeReq.getEmail());
        employeeEntity.setRole(createEmployeeReq.getRole().toString());
        employeeEntity.setSalary(createEmployeeReq.getSalary());
        employeeEntity.setActive(true);
        employeeEntity.setUser_id(appUserRepository.getByUsername(createEmployeeReq.getEmail()).getUserid());

        employeeRepository.save(employeeEntity);

        return 0;
    }


    public GetEmployeeResponse getEmployeeResponse(GetEmployeeRequest getEmployeeReq){
        EmployeeEntity emp = employeeRepository.getByEmail(getEmployeeReq.getEmail());
        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

        getEmployeeResponse.setName(emp.getName());
        getEmployeeResponse.setEmail(emp.getEmail());
        getEmployeeResponse.setRole(emp.getRole());
        getEmployeeResponse.setPhone(emp.getPhone());
        getEmployeeResponse.setSalary(emp.getSalary());

        return getEmployeeResponse;

    }

    public DeleteEmployeeResponse deleteEmp(DeleteEmployeeRequest deleteEmployeeRequest){
        EmployeeEntity emp = employeeRepository.getByEmail(deleteEmployeeRequest.getEmail());

        emp.setActive(false);
        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();

        deleteEmployeeResponse.setName(emp.getName());
        deleteEmployeeResponse.setEmail(emp.getEmail());
        deleteEmployeeResponse.setRole(emp.getRole());
        deleteEmployeeResponse.setPhone(emp.getPhone());
        deleteEmployeeResponse.setSalary(emp.getSalary());

        employeeRepository.save(emp);

        return deleteEmployeeResponse;

    }


}
