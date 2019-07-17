package geoTracking;

public class GeoPosition {
	private double longitude;
	private double latitude;

	public GeoPosition(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
	
	//Check if northern or southern hemisphere
	public boolean isNorthernHemisphere(){
		if(latitude > 0.0)
			return true;
		else
			return false;
	}
	
	public boolean isSouthernHemisphere(){
		if(latitude < 0)
			return true;
		else
			return false;
	}
	
	//Calculation of distances
	public static double localDistanceInKm(GeoPosition a, GeoPosition b){
		double deltaY = 111.3 * Math.abs(a.latitude - b.latitude);
		double deltaX = 111.3*Math.cos(Math.toRadians((a.latitude + b.latitude)/2))*Math.abs(a.longitude - b.longitude);		

		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}

	public static double distanceInKm(GeoPosition a, GeoPosition b){
		return 6378.388*Math.acos(Math.sin(Math.toRadians(a.latitude)) * Math.sin(Math.toRadians(b.latitude)) 
				+ Math.cos(Math.toRadians(a.latitude)) * Math.cos(Math.toRadians(b.latitude)) * Math.cos(Math.toRadians(b.longitude - a.longitude)));
	}
	
	public double distanceInKm(GeoPosition other){
		return distanceInKm(this, other);
	}

	//Output as string
	@Override
	public String toString() {
		String description = String.format( "(%6.3f , %6.3f)", latitude, longitude);
		return description;
	}
}
