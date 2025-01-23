
package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.ServiceEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
}