package lab2.geoPosition;

public class GeoTrack extends GeoRoute{
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public GeoTrack(String name, String date)
	{
		super(name);
		this.date = date;
	}
	

}
