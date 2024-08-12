package com.airlines.login.service;

import com.airlines.common.enums.RoleEnum;
import com.airlines.login.InvalidCredentialsException;
import com.airlines.login.dto.*;
import com.airlines.login.repository.UserRepository;
import com.airlines.role.Role;
import com.airlines.role.RoleException;
import com.airlines.role.RoleService;
import com.airlines.user.User;
import com.airlines.user.UserException;
import com.airlines.user.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * This is a login service class in here all the login operation occurs
 *
 * @Author kuldeep-ydv88
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserInfoService userInfoService;
    private final RoleService roleService;


    public AuthResponse login(LoginRequestDTO loginRequestDTO) {
        UserDetails userDetails = userInfoService.loadUserByUsername(loginRequestDTO.getUsername());
        if (Objects.isNull(userDetails)) {
            throw new InvalidCredentialsException("You are not registered with us. Please sign up.", HttpStatus.UNAUTHORIZED.value());
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        try {
            User user = (User) userDetails;
            String authToken = jwtUtils.generateToken(user);
            return AuthResponse.builder()
                    .id(user.getId())
                    .fistName(user.getFirstName())
                    .lastName(user.getLastName())
                    .token(authToken)
                    .phoneNumber(user.getContactNumber())
                    .role(user.getRole())
                    .build();
        } catch (InvalidCredentialsException e) {
            throw new RuntimeException(e);
        }
    }


    public SignUpResponse registerUser(RegisterRequestDTO registerRequestDTO) {
        if (Objects.nonNull(userInfoService.findByUsername(registerRequestDTO.getUserName()))) {
            throw new UserException("Username is already taken, please try something different.");
        }
        Role role = roleService.findByName("ROLE_CUSTOMER");
        User userInfo = new User();
        userInfo.setUserName(registerRequestDTO.getUserName());
        userInfo.setFirstName(registerRequestDTO.getFirstName());
        userInfo.setLastName(registerRequestDTO.getLastName());
        userInfo.setEmail(registerRequestDTO.getEmail());
        userInfo.setDateOfBirth(registerRequestDTO.getDateOfBirth());
        userInfo.setAge(registerRequestDTO.getAge());
        userInfo.setNationality(registerRequestDTO.getNationality());
        userInfo.setAddress(registerRequestDTO.getAddress());
        userInfo.setContactNumber(registerRequestDTO.getContactNumber());
        userInfo.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userInfo = userInfoService.save(userInfo);
        return SignUpResponse.builder()
                .message("User created successfully")
                .username(userInfo.getUsername())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .build();

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
