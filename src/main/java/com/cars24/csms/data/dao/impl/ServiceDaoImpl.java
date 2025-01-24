package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.ServiceDao;
import com.cars24.csms.data.entities.ServiceEntity;
import com.cars24.csms.data.repositories.ServiceRepository;
import com.cars24.csms.data.requests.CreateServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ServiceDaoImpl implements ServiceDao {

    private final ServiceRepository ServiceRepository;


    @Override
    public int CreateService(CreateServiceRequest createServiceRequest) {
        ServiceEntity serviceEntity =new ServiceEntity();
        serviceEntity.setService_name(createServiceRequest.getService_name().toString());
        serviceEntity.setPrice(createServiceRequest.getPrice());
        ServiceRepository.save(serviceEntity);
        return 0;
    }
}
