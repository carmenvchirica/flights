package gss.zuul.gateway.flights.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gss.flights.blueair.dto.FlightModel;
import gss.zuul.gateway.flights.feign.BlueairFeign;
import gss.zuul.gateway.flights.feign.RyanairFeign;
import gss.zuul.gateway.flights.feign.WizzairFeign;

@Service
public class ZuulFlightsService {
	
	private final BlueairFeign blueairFeign;
	private final RyanairFeign ryanairFeign;
	private final WizzairFeign wizzairFeign;
	
	public ZuulFlightsService(BlueairFeign blueairFeign, RyanairFeign ryanairFeign, WizzairFeign wizzairFeign) {
		this.blueairFeign = blueairFeign;
		this.ryanairFeign = ryanairFeign;
		this.wizzairFeign = wizzairFeign;
	}

	public List<FlightModel> getAllFlights() {
		List<FlightModel> allFlights = new ArrayList<FlightModel>();
		
		if(blueairFeign != null && blueairFeign.getAll().size() > 0) {
			List<FlightModel> blueairFlights = blueairFeign.getAll();
			allFlights.addAll(blueairFlights);
			System.out.println("Blueair: " + blueairFlights);
		}
		
		if(ryanairFeign != null && ryanairFeign.getAll().size() > 0) {
			List<FlightModel> ryanairFlights = ryanairFeign.getAll();
			allFlights.addAll(ryanairFlights);
			System.out.println("Ryanair: " + ryanairFeign);
		}
		
		if(wizzairFeign != null && wizzairFeign.getAll().size() > 0) {
			List<FlightModel> wizzairFlights = wizzairFeign.getAll();
			allFlights.addAll(wizzairFlights);
			System.out.println("wizzair: " + wizzairFlights);
		}
		System.out.println("all: " + allFlights);
		return allFlights;
	}
	
	

}
