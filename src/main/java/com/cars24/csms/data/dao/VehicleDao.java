package com.cars24.csms.data.dao;


import com.cars24.csms.data.requests.CreateVehicleReq;
import com.cars24.csms.data.requests.GetVehicleReq;
import com.cars24.csms.data.requests.UpdateVehicleReq;
import com.cars24.csms.data.responses.GetVehicleRes;
import com.cars24.csms.data.responses.UpdateVehicleRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleDao {
    int createVehicle(CreateVehicleReq createVehicleReq);
    List<GetVehicleRes> getVehicle(GetVehicleReq getVehicleReq);// retrieve the vehicles based on model or color
    UpdateVehicleRes updateVehicle(UpdateVehicleReq updateVehicleReq); //update the details based on make or model
    String deleteVehicle(String licensePlate);
}
