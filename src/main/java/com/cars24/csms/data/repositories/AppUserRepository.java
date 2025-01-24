package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AppUserRepository extends JpaRepository<AppUserDetailsEntity,Integer> {

    AppUserDetailsEntity findAppUserDetailsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    AppUserDetailsEntity findByUsername(@Valid @Email @NotNull String email);

    AppUserDetailsEntity getByUsername(@Valid @Email String email);
}