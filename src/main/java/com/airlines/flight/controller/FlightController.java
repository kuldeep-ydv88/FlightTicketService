package com.airlines.flight.controller;
import com.airlines.flight.service.FlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flights/")
@Tag(name = "flight",description = "flight controller APIs")
@Slf4j
public class FlightController {
    @Autowired
    private FlightService flightService;
    public void addFlight(){

    }

    public void getFlightInfo(){

    }
    public void updateFlight(){

    }
    public void deleteFlight(){

    }

}
