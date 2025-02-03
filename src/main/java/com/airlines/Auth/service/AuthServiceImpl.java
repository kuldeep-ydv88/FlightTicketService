package com.airlines.Auth.service;

import com.airlines.Auth.dto.LoginRequestDTO;
import com.airlines.Auth.dto.RefreshTokenResponseDTO;
import com.airlines.Auth.dto.RegisterRequestDTO;
import com.airlines.Auth.dto.AuthResponse;
import com.airlines.common.constant.MessageConstant;
import com.airlines.common.enums.RoleEnum;
import com.airlines.security.JwtTokenGenerator;
import com.airlines.user.repository.UserRepository;
import com.airlines.user.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenGenerator jwtUtils;

    @Override
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
            authResponse.setMessage(MessageConstant.LOGIN_SUCCESSFULLY);
        } catch (Exception e) {
            authResponse.setStatusCode(500);
            authResponse.setMessage(e.getMessage());

        }
        return authResponse;
    }

    @Override
    public AuthResponse registerUser(RegisterRequestDTO registerRequestDTO) {
        AuthResponse resp = new AuthResponse();
        UserInfo user = new UserInfo();
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
        UserInfo userData = userRepository.save(user);
        return resp;

    }

    @Override
    public RefreshTokenResponseDTO refreshToken(AuthResponse authResponse) {
        RefreshTokenResponseDTO response = new RefreshTokenResponseDTO();
        String ourEmail = jwtUtils.extractUsername(authResponse.getToken());
        UserInfo users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(authResponse.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setJwtToken(jwt);
            response.setTokenExpiration("24");
        }
        return response;

    }

}
