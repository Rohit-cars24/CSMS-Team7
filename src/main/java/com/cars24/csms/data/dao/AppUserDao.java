package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserDetailsEntity;
import com.cars24.csms.data.requests.LoginRequest;
import com.cars24.csms.data.requests.SignUpRequest;

public interface AppUserDao {

    public AppUserDetailsEntity getAppUser(LoginRequest loginRequest);
    public void signUp(SignUpRequest signupRequest);
}
