package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.servicedao;
import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.repositories.servicerepositories;
import com.cars24.csms.data.req.CreateServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ServiceDaoImpl implements ServiceDao {

    private final servicerepositories servicerepositories;


    @Override
    public int CreateService(CreateServiceRequest createServiceRequest) {
        ServicesEntity servicesEntity=new ServicesEntity();
        servicesEntity.setService_name(createServiceRequest.getService_name().toString());
        servicesEntity.setPrice(createServiceRequest.getPrice());
        servicerepositories.save(servicesEntity);
        return 0;
    }
}
