package impedance;

import java.util.ArrayList;

public class SeriesCircuit extends Impedance {
	private ArrayList<Impedance> impedances = new ArrayList<Impedance>();

	public SeriesCircuit() {
		super();
	}

	public void addImpedance(Impedance impedance) {
		if (impedance != null) {
			impedances.add(impedance);

		}

	}

	public Impedance[] getImpedances() {
		return impedances.toArray(new Impedance[impedances.size()]);
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) {

		Complex im = new Complex();
		if (omega < 0) {
			throw new NegativeNumberException(omega);

		} else {
			for (Impedance impedance : impedances) {
				im.add(impedance.getImpedanceAtOmega(omega));
			}
		}
		return im;
	}

}
