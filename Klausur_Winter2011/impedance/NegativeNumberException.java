package impedance;

@SuppressWarnings("serial")
public class NegativeNumberException extends RuntimeException{
	
	public NegativeNumberException(double number) {
		super(number + "");
	}
	public NegativeNumberException(String message) {
		super(message);
	}
	

	

}
