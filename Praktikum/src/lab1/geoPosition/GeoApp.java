package lab1.geoPosition;

public class GeoApp {
	public static void main(String[] args) {			//Main Funktion
		
		double distanceExactly;							//Variablen für die Berechnung definieren
		double distanceLocally;
		double currentDeviation;
		
		GeoPosition haw = new GeoPosition(53.557078, 10.023109);			//Daten zuweisen
		GeoPosition eiffeltower = new GeoPosition(48.858363, 2.294481);
		GeoPosition palmaDeMallorca = new GeoPosition(39.562553, 2.661947);
		GeoPosition lasVegas = new GeoPosition(36.156214, -115.148736);
		GeoPosition copacabana = new GeoPosition(-22.971177, -43.182543);
		GeoPosition waikikiBeach = new GeoPosition(21.281004, -157.837456);
		GeoPosition surfersParadise = new GeoPosition(-28.002695, 153.431781);
		
		GeoPosition northPole = new GeoPosition(90, 0);
		GeoPosition southPole = new GeoPosition(-90, 0);
		GeoPosition equator  = new GeoPosition(0, 0);
		
			//Tabelle darstellen
		System.out.println("Ort           Breitengrad    Längengrad      Entfernung km          Entfernung km            Abweichung %");
		System.out.println("                                                (genau)                (lokal)     ");
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, haw);			//Klassenaufruf zur Berechnung auf 2 Arten
		distanceExactly = GeoPosition.distanceInKm(haw, haw);
		currentDeviation = deviation(distanceExactly, distanceLocally);		//Funktionsaufruf zur Berechnung der Abweichung
		System.out.println("HAW Hamburg     53.557078      10.023109          " + distanceExactly + "              " + distanceLocally + "           " + currentDeviation);
	
		distanceLocally = GeoPosition.localDistanceInKm(haw, eiffeltower);
		distanceExactly = GeoPosition.distanceInKm(haw, eiffeltower);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Eiffelturm      48.858363        2.294481     " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, palmaDeMallorca);
		distanceExactly = GeoPosition.distanceInKm(haw, palmaDeMallorca);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Palma de Mallorca   39.562553    2.661947    " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, lasVegas);
		distanceExactly = GeoPosition.distanceInKm(haw ,lasVegas);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Las Vegas       36.156214     -115.148736    " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, copacabana);
		distanceExactly = GeoPosition.distanceInKm(haw, copacabana);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Copacapana      -22.971177     -43.182543     " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, waikikiBeach);
		distanceExactly = GeoPosition.distanceInKm(haw, waikikiBeach);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Waikiki Beach    21.281004     -157.837456    " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
	
		distanceLocally = GeoPosition.localDistanceInKm(haw, surfersParadise);
		distanceExactly = GeoPosition.distanceInKm(haw, surfersParadise);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Surfers Paradise -28.002695    153.431781      " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		System.out.println("--------------------------------------------------------------------------------------------------------");
			//Berechnung der Pole und des Äquators auf die selbe Weise
		distanceLocally = GeoPosition.localDistanceInKm(haw, northPole);
		distanceExactly = GeoPosition.distanceInKm(haw, northPole);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Nordpol                90            0        " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
		
		distanceLocally = GeoPosition.localDistanceInKm(haw, equator);
		distanceExactly = GeoPosition.distanceInKm(haw, equator);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Äquator                 0            0        " + distanceExactly + "     " + distanceLocally + "     " + currentDeviation);
	
		distanceLocally = GeoPosition.localDistanceInKm(haw, southPole);
		distanceExactly = GeoPosition.distanceInKm(haw, southPole);
		currentDeviation = deviation(distanceExactly, distanceLocally);
		System.out.println("Südpol                -90            0        " + distanceExactly + "      " + distanceLocally + "    " + currentDeviation);
	}
	
	public static double deviation(double distanceExactly, double distanceLocally) {		//Funktion zur berechnung der Prozentualen Abweichung
		
		double deviation =(Math.abs(distanceExactly - distanceLocally) / distanceExactly) * 100;

		return deviation;																//Gebe die Abweichung zurück
	}
}
