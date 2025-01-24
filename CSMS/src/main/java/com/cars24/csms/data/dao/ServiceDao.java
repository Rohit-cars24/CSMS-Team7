package com.cars24.csms.data.dao;

import com.cars24.csms.data.requests.CreateServiceRequest;
import org.springframework.stereotype.Service;

@Service
public interface ServiceDao {
    public int CreateService(CreateServiceRequest createServiceRequest);
}
