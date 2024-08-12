package com.airlines.login.dto;

import com.airlines.role.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponse {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String message;

}
