package com.airlines.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponseDTO {
    private String jwtToken;
    private String tkExpms;

}
