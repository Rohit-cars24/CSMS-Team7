package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateServiceRequest;
import com.cars24.csms.data.response.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface ServiceManagement {
    public  CreateServiceResponse createServiceResponse(CreateServiceRequest createServiceRequest);
}
