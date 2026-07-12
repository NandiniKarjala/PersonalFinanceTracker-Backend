package com.tcs.personalfinancetrackerv2.controller;

import com.tcs.personalfinancetrackerv2.dto.AuthResponse;
import com.tcs.personalfinancetrackerv2.dto.LoginRequest;
import com.tcs.personalfinancetrackerv2.dto.RegisterRequest;
import com.tcs.personalfinancetrackerv2.service.AuthService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}