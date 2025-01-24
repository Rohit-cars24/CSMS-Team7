package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.CustomerEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findByUserid(int i);

    boolean existsByEmail(@Valid @Email @NotNull String email);

    boolean existsByEmailAndPhone(String email, String phone);

    Optional<CustomerEntity> findByEmailAndPhone(String email, String phone);

    CustomerEntity findAllByUserid(int userId);
}