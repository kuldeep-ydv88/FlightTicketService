package com.airlines.user.dto;

import com.airlines.common.constant.MessageConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequestDTO {

    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String oldPassword;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String newPassword;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String confirmPassword;

}
