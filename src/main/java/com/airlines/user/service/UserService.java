package com.airlines.user.service;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.user.dto.UserInfoDto;
import com.airlines.user.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Kuldeep
 */
public interface UserService {
    UserDetails loadUserByUsername(String username);
    List<UserInfo> findAll();
    UserInfoDto getUserDetails(String id);
    UserInfoDto updateUserDetails(UserInfoDto userInfoDto, String id);
     boolean changePassword(ChangePasswordRequestDTO requestPayload);
}
