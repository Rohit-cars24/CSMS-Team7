package com.cars24.csms.services.impl;

import com.cars24.csms.exceptions.AppointmentServiceException;
import com.cars24.csms.services.AppointmentService;
import com.cars24.csms.data.dao.impl.AppointmentDaoImpl;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.repositories.VehicleRepository;
import com.cars24.csms.data.requests.CreateAppointmentRequest;
import com.cars24.csms.data.requests.GetAppointmentRequest;
import com.cars24.csms.data.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j

public class AppointmentServiceImpl implements AppointmentService {

    final private AppointmentDaoImpl appointmentDao;
    final private CustomerRepository customerRepository;
    final private VehicleRepository vehicleRepository;
    final private ServiceRepository serviceRepository;
    final private AppointmentRepository appointmentRepository;

    @Override
    public ResponseEntity<ApiResponse> CreateAppointmentResponse(CreateAppointmentRequest createAppointmentRequest) {

        log.info("[AppointmentServiceImpl] CreateAppointmentResponse {}", createAppointmentRequest);


        if(!customerRepository.existsById(createAppointmentRequest.getCustomer_id())){
            throw new AppointmentServiceException("The customer id entered doesnt exist");
        }

        if(!vehicleRepository.existsById(createAppointmentRequest.getVehicle_id())){
            throw new AppointmentServiceException("The vehicle id entered doesnt exist");
        }

        if(!serviceRepository.existsById(createAppointmentRequest.getService_id())){
            throw new AppointmentServiceException("The service id entered doesnt exist ");
        }

        if(appointmentRepository.existsByCustomerIdAndVehicleIdAndServiceId(createAppointmentRequest.getService_id(),
                createAppointmentRequest.getVehicle_id(),
                createAppointmentRequest.getCustomer_id())){
            throw new AppointmentServiceException("U cannot have redundant ID's for multiple rows");
        }

        appointmentDao.createAppointment(createAppointmentRequest);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatuscode(HttpStatus.OK.value());
        apiResponse.setData(null);
        apiResponse.setMessage("Insertion successful");
        apiResponse.setSuccess(true);
        apiResponse.setService("AppSerImpl "+ HttpStatus.OK.value());

        return ResponseEntity.ok().body(apiResponse);
    }

    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest, int userId){

        log.info("[AppointmentServiceImpl] getAppointmentRequest {}", getAppointmentRequest);

        return appointmentDao.getAppointment(getAppointmentRequest, userId);

    }
}
