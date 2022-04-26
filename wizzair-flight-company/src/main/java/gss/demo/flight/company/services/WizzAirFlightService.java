package gss.demo.flight.company.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gss.demo.flight.company.entities.Airport;
import gss.demo.flight.company.entities.Flight;
import gss.demo.flight.company.entities.WizzAirFlight;
import gss.demo.flight.company.exceptions.FlightEntityNotFound;
import gss.demo.flight.company.exceptions.FlightModelNotFound;
import gss.demo.flight.company.models.FlightModel;
import gss.demo.flight.company.models.WizzAirFlightModel;
import gss.demo.flight.company.repositories.AirportRepository;
import gss.demo.flight.company.repositories.WizzAirFlightRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WizzAirFlightService {

	private final WizzAirFlightRepository airRepository;
	private final AirportRepository airportRepository;

	public WizzAirFlightService(WizzAirFlightRepository airRepository, AirportRepository airportRepository) {
		this.airRepository = airRepository;
		this.airportRepository = airportRepository;
	}
	
	public List<FlightModel> findAllFlights() {
		return toModelList(airRepository.findAll());
	}
	
	public void addFlight(FlightModel model) {
		WizzAirFlight flight = new WizzAirFlight();
		if(model == null) {
			throw new FlightModelNotFound("Model Not Found!!");
		}
		
		if(model.getId() == null) {
			// add new
			log.info("Save new Flight");
			flight.setId(model.getId());
		}
		// update
		flight.setFlightDate(model.getFlightDate());
		flight.setPrice(model.getPrice());
		flight.setEstimatedTime(model.getEstimatedTime());
		flight.setPassengers(model.getPassengers());
		flight.setDepartureDate(model.getDepartureDate());
		flight.setArrivalDate(model.getArrivalDate());
		
		if(model.getDepartureAirportId() != null) {
			Optional<Airport> optional = airportRepository.findById(model.getDepartureAirportId());
			if(optional.isPresent()) {
				flight.setDepartureAirport(optional.get());
			} else {
				log.error("No departure airport found with ID: " + model.getDepartureAirportId());
			}	
		} else {
			log.error("Departure airport ID is NULL!");
		}
		
		if(model.getArrivalAirportId() != null) {
			Optional<Airport> optional = airportRepository.findById(model.getArrivalAirportId());
			if(optional.isPresent()) {
				flight.setArrivalAirport(optional.get());
			} else {
				log.error("No arrival airport found with ID: " + model.getArrivalAirportId());
			}	
		} else {
			log.error("Arrival airport ID is NULL!");
		}
		
		WizzAirFlight saved = airRepository.save(flight);
		log.info("Saved WizzAir flight with id: " + saved.getId());
	}
	
	private FlightModel entityToBlueAirModel(Flight entity) {
		
		if(entity == null) {
			throw new FlightEntityNotFound("Not Found entity to convert.");
		}
		
		FlightModel model = new WizzAirFlightModel();
		model.setId(entity.getId());
		model.setFlightDate(entity.getFlightDate());
		model.setPrice(entity.getPrice());
		model.setEstimatedTime(entity.getEstimatedTime());
		model.setPassengers(entity.getPassengers());
		model.setDepartureDate(entity.getDepartureDate());
		model.setArrivalDate(entity.getArrivalDate());
		if(entity.getDepartureAirport() != null) {
			model.setDepartureAirportId(entity.getDepartureAirport().getId());
			model.setDepartureAirportCode(entity.getDepartureAirport().getCode());
			model.setDepartureAirportCountry(entity.getDepartureAirport().getCountry());
			model.setDepartureAirportCity(entity.getDepartureAirport().getCity());
		} else {
			log.error("No departure airport found!");
		}
		if(entity.getArrivalAirport() != null) {
			model.setArrivalAirportId(entity.getArrivalAirport().getId());
			model.setArrivalAirportCode(entity.getArrivalAirport().getCode());
			model.setArrivalAirportCountry(entity.getArrivalAirport().getCountry());
			model.setArrivalAirportCity(entity.getArrivalAirport().getCity());
		} else {
			log.error("No arrival airport found!");
		}
		return model;
	}
	
	private List<FlightModel> toModelList(List<WizzAirFlight> entityList) {
		List<FlightModel> modelList = new ArrayList<>();
		entityList.forEach(entity -> {
			modelList.add(entityToBlueAirModel(entity));
		});
		return modelList;
	}
}
