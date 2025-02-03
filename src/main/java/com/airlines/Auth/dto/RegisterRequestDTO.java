package com.airlines.Auth.dto;

import com.airlines.common.constant.MessageKeyConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
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
    private String age;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String nationality;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String address;
    private String role;


}
