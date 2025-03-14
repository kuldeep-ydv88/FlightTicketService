package com.airlines.Auth.dto;


import lombok.Data;

@Data
public class RefreshTokenResponseDTO {
    private String jwtToken;
    private String tokenExpiration;
}

