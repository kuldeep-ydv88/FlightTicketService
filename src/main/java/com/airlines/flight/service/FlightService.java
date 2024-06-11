package com.airlines.flight.service;

import com.airlines.login.dto.APIResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * This is service class for flight management
 * it returns response to the controller.
 */
@Slf4j
@Service
public class FlightService {

    /**
     * Add latest flight in db.
     * @return
     */
    public APIResponseDTO addFlight() {
        return null;

    }

    /**
     * This service class update the flights
     * @return
     */
    public APIResponseDTO updateFlight() {
        return null;
    }

    /**
     * This service cancel the flight or delete
     * this is soft delete
     * @return
     */
    public APIResponseDTO cancelFlight() {
        return null;
    }

    /**
     * This service give search flights
     * @return list of flights
     */

    public APIResponseDTO getFlightId() {
        return null;
    }

}
