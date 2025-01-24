package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.ServiceDaoImpl;
import com.cars24.csms.data.requests.CreateServiceRequest;
import com.cars24.csms.data.responses.CreateServiceResponse;
import com.cars24.csms.services.Servicemanagement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ServiceManagementImpl implements Servicemanagement {


   private final ServiceDaoImpl serviceDaoimpl;






    public CreateServiceResponse createServiceResponse(CreateServiceRequest createServiceRequest) {
        serviceDaoimpl.CreateService(createServiceRequest);
        return  null;

    }



}
