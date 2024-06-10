package com.airlines.flight.dto;

import com.airlines.common.constant.MessageKeyConstant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SearchFlightDTO {

    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String from;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String to;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String departOn;
    @NotBlank(message = MessageKeyConstant.MANDATORY_PARAM_MISSING)
    private String travelClass;
   private String numberOfPassengers;

}
