package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.ServiceDaoImpl;
import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.response.CreateServiceResponse;
import com.cars24.csms.services.Servicemanagement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
