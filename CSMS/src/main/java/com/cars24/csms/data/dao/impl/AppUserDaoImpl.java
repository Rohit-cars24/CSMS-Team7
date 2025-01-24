package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppUserDaoImpl implements AppUserDao {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUserDetailsEntity getappuserdetails(LoginRequest loginRequest) {
       return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Override
    public void createuser(SignUpRequest signUpRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        AppUserDetailsEntity appUserDetailsEntity =objectMapper.convertValue(signUpRequest, AppUserDetailsEntity.class);

        appUserDetailsEntity.setIs_enabled(true);
        appUserRepository.save(appUserDetailsEntity);
    }


}
