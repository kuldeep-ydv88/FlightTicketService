package com.airlines.flight.controller;


import com.airlines.flight.repository.FlightRepository;
import com.airlines.flight.service.FlightService;
import com.airlines.login.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
@Tag(name = "flight", description = "flight controller APIs")
@Slf4j
public class FlightController {
    /**
     * This is flight controller for handling the request
     */
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository repository;
    @PostMapping("/add")
    public APIResponseDTO addFlight() {
        return null;
    }
    @GetMapping("/get/flights/details")
    public APIResponseDTO getFlightInfo() {
        return null;
    }
@PutMapping("/updateInfo")
    public APIResponseDTO updateFlight() {
        return null;

    }
    @DeleteMapping
    public APIResponseDTO deleteFlight() {
        return null;
    }

}
