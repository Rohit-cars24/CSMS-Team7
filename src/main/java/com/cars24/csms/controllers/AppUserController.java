
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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
@Service
@RestController

public class AppUserController {

    private final AppUserServiceImpl appUserService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getAppUser(@Valid @RequestBody LoginRequest loginRequest){
        log.info("[AppUserServiceImpl] getAppUser {}", loginRequest);
        LoginResponse loginResponse = appUserService.getAppUserDetails(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> createAppUser(@Valid @RequestBody SignUpRequest signupRequest){
        log.info("[AppUserServiceImpl] createAppUser {}", signupRequest);
        return appUserService.signUp(signupRequest);
    }
}
