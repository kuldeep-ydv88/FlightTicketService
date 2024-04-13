package com.airlines.flight.controller;


import com.airlines.flight.dto.AddFlightDTO;
import com.airlines.flight.dto.SearchFlightDTO;
import com.airlines.flight.repository.FlightRepository;
import com.airlines.flight.service.FlightService;
import com.airlines.login.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public APIResponseDTO addFlight(@RequestBody AddFlightDTO addFlightDTO) {

        return null;
    }

    @GetMapping("/get/flights/details")
    public APIResponseDTO getFlightInfo(@RequestBody SearchFlightDTO searchFlightDTO) {
        return null;
    }

    @PutMapping("/updateInfo")
    public APIResponseDTO updateFlight() {
        return null;

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Schedule flight ",description = " Request contains flight ID ")
    public ResponseEntity<Void> deleteFlight(@Valid @PathVariable String id) {
        log.info("Request ");
        return null;
    }



}
