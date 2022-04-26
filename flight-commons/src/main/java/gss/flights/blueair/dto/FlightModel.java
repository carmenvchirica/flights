package gss.flights.blueair.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(BigDecimal estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Long getPassengers() {
		return passengers;
	}

	public void setPassengers(Long passengers) {
		this.passengers = passengers;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Long getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(Long departureAirportId) {
		this.departureAirportId = departureAirportId;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDepartureAirportCountry() {
		return departureAirportCountry;
	}

	public void setDepartureAirportCountry(String departureAirportCountry) {
		this.departureAirportCountry = departureAirportCountry;
	}

	public String getDepartureAirportCity() {
		return departureAirportCity;
	}

	public void setDepartureAirportCity(String departureAirportCity) {
		this.departureAirportCity = departureAirportCity;
	}

	public Long getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(Long arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getArrivalAirportCountry() {
		return arrivalAirportCountry;
	}

	public void setArrivalAirportCountry(String arrivalAirportCountry) {
		this.arrivalAirportCountry = arrivalAirportCountry;
	}

	public String getArrivalAirportCity() {
		return arrivalAirportCity;
	}

	public void setArrivalAirportCity(String arrivalAirportCity) {
		this.arrivalAirportCity = arrivalAirportCity;
	}

}
