package com.airlines.login.dto;

import com.airlines.common.constant.MessageKeyConstant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class RegisterRequestDTO {

    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String userName;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String firstName;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String lastName;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private Date dateOfBirth;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String email;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String password;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String contactNumber;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String nationality;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String address;


}
