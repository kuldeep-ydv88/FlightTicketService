package com.airlines.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponseDTO {
    private String jwtToken;
    private String tkExpms;

}
