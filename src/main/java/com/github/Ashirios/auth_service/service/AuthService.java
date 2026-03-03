package com.github.Ashirios.auth_service.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.Ashirios.auth_service.dto.AuthResponse;
import com.github.Ashirios.auth_service.dto.LoginRequest;
import com.github.Ashirios.auth_service.dto.RegisterRequest;
import com.github.Ashirios.auth_service.mapper.UserMapper;
import com.github.Ashirios.auth_service.repository.UserRepository;
import com.github.Ashirios.auth_service.util.JwtUtils;
import com.github.Ashirios.auth_service.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    final private UserMapper mapper;
    final private UserRepository repository;
    final private PasswordEncoder encoder;
    final private JwtUtils util;
    final private AuthenticationManager manager;
    
    public AuthResponse register(RegisterRequest request){
        UserEntity user = mapper.toEntity(request);
        user.setPassword(encoder.encode(request.getPassword()));
        repository.save(user);
        String token = util.generateToken(user.getUsername());
        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .id(user.getId())
                .build();
    }

    public AuthResponse login(LoginRequest dto){
        manager.authenticate(
            new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
            )
        );

        UserEntity user = repository.findByUsername(dto.getUsername())
                                .orElseThrow(() -> new RuntimeException("User not found"));


        String token = util.generateToken(user.getUsername());

        return AuthResponse.builder()
                    .username(user.getUsername())
                    .id(user.getId())
                    .token(token)
                    .build();


    }



}
