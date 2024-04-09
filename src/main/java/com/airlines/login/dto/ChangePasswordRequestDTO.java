package com.airlines.login.dto;

import com.airlines.common.constant.MessageKeyConstant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ChangePasswordRequestDTO {

    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String oldPassword;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String newPassword;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String confirmPassword;

}
