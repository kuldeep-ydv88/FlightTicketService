package com.airlines.user.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private String gender;
    private String dob;
}
