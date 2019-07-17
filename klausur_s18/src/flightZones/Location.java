package flightZones;

public class Location implements Locatable {

	private double latitude;
	private double longitude;

	public Location(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return this.latitude;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return this.longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public static double distanceMeter(Locatable a, Locatable b) {
		double deltaX, deltaY;
		deltaX = 111.3 * Math.cos((a.getLatitude() + b.getLatitude()) / 2 * (Math.PI / 180.0))
				* Math.abs(a.getLongitude() - b.getLongitude());
		deltaY = 111.3 * Math.abs(a.getLatitude() - b.getLatitude());
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY) * 1000.0;
	}

}
