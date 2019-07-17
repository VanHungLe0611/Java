package flightZones;

import java.util.ArrayList;
import java.util.Collections;

public class ZoneMap {

	private ArrayList<Zone> zones = new ArrayList<Zone>();

	public void addZone(Zone zone) {
		this.zones.add(zone);
		Collections.sort(zones);
	}

	public boolean containsZone(Zone zone) {
		for (Zone zone1 : zones) {
			if (zone1.getName().equals(zone.getName())) {
				return true;
			}
		}
		return false;
	}

	public Zone nearestZone(Quadcopter copter) {
		double min = Location.distanceMeter(zones.get(0), copter);
		Zone nearestLocation = null;
		for (int i = 0; i < zones.size(); i++) {
			if (Location.distanceMeter(zones.get(i), copter) <= min) {
				min = Location.distanceMeter(zones.get(i), copter);
				nearestLocation = zones.get(i);
			}
		}
		return nearestLocation;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < zones.size(); i++) {
			string += "- " + zones.get(i).getName() + "\n";
		}

		return String.format("Map (%d flight zones):\n%s", zones.size(), string);
	}

}
