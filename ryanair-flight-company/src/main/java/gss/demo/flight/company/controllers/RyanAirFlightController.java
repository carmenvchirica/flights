package gss.demo.flight.company.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import gss.demo.flight.company.models.FlightModel;
import gss.demo.flight.company.services.RyanAirFlightService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ryanair")
public class RyanAirFlightController {
	
	private RyanAirFlightService airFlightService;
	
	
	public RyanAirFlightController(RyanAirFlightService airFlightService) {
		this.airFlightService = airFlightService;
	}
	
	@GetMapping("/all") 
	public ResponseEntity<List<FlightModel>> findAllFlights() {
		return new ResponseEntity<List<FlightModel>>(airFlightService.findAllFlights(), HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<FlightModel> addNewFlight(@RequestBody FlightModel model) {
		airFlightService.addFlight(model);
		return new ResponseEntity<FlightModel>(model, HttpStatus.CREATED);
	}

	@PostMapping("/add")
	public void addOrUpdateFlight(@ModelAttribute("ryanair") FlightModel model, BindingResult result) {

		if(result.hasErrors()) {
            log.debug("Errors: ");
            result.getAllErrors().forEach(err -> {
                log.debug(err.toString());
            });
        }
		
		airFlightService.addFlight(model);
	}
}
