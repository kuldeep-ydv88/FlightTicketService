package com.airlines.Auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    private int statusCode;
    private String message;
    private String token;
    private String refreshToken;
    private String userName;
    private String role;
    private String id;

}
