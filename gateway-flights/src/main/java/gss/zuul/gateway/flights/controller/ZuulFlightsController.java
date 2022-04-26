package gss.zuul.gateway.flights.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.web.ZuulController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gss.flights.blueair.dto.FlightModel;
import gss.zuul.gateway.flights.services.ZuulFlightsService;

@Controller
public class ZuulFlightsController extends ZuulController {

	Logger log = LoggerFactory.getLogger(ZuulFlightsController.class);
	
	private final ZuulFlightsService flightsService;
	
	public ZuulFlightsController(ZuulFlightsService flightsService) {
		this.flightsService = flightsService;
	}


    @RequestMapping("/all")
    public String getDetails(Model model) {
        model.addAttribute("flights", flightsService.getAllFlights());
        return "/flights/index";
    }

	@GetMapping("/search-flights")
	public String searchFlights(Model model) {
		FlightModel flight = new FlightModel();
		
		model.addAttribute("flight", flight);
		
		return "/flights/searchFlight";
	}
	
	@PostMapping("/flightsp")
	public ResponseEntity<String> saveAllFlights() {
		
		return ResponseEntity.ok("--- post all---");
	}
}
