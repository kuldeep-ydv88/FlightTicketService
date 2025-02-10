package com.airlines.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class APIResponseDTO {
	private String message;
	private Object objectDetails;
}