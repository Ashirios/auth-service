package com.github.Ashirios.auth_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResponse {

    @JsonProperty("token")
    String token;
    @Builder.Default
    String type = "Bearer";
    @JsonProperty("username")
    String username;

    @JsonProperty("id")
    Long id;

    

}
