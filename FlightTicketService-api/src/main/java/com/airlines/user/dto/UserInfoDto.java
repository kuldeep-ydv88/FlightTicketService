package com.airlines.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String gender;
    private Date dob;
}
