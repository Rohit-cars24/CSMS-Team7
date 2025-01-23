package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.VehicleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
    List<VehicleEntity> findByModel(String model);
    List<VehicleEntity> findByColor(String color);
    List<VehicleEntity> findByModelAndColor(String model, String color);

    //Optional<VehicleEntity> findByLicensePlate(String licensePlate);
    VehicleEntity findByLicensePlate(String licensePlate);
}