package com.airlines.auth;

import com.airlines.common.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
@Tag(name = "login", description = "Login Api for users")
@Slf4j
public record AuthenticationController(AuthenticationService authenticationService) {

    @Operation(summary = "login API", description = "request contains user's username and password")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return authenticationService.login(loginRequestDTO);
    }

    @Operation(summary = "register API", description = "request contains user details")
    @PostMapping("/register")
    public SignUpResponse registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return authenticationService.registerUser(registerRequestDTO);
    }

    @Operation(summary = "Refresh access token API", description = "Refresh the user access token")
    @GetMapping("/refreshment")
    public RefreshTokenResponseDTO refreshToken(RefreshTokenResponseDTO request) {
        return null;
    }

}