package com.airlines.login.loginDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;


@Data
@Tag(name = "Login ",description = "login request body")
public class LoginRequest {
    private String email;
    private String password;

}
