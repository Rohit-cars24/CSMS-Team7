package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppointmentDao;
import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.entities.CustomerEntity;
import com.cars24.csms.data.repositories.AppointmentRepository;
import com.cars24.csms.data.repositories.CustomerRepository;
import com.cars24.csms.data.requests.CreateAppointmentRequest;
import com.cars24.csms.data.requests.GetAppointmentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j

public class AppointmentDaoImpl implements AppointmentDao {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;

    @Override
    public int createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        log.info("[AppointmentDaoImpl] createAppointment {}", createAppointmentRequest);

        // SAVE - Nothing but ur insert query
        AppointmentsEntity appointmentsEntity = new AppointmentsEntity();
        appointmentsEntity.setCustomerId(createAppointmentRequest.getCustomer_id());
        appointmentsEntity.setStatus(createAppointmentRequest.getStatus().toString());
        appointmentsEntity.setVehicleId(createAppointmentRequest.getVehicle_id());
        appointmentsEntity.setAppointmentDate(createAppointmentRequest.getA_date());
        appointmentsEntity.setServiceId(createAppointmentRequest.getService_id());

//        appointmentRepository.deleteById(14);
        appointmentRepository.save(appointmentsEntity);
        return 0;
    }

    @Override
    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest, int userid) {

        log.info("[AppointmentDaoImpl] getAppointment {}", getAppointmentRequest);

        CustomerEntity customerEntity = customerRepository.findByUserid(userid);

        return appointmentRepository.findAllByCustomerId(customerEntity.getUserid());

    }

}