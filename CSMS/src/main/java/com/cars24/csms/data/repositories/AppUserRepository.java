package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserDetailsEntity,Integer> {

    public AppUserDetailsEntity findAppUserDetailsByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);

}
