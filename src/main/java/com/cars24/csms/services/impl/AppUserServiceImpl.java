package com.cars24.csms.services.impl;

import com.cars24.csms.data.requests.SignUpRequest;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
import com.cars24.csms.data.dao.impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j

public class AppUserServiceImpl implements AppUserService {

    private final AppUserDaoImpl appUserDoaImpl;
    private final AppUserRepository appUserRepository;

    @Override
    public LoginResponse getAppUserDetails(LoginRequest loginRequest) {

        AppUserDetailsEntity appUserEntity = appUserDoaImpl.getAppUserDetails(loginRequest);

        LoginResponse loginResp = new LoginResponse();
        loginResp.setUser_id(appUserEntity.getUser_id());
        loginResp.setUsername(appUserEntity.getUsername());

        return loginResp;

    }

    @Override
    public ResponseEntity<ApiResponse> createUser(SignUpRequest signupRequest) {

        boolean exists = false;
        ApiResponse resp = new ApiResponse();

        exists = appUserRepository.existsByUsername(signupRequest.getUsername());


        if(!exists) {

            resp.setStatuscode(HttpStatus.OK.value());
            resp.setSuccess(true);
            resp.setMessage("User signed up successfully");
            resp.setService("APPUSR - " + HttpStatus.OK.value());
            resp.setData(null);

            appUserDoaImpl.createUser(signupRequest);

            return ResponseEntity.ok().body(resp);

        }

        else{

            throw new UserServiceException("User Already Exist");

        }
    }
}
