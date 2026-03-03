package com.github.Ashirios.auth_service.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Ashirios.auth_service.dto.AuthResponse;
import com.github.Ashirios.auth_service.dto.LoginRequest;
import com.github.Ashirios.auth_service.dto.RegisterRequest;
import com.github.Ashirios.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    final private AuthService service; 

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest dto){
        return service.register(dto);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest dto){
        return service.login(dto);
    }




}
