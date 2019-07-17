package impedance;

@SuppressWarnings("serial")
public class NegativeNumberException extends RuntimeException {

	public NegativeNumberException(String messager) {
		super(messager);
	}

	public NegativeNumberException(double number) {
		super(number + "");

	}
}
