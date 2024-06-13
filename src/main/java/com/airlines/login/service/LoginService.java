package com.airlines.login.service;

import com.airlines.common.constant.MessageKeyConstant;
import com.airlines.common.enums.RoleEnum;
import com.airlines.login.dto.*;
import com.airlines.login.repository.UserRepository;
import com.airlines.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * This is a login service class in here all the login operation occurs
 *
 * @Author kuldeep-ydv88
 */
@Service
@Slf4j
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequestDTO loginRequestDTO) {
        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
            var user = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow();
            log.info("This user present in the db : {}", user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            authResponse.setStatusCode(200);
            authResponse.setToken(jwt);
            authResponse.setRefreshToken(refreshToken);
            authResponse.setUserName(user.getUsername());
            authResponse.setRole(user.getRole());
            authResponse.setMessage(MessageKeyConstant.LOGIN_SUCCESSFULLY);
        } catch (Exception e) {
            authResponse.setStatusCode(500);
            authResponse.setMessage(e.getMessage());

        }
        return authResponse;
    }

    public AuthResponse registerUser(RegisterRequestDTO registerRequestDTO) {
        AuthResponse resp = new AuthResponse();

        User user = new User();
        user.setUserName(registerRequestDTO.getUserName());
        user.setFirstName(registerRequestDTO.getFirstName());
        user.setLastName(registerRequestDTO.getLastName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setDateOfBirth(registerRequestDTO.getDateOfBirth());
        user.setContactNumber(registerRequestDTO.getContactNumber());
        user.setAddress(registerRequestDTO.getAddress());
        user.setAge(registerRequestDTO.getAge());
        user.setPassword(registerRequestDTO.getPassword());
        user.setNationality(registerRequestDTO.getNationality());
        user.setRole(String.valueOf(RoleEnum.USER));
        User userData = userRepository.save(user);
        return resp;

    }

    public APIResponseDTO changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, String email) {
        return null;
    }

    public RefreshTokenResponseDTO refreshToken(AuthResponse authResponse) {
        RefreshTokenResponseDTO response = new RefreshTokenResponseDTO();
        String ourEmail = jwtUtils.extractUsername(authResponse.getToken());
        User users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(authResponse.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setJwtToken(jwt);
            response.setTkExpms("24");
        }
        return response;

    }

}
