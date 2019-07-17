package lab1.geoPosition;

public class GeoPosition {
	private double latitude;									//Variblen als private deklarieren
	private double longitude;

	public GeoPosition(double latitude, double longitude) {		//Konstruktor 
		this.latitude = latitude;
		this.longitude = longitude;	
	}
	
	public double getLatitude() {								//Wiedergabe der Latitude
		return latitude;
	}
	
	public double getLongitude() {								//Wiedergabe der Longitude
		
		return longitude;
	}
	
	public boolean isNorthernHemisphere() {						//Pr�fen ob der Punkt n�rdlich ist
																//Gebe Wahrheitswert boolean zur�ck
		return (latitude > 0.0);
	}
	
	public boolean isSouthernHemisphere() {						//Pr�fen ob der Punkt s�dlich ist
																//Gebe boolean zur�ck
		boolean southern;
		
		if (latitude < 0) {
			southern = true;
		} else {
			southern = false;
		}
		return southern;
	}
	
	public static double localDistanceInKm(GeoPosition a, GeoPosition b) { 			//Distanz zwischen 2 Punkten
		double dy = 111.3 * Math.abs(a.latitude - b.latitude);			//Berechnung f�r Y Koordinaten		
		double dx = 111.3 * Math.cos(((a.latitude + b.latitude)/2) * (Math.PI/180)) * Math.abs(a.longitude - b.longitude);
		
		return Math.sqrt(dy * dy + dx * dx);  //Gebe mit Pythagoras die Distanz zur�ck
//		return Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));  //Gebe mit Pythagoras die Distanz zur�ck
	}
	
	public static double distanceInKm(GeoPosition a, GeoPosition b) { 				//Distanz zwischen 2 Punkten
																					//Anwendung der genauen Formel
		return 6378.388 * Math.acos(Math.sin(a.latitude * Math.PI/180) * Math.sin(b.latitude * Math.PI/180)
				+ Math.cos(a.latitude * Math.PI/180) * Math.cos(b.latitude * Math.PI/180) * Math.cos((b.longitude - a.longitude) * Math.PI/180));
	}
	
	public double distanceInKm(GeoPosition other) {									//Distanz bis zu einem Punkt
		return 6378.388 * Math.acos(Math.sin(other.latitude * Math.PI/180) * Math.sin(latitude * Math.PI/180) + Math.cos(other.latitude * Math.PI/180) * Math.cos(latitude * Math.PI/180) * Math.cos((longitude - other.longitude) * Math.PI/180));
	}
	
	public String toString() {      												//Liefert als String formatierte Ausgabe zur�ck
		
		String str = ("(" + latitude + ", " + longitude + ")");
		
		return str;
	}
}

