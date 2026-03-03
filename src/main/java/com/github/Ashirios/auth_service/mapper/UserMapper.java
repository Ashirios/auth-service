package com.github.Ashirios.auth_service.mapper;

import org.springframework.stereotype.Component;


import com.github.Ashirios.auth_service.dto.RegisterRequest;
import com.github.Ashirios.auth_service.entity.UserEntity;

@Component
public interface UserMapper {

    public UserEntity toEntity(RegisterRequest dto);


    

}
