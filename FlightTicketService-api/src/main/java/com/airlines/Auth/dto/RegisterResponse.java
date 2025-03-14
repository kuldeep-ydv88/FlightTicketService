package com.airlines.Auth.dto;

import com.airlines.user.entity.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private int statusCode;
    private String message;
    private String userName;
    private String id;
    private UserInfo userInfo;
}
