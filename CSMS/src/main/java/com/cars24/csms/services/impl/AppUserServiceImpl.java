package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.impl.AppUserDaoImpl;
import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements com.cars24.csms.services.AppUserService {
    private final AppUserDaoImpl appUserDetailsDao;
    private final AppUserRepository appUserRepository;



    public LoginResponse getappuserdetails(@Valid LoginRequest loginRequest) {
        AppUserDetailsEntity appUserDetailsEntity =appUserDetailsDao.getappuserdetails(loginRequest);
        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setId(appUserDetailsEntity.getId());
        loginResponse.setUsername(appUserDetailsEntity.getUsername());
        return loginResponse;
    }




    @Override
    public ResponseEntity<ApiResponse> createuser(SignUpRequest signUpRequest) {

        boolean exists = false;
        ApiResponse apiResponse = new ApiResponse();

        exists = appUserRepository.existsByUsername(signUpRequest.getUsername());

        if(!exists) {

            apiResponse.setStatuscode(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("user signed up successfully");
            apiResponse.setService("APPUSR - " + HttpStatus.OK.value());
            apiResponse.setData(null);


            appUserDetailsDao.createuser(signUpRequest);


            return ResponseEntity.ok().body(apiResponse);

        }

        else{

            apiResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setSuccess(false);
            apiResponse.setMessage("user salready exists");
            apiResponse.setService("APPUSR - " + HttpStatus.OK.value());
            apiResponse.setData(null);




            return ResponseEntity.ok().body(apiResponse);
        }
    }

}

