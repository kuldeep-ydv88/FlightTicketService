package com.airlines.Auth.dto;

import com.airlines.common.constant.MessageConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class RegisterRequestDTO {

    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String userName;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String firstName;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String lastName;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private Date dateOfBirth;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String email;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String password;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String contactNumber;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String age;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String nationality;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String address;
    private String role;


}
