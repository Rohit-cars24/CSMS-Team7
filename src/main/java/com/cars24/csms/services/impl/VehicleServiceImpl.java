package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.VehicleDaoImpl;
import com.cars24.csms.data.requests.CreateVehicleReq;
import com.cars24.csms.data.requests.GetVehicleReq;
import com.cars24.csms.data.requests.UpdateVehicleReq;
import com.cars24.csms.data.responses.CreateVehicleRes;
import com.cars24.csms.data.responses.GetVehicleRes;
import com.cars24.csms.data.responses.UpdateVehicleRes;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.entities.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl {

    private final VehicleDaoImpl vehicleDaoImpl;

    private final CustomerRepository customerRepository;


    public CreateVehicleRes createVehicle(CreateVehicleReq createVehicleReq){

        CustomerEntity customer = customerRepository.findById(createVehicleReq.getCustomerId()).orElse(null);
        if (customer == null) {
            log.error("[createAppointment] Customer with ID {} not found", createVehicleReq.getCustomerId());
            // Handle the error (e.g., throw an exception, return an error response, etc.)
            return null;
        }

        vehicleDaoImpl.createVehicle(createVehicleReq); // Call to DAO layer to save vehicles
        log.info("[createVehicle]",createVehicleReq);
        return null;
    }

    public List<GetVehicleRes> getVehicle(GetVehicleReq getVehicleReq) {
        log.info("[getVehicle]",getVehicleReq);
        return vehicleDaoImpl.getVehicle(getVehicleReq);
    }

    public UpdateVehicleRes updateVehicle(String licensePlate, UpdateVehicleReq updateVehicleReq) {
        log.info("[updateVehicle]",updateVehicleReq);
        return vehicleDaoImpl.updateVehicle(licensePlate, updateVehicleReq);
    }

    public String deleteVehicleByLicensePlate(String licensePlate) {
        log.info("[deleteVehicleByLicensePlate] deleting vehicle with license plate: {}", licensePlate);
        return vehicleDaoImpl.deleteVehicle(licensePlate);
    }

}
