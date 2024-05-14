package com.airlines.login.controller;

import com.airlines.login.dto.*;
import com.airlines.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
@Tag(name = "login", description = "Login Api for users")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * This is the Login API.
     * @param loginRequestDTO
     * @return
     */
    @Operation(summary = "login API", description = "request contains user's email and password")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        log.info("LoggedIn user email {}", loginRequestDTO.getEmail());
        return loginService.login(loginRequestDTO);
    }

    /**
     * This is the Register API for users.
     * @param registerRequestDTO
     * @return
     */
    @Operation(summary = "register API", description = "request contains user details")
    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        log.info("we have to register for the user email : {}", registerRequestDTO.getEmail());
        return loginService.registerUser(registerRequestDTO);
    }

    /**
     * This is change password or reset password API.
     * @param changePasswordRequestDTO
     * @param email
     * @return
     */

    @Operation(summary = "change password API", description = "request contain user email")
    @PostMapping("/change-password")
    public APIResponseDTO changePassword(@RequestBody @Valid ChangePasswordRequestDTO changePasswordRequestDTO,
                                         @RequestHeader("email") String email) {
        log.info("change password for the user's email : {}", email);
        return loginService.changePassword(changePasswordRequestDTO, email);
    }

    /**
     * This is logout API for users. this will remove jwt token.
     * @return
     */
    @Operation(summary = "forget password",description = "request contain user i'd")
    @PostMapping("/logout")
    public APIResponseDTO logout(){
        return null;
    }
    @Operation(summary = "Refresh access token API", description = "Refresh the user access token")
    @GetMapping("/refreshment")
    public RefreshTokenResponseDTO refreshToken (RefreshTokenResponseDTO request){
        return null;
    }

}