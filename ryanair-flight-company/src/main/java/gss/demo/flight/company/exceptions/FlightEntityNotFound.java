package gss.demo.flight.company.exceptions;

public class FlightEntityNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlightEntityNotFound(String message) {
		super(message);
	}
	
}
