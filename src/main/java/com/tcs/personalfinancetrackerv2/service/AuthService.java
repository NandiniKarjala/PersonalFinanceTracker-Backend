package com.tcs.personalfinancetrackerv2.service;

import com.tcs.personalfinancetrackerv2.dto.RegisterRequest;
import com.tcs.personalfinancetrackerv2.dto.LoginRequest;
import com.tcs.personalfinancetrackerv2.dto.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}