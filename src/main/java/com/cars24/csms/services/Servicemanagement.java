package com.cars24.csms.services;

import com.cars24.csms.data.requests.CreateServiceRequest;
import com.cars24.csms.data.responses.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface Servicemanagement {
    public  CreateServiceResponse createServiceResponse(CreateServiceRequest createServiceRequest);
}
