package com.airlines.flight.repository;

import com.airlines.flight.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
