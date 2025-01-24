package com.cars24.csms.controllers;

import com.cars24.csms.data.requests.SignUpRequest;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
@Service
@RestController


public class AppUserController {

    private final AppUserServiceImpl appUserServiceImpl;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getUser(@Valid @RequestBody LoginRequest loginRequest){

        LoginResponse loginResp = appUserServiceImpl.getAppUserDetails(loginRequest);
        return ResponseEntity.ok().body(loginResp);
        //return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody SignUpRequest signupRequest){
        log.info(signupRequest.getUsername());
        log.info(signupRequest.getPassword());

        return appUserServiceImpl.createUser(signupRequest);

    }

}
