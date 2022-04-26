package gss.demo.flight.company.models;

import java.util.Set;

import gss.demo.flight.company.entities.BlueAirFlight;
import gss.demo.flight.company.enums.ClassType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightAgencyModel {

	private String name;
	private Boolean isTwoWay;
	private ClassType classType;
	private Set<BlueAirFlight> blueAirFlights; // 1 sau 2 zboruri
	

}
