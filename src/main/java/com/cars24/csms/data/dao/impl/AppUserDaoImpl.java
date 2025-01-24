package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class AppUserDaoImpl implements AppUserDao {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUserDetailsEntity getAppUserDetails(LoginRequest loginRequest) {
        return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Override
    public void createUser(SignUpRequest signupRequest) {


        AppUserDetailsEntity appUserEntity = new AppUserDetailsEntity();

        // appUserEntity.setUser_id(10);
        appUserEntity.setActive(true);
        appUserEntity.setPassword(signupRequest.getPassword());
        appUserEntity.setUsername(signupRequest.getUsername());
        appUserEntity.setUserType(signupRequest.getUsertype().toString());

//        ObjectMapper objectMapper = new ObjectMapper();
//        AppUserEntity appUserEntity = objectMapper.convertValue(signupRequest , AppUserEntity.class);
//        appUserEntity.setActive(true);

        appUserRepository.save(appUserEntity);

    }
}