
public class Computer {
	
	// Eigenschaften und Atributte
	String cpu;
	Mainboard mainboard; // mainboard ist komplexe Variable
	// kein Wert und keine Adresse
	int preis;
	
	// Konstruktor 
	public Computer(String cpu, Mainboard mainboard, int preis) {
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.preis = preis;
	}
	// Standard Konstruktor
	public Computer() {
		
	}
	
	
	// Methoden

}
