package impedance;

public class Capacitor extends Impedance {

	private double valueInFarad;

	public Capacitor(double valueInFarad) throws NegativeNumberException {
		super();
		
		if (valueInFarad < 0) {
			throw new NegativeNumberException("Fehler");
		} else
			this.valueInFarad = valueInFarad;
	}

	public double getValueInFarad() {
		return valueInFarad;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) throws NegativeNumberException {
		if (omega < 0) {
			throw new NegativeNumberException("Fehler");

		} else
			return new Complex(0, -1 / (omega * this.valueInFarad));
	}

}
