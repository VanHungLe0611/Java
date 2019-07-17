package formula1;

import java.util.ArrayList;

public class RacingTeam {
	private String name;
	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	public RacingTeam(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Driver[] getDrivers() {
		return drivers.toArray(new Driver[drivers.size()]);
	}

	public void addDriver(Driver driver) {
		if (!drivers.contains(driver)) {
			drivers.add(driver);
		}
	}

}
