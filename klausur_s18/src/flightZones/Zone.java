package flightZones;

public class Zone extends Location implements Comparable<Zone> {

	private String name;

	public Zone(String name, double latitude, double longitude) {
		super(latitude, longitude);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Zone o) {
		// TODO Auto-generated method stub
		if (this.name.compareTo(o.name) < 0) {
			return -1;
		} else if (this.name.compareTo(o.name) > 0) {
			return 1;
		} else return 0;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
