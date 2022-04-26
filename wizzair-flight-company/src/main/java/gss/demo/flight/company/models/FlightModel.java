package gss.demo.flight.company.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightModel {
	
	private Long id;
	
	private LocalDate flightDate;
	
	private BigDecimal price;
	
	private BigDecimal estimatedTime;
	
	private Long passengers;
	
	private LocalDate departureDate;

	private LocalDate arrivalDate;

	private Long departureAirportId;
	private String departureAirportCode;
	private String departureAirportCountry;
	private String departureAirportCity;

	private Long arrivalAirportId;
	private String arrivalAirportCode;
	private String arrivalAirportCountry;
	private String arrivalAirportCity;
	
}
