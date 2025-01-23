package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmailAndPhone(String email, String phone);
    public boolean existsByEmail(String email);
    boolean existsByEmailAndPhone(String email,String phone);
    CustomerEntity findByUserid(int i);

}

