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

    private final AppUserDaoImpl appUserDaoImpl;
    private final AppUserRepository appUserRepository;

    @Override
    public LoginResponse getAppUserDetails(LoginRequest loginRequest) {

        log.info("[AppUserServiceImpl] getAppUserDetails {}", loginRequest);

        AppUserDetailsEntity appUserDetails = appUserDaoImpl.getAppUser(loginRequest);
        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setId(appUserDetails.getId());
        loginResponse.setUsername(appUserDetails.getUsername());

        return loginResponse;
    }

    @Override
    public ResponseEntity<ApiResponse> signUp(SignUpRequest signupRequest) {

        log.info("[AppUserServiceImpl] signUp {}", signupRequest);

        ApiResponse apiResponse = new ApiResponse();

        if(appUserRepository.existsByUsername(signupRequest.getUsername())){
            throw new UserServiceException("User already exists");
        }

        appUserDaoImpl.signUp(signupRequest);

        apiResponse.setStatuscode(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setMessage("User signed up succesfully");
        apiResponse.setService("AppUsr" + HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.ok().body(apiResponse);

    }

}