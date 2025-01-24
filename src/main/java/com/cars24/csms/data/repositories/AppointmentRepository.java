package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppointmentsEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentsEntity, Integer> {

    //List<AppointmentsEntity> findByCustomer_id(Integer customer_id);

    List<AppointmentsEntity> findByStatus(String status);

    List<AppointmentsEntity> findAllByStatus(String status);

    boolean existsByCustomerIdAndVehicleIdAndServiceId(@Valid @Min(value = 1, message = "Invalid service ID") int serviceId, @Valid @Min(value = 1, message = "Invalid vehicle ID") int vehicleId, @Valid @Min(value = 1, message = "Invalid customer ID") int customerId);

    List<AppointmentsEntity> findAllByCustomerId(int userid);

    List<Integer> findAllAppointmentIdByCustomerId(int customerId);

    boolean existsByAppointmentId(int appointmentId);
}

