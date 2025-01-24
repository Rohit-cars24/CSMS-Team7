
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

    final private AppUserRepository appUserRepository;

    @Override
    public AppUserDetailsEntity getAppUser(LoginRequest loginRequest) {
        log.info("[AppUserDaoImpl] getAppUser {}", loginRequest);
        return appUserRepository.findAppUserDetailsByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Override
    public void signUp(SignUpRequest signupRequest) {

        log.info("[AppUserDaoImpl] signUp {}", signupRequest);

        AppUserDetailsEntity appUserDetails = new AppUserDetailsEntity();

        ObjectMapper mapper = new ObjectMapper();
        appUserDetails = mapper.convertValue(signupRequest, AppUserDetailsEntity.class);

        appUserDetails.setActive(true);

        appUserRepository.save(appUserDetails);

    }
}
