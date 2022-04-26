package gss.demo.flight.company.models;

import java.util.Set;

import gss.demo.flight.company.entities.RyanAirFlight;
import gss.demo.flight.company.enums.ClassType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightAgencyModel {

	private String name;
	private Boolean isTwoWay;
	private ClassType classType;
	private Set<RyanAirFlight> ryanAirFlights; // 1 sau 2 zboruri
	

}
