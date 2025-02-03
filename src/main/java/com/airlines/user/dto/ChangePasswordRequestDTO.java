package com.airlines.user.dto;

import com.airlines.common.constant.MessageKeyConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordRequestDTO {

    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String oldPassword;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String newPassword;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String confirmPassword;

}
