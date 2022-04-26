package gss.demo.flight.company.exceptions;

public class FlightModelNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FlightModelNotFound(String message) {
		super(message);
	}
	

}
