package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppointmentsEntity;
import com.cars24.csms.data.requests.CreateAppointmentRequest;
import com.cars24.csms.data.requests.GetAppointmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentDao {
    public int createAppointment(CreateAppointmentRequest createAppointmentRequest);
    public List<AppointmentsEntity> getAppointment(GetAppointmentRequest getAppointmentRequest, int userid);
}
