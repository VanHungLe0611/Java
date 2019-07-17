package impedance;

public class Resistor extends Impedance implements Comparable<Resistor> {

	private double valueOhm;

	public Resistor(double valueOhm) throws NegativeNumberException {
		super();
		if (valueOhm < 0) {
			throw new NegativeNumberException("Fehler");
		} else
			this.valueOhm = valueOhm;
	}

	public double getValueInOhm() {
		return valueOhm;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) throws NegativeNumberException {
		if (omega < 0) {
			throw new NegativeNumberException("Fehler");

		} else
			return new Complex(this.valueOhm, 0);
	}

	@Override
	public int compareTo(Resistor o) {
		if (this.valueOhm - o.getValueInOhm() < 0) {
			return -1;
		} else if (this.valueOhm - o.getValueInOhm() > 0) {
			return 1;
		} else
			return 0;
	}

}
