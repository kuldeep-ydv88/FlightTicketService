package com.airlines.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "Flight")
public class Flight {
    @Id
    @Generated
    private String id;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private Date departureTime;
    private Date arrivalTime;
    private String price;
}
