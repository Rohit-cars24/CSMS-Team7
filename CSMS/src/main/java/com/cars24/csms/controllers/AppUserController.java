package com.cars24.csms.controllers;

import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;
import com.cars24.csms.data.responses.ApiResponse;
import com.cars24.csms.data.responses.LoginResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uid")
@Validated
@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    private final AppUserServiceImpl appUserServiceImpl;
    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getUser(@Valid @RequestBody LoginRequest loginRequest ){

        LoginResponse loginResponse = appUserServiceImpl.getappuserdetails(loginRequest);
        return ResponseEntity.ok().body(loginResponse);


    }
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> createuser(@Valid @RequestBody SignUpRequest signUpRequest){
        log.info(signUpRequest.getUsername());
        log.info(signUpRequest.getPassword());
        log.info("[createuser] createuser {}", signUpRequest);

        return appUserServiceImpl.createuser(signUpRequest);

    }
}
