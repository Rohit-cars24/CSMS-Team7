package com.cars24.csms.services;

import com.cars24.csms.data.requests.CreateVehicleReq;
import com.cars24.csms.data.requests.GetVehicleReq;
import com.cars24.csms.data.requests.UpdateVehicleReq;
import com.cars24.csms.data.responses.CreateVehicleRes;
import com.cars24.csms.data.responses.GetVehicleRes;
import com.cars24.csms.data.responses.UpdateVehicleRes;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface VehicleService {

    CreateVehicleRes createVehicle(CreateVehicleReq createVehicleReq);
    List<GetVehicleRes> getVehicle(GetVehicleReq getVehicleReq);
    UpdateVehicleRes updateVehicle(String licensePlate, UpdateVehicleReq updateVehicleReq);
    String deleteVehicleByLicensePlate(String licensePlate);
}
