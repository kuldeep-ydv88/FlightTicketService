package com.airlines.Auth.service;

import com.airlines.Auth.dto.AuthResponse;
import com.airlines.Auth.dto.LoginRequestDTO;
import com.airlines.Auth.dto.RefreshTokenResponseDTO;
import com.airlines.Auth.dto.RegisterRequestDTO;

public interface AuthenticationService {
    AuthResponse login(LoginRequestDTO loginRequestDTO);
    AuthResponse registerUser(RegisterRequestDTO registerRequestDTO);
    RefreshTokenResponseDTO refreshToken(AuthResponse authResponse);

}
