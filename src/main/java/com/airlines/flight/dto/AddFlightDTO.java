package com.airlines.flight.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class AddFlightDTO {

    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalTime;
    private int seatCapacity;
    private double price;
    private long durationMinutes;

}
