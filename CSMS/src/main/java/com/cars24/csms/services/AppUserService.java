package com.cars24.csms.services;

import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AppUserService {
    public  LoginResponse getappuserdetails(LoginRequest loginRequest);
    public ResponseEntity<ApiResponse> createuser(SignUpRequest signUpRequest);


}
