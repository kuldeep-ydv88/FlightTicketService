package com.airlines.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponseDTO {
    private String status;
    private Object objectDetails;
}
