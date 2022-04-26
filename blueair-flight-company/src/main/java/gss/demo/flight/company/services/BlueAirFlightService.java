package gss.demo.flight.company.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gss.demo.flight.company.entities.Airport;
import gss.demo.flight.company.entities.BlueAirFlight;
import gss.demo.flight.company.exceptions.BlueAirFlightEntityNotFound;
import gss.demo.flight.company.exceptions.BlueAirFlightModelNotFound;
import gss.demo.flight.company.models.BlueAirFlightModel;
import gss.demo.flight.company.repositories.AirportRepository;
import gss.demo.flight.company.repositories.BlueAirFlightsRepository;
import gss.flights.blueair.dto.FlightModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlueAirFlightService {

	private final BlueAirFlightsRepository blueAirRepository;
	private final AirportRepository airportRepository;

	public BlueAirFlightService(BlueAirFlightsRepository airRepository, AirportRepository airportRepository) {
		this.blueAirRepository = airRepository;
		this.airportRepository = airportRepository;
	}
	
	public List<FlightModel> findAllFlights() {
		return toBlueAirModelList(blueAirRepository.findAll());
	}
	
	
	public void addFlight(FlightModel model) {
		BlueAirFlight blueAirFlight = new BlueAirFlight();
		if(model == null) {
			throw new BlueAirFlightModelNotFound("BlueAir Model Not Found!!");
		}
		
		if(model.getId() == null) {
			// add new
			log.info("Save new BlueAir Flight");
			blueAirFlight.setId(model.getId());
		}
		// update
		blueAirFlight.setFlightDate(model.getFlightDate());
		blueAirFlight.setPrice(model.getPrice());
		blueAirFlight.setEstimatedTime(model.getEstimatedTime());
		blueAirFlight.setPassengers(model.getPassengers());
		blueAirFlight.setDepartureDate(model.getDepartureDate());
		blueAirFlight.setArrivalDate(model.getArrivalDate());
		
		if(model.getDepartureAirportId() != null) {
			Optional<Airport> optional = airportRepository.findById(model.getDepartureAirportId());
			if(optional.isPresent()) {
				blueAirFlight.setDepartureAirport(optional.get());
			} else {
				log.error("No departure airport found with ID: " + model.getDepartureAirportId());
			}	
		} else {
			log.error("Departure airport ID is NULL!");
		}
		
		if(model.getArrivalAirportId() != null) {
			Optional<Airport> optional = airportRepository.findById(model.getArrivalAirportId());
			if(optional.isPresent()) {
				blueAirFlight.setArrivalAirport(optional.get());
			} else {
				log.error("No arrival airport found with ID: " + model.getArrivalAirportId());
			}	
		} else {
			log.error("Arrival airport ID is NULL!");
		}
		
		BlueAirFlight saved = blueAirRepository.save(blueAirFlight);
		log.info("Saved BlueAir flight with id: " + saved.getId());
	}
	
	private BlueAirFlightModel entityToBlueAirModel(BlueAirFlight entity) {
		
		if(entity == null) {
			throw new BlueAirFlightEntityNotFound("Not Found entity to convert.");
		}
		
		BlueAirFlightModel model = new BlueAirFlightModel();
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
	
	private List<FlightModel> toBlueAirModelList(List<BlueAirFlight> entityList) {
		List<FlightModel> modelList = new ArrayList<>();
		entityList.forEach(entity -> {
			modelList.add(entityToBlueAirModel(entity));
		});
		return modelList;
	}
}
