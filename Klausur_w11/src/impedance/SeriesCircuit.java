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
	     Impedance[] arrays = new Impedance[impedances.size()];
	     for (int i = 0; i < impedances.size(); i++) {
		      arrays[i] = impedances.get(i);
		}
	     return arrays;
	}

	@Override
	public Complex getImpedanceAtOmega(double omega) throws NegativeNumberException{
		
		Complex summe = new Complex();
		if (omega < 0) {
			throw new NegativeNumberException("Fehler");
			
		}else {
		for (int i = 0; i < impedances.size(); i++) {
			summe.add(impedances.get(i).getImpedanceAtOmega(omega));
		}
		return summe;}
	}

}
