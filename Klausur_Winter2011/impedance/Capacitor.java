package impedance;

public class Capacitor extends Impedance {

	private double valueInFarad;

	public Capacitor(double valueInFarad) {
		super();
		if (valueInFarad < 0) {
			throw new NegativeNumberException(valueInFarad);

		} else
			this.valueInFarad = valueInFarad;
	}

	public double getValueInFarad() {
		return valueInFarad;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) {
		if (omega < 0) {
			throw new NegativeNumberException(omega);

		} else
			return new Complex(0, -1 / (omega * valueInFarad));
	}

}
