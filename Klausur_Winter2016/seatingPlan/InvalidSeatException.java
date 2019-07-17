package seatingPlan;

@SuppressWarnings("serial")
public class InvalidSeatException extends RuntimeException{
	
	public InvalidSeatException(String message) {
		super(message);
	}

}
