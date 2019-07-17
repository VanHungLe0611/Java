package warehouse;

public class Pallet {

	private int trackingID;
	private String destination;
	
	public Pallet(int trackingID, String destination) {
		super();
		this.trackingID = trackingID;
		this.destination = destination;
	}
	
	public int getTrackingID() {
		return trackingID;
	}

	public String getDestination() {
		return destination;
	}
	
	@Override
	public String toString() {
		return String.format("#%d to %s", trackingID, destination);
	}
	
	
	
	

}
