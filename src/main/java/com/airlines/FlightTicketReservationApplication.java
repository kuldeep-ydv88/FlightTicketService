package com.airlines;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FlightTicketReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTicketReservationApplication.class, args);
	}

}
