package impedance;

public class Inductor extends Impedance {

	private double valueInHenry;

	public Inductor(double valueInHenry) throws NegativeNumberException{
		super();
		if (valueInHenry < 0) {
			throw new NegativeNumberException("Fehler");
			
		}else this.valueInHenry = valueInHenry;
	}

	public double getValueInHenry() {
		return valueInHenry;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) throws NegativeNumberException{
		if (omega < 0) {
			throw new NegativeNumberException("Fehler");
			
		}
		else return new Complex(0, omega*this.valueInHenry);
	}

}
