package com.airlines.login.service;

import com.airlines.login.dto.APIResponseDTO;
import com.airlines.login.dto.ChangePasswordRequestDTO;
import com.airlines.login.dto.LoginRequestDTO;
import com.airlines.login.dto.RegisterRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * This is a login service class
 * in here all the login operation occurs
 */
@Service
@Slf4j
public class LoginService {


    public APIResponseDTO login(LoginRequestDTO loginRequestDTO){
        return null;
    }

    public APIResponseDTO registerUser(RegisterRequestDTO registerRequestDTO){
        return null;
    }

    public APIResponseDTO changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, String email){
        return null;
    }



}
