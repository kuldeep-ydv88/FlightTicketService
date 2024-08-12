package com.airlines.auth;

import com.airlines.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class AuthResponse {
    private String token;
    private Role role;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String id;
}
