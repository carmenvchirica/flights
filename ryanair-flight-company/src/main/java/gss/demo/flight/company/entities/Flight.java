package gss.demo.flight.company.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Flight extends BaseEntity {
	
	private LocalDate flightDate;
	
	private BigDecimal price;
	
	private BigDecimal estimatedTime;
	
	private Long passengers;
	
	@Column(name="departure_date")
	private LocalDate departureDate;
	
	@Column(name="arrival_date")
	private LocalDate arrivalDate;
	
	@OneToOne
	private Airport departureAirport;
	
	@OneToOne
	private Airport arrivalAirport;
	
}
