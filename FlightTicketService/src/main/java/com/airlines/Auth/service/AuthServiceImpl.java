package com.airlines.Auth.service;

import com.airlines.Auth.dto.*;
import com.airlines.common.constant.Constant;
import com.airlines.common.constant.MessageConstant;
import com.airlines.common.enums.RoleEnum;
import com.airlines.exception.InvalidCredentialsException;
import com.airlines.security.JwtTokenGenerator;
import com.airlines.user.entity.UserInfo;
import com.airlines.user.exception.UserException;
import com.airlines.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserInfoService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequestDTO loginRequest) {
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        if (Objects.isNull(userDetails)) {
            throw new InvalidCredentialsException("You are not registered with us. Please sign up.", HttpStatus.UNAUTHORIZED.value());
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        try {
            UserInfo userInfo = (UserInfo) userDetails;
            String authToken = jwtTokenGenerator.generate(userInfo, false);
            String refreshToken = jwtTokenGenerator.generate(userInfo, true);
            return AuthResponse.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message(MessageConstant.LOGIN_SUCCESSFULLY)
                    .id(userInfo.getId())
                    .userName(userInfo.getUsername())
                    .role(userInfo.getRole())
                    .token(authToken)
                    .refreshToken(refreshToken)
                    .build();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error while generating tokens.", e);
        }
    }

    @Override
    public RegisterResponse registerUser(RegisterRequestDTO registerRequestDTO) {
        if(Objects.nonNull(userService.findByEmail(registerRequestDTO.getEmail()))){
            throw new UserException(Constant.EMAIL_EXISTS);
        }
        String encryptedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());
        final var user = createUser(registerRequestDTO, encryptedPassword);
        UserInfo savedUser = userService.save(user);
        return RegisterResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Registration successful!")
                .id(savedUser.getId())
                .userName(savedUser.getUsername())
                .userInfo(savedUser)
                .build();
    }

    private static UserInfo createUser(RegisterRequestDTO registerRequestDTO, String encryptedPassword) {
        UserInfo user = new UserInfo();
        user.setUserName(registerRequestDTO.getUserName());
        user.setFirstName(registerRequestDTO.getFirstName());
        user.setLastName(registerRequestDTO.getLastName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setDateOfBirth(registerRequestDTO.getDateOfBirth());
        user.setContactNumber(registerRequestDTO.getContactNumber());
        user.setAddress(registerRequestDTO.getAddress());
        user.setAge(registerRequestDTO.getAge());
        user.setPassword(encryptedPassword);
        user.setNationality(registerRequestDTO.getNationality());
        user.setGender(registerRequestDTO.getGender());
        user.setRole(registerRequestDTO.getRole() != null ? registerRequestDTO.getRole() : String.valueOf(RoleEnum.USER));
        return user;
    }

}
