package com.airlines.flight.dto;

import com.airlines.common.constant.MessageConstant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SearchFlightDTO {

    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String from;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String to;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String departOn;
    @NotBlank(message = MessageConstant.MANDATORY_PARAM_MISSING)
    private String travelClass;
    private String numberOfPassengers;

}
