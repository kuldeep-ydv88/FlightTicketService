package com.airlines.Auth.service;

import com.airlines.Auth.dto.*;

public interface AuthenticationService {
    AuthResponse login(LoginRequestDTO loginRequestDTO);
    RegisterResponse registerUser(RegisterRequestDTO registerRequestDTO);

}
