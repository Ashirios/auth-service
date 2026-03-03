package com.github.Ashirios.auth_service.mapper;

import org.springframework.stereotype.Component;


import com.github.Ashirios.auth_service.dto.RegisterRequest;
import com.github.Ashirios.auth_service.entity.UserEntity;
import com.github.Ashirios.auth_service.enums.Role;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public UserEntity toEntity(RegisterRequest dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setRole(Role.USER);
        
        return entity;
    }




    



}
