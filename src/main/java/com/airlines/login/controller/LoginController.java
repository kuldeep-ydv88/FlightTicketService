package com.airlines.login.controller;

import com.airlines.login.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flight")
@Tag(name = "login", description = "Login Api for users")
@Slf4j
public class LoginController {
    /**
     * This is login API
     */
    @Operation(summary = "login API", description = "request contains user's email and password")
    @PostMapping("/login")
    public APIResponseDTO loginUser() {
        return null;
    }

    @Operation(summary = "register API", description = "request contains user details")
    @PostMapping("/register")
    public APIResponseDTO registerUser() {
        return null;
    }

}
