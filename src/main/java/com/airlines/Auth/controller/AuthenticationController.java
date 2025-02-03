package com.airlines.Auth.controller;

import com.airlines.Auth.dto.AuthResponse;
import com.airlines.Auth.dto.LoginRequestDTO;
import com.airlines.Auth.dto.RefreshTokenResponseDTO;
import com.airlines.Auth.dto.RegisterRequestDTO;
import com.airlines.Auth.service.AuthenticationService;
import com.airlines.common.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author kuldeep
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "login API", description = "request contains user's email and password")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        log.info("LoggedIn user email {}", loginRequestDTO.getEmail());
        return authenticationService.login(loginRequestDTO);
    }

    @Operation(summary = "register API", description =   "request contains user details")
    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        log.info("we have to register for the user email : {}", registerRequestDTO.getEmail());
        return authenticationService.registerUser(registerRequestDTO);
    }

    @Operation(summary = "Refresh access token API", description = "Refresh the user access token")
    @GetMapping("/refreshment")
    public RefreshTokenResponseDTO refreshToken(RefreshTokenResponseDTO request) {
        System.out.println("refresh token logic");
        return null;
    }

    @Operation(summary = "forget password", description = "request contain user i'd")
    @PostMapping("/logout")
    public APIResponseDTO logout() {
        System.out.println("logout logic ");
        return null;
    }
}
