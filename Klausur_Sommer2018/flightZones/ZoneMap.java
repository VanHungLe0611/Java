package flightZones;

import java.util.ArrayList;
import java.util.Collections;

public class ZoneMap {
	private ArrayList<Zone> zones = new ArrayList<Zone>();

	public void addZone(Zone zone) {
		if (!zones.contains(zone)) {
			zones.add(zone);
		}
		Collections.sort(zones);
	}
	
	public boolean containsZone(Zone zone) {
		if (zones.contains(zone)) {
			return true;
		}
		else return false;
	}
	
	public Zone nearestZone(Quadcopter copter) {
		double min;
		Zone zone1 = null;
		min = Location.distanceMeter(copter, zones.get(0));
		for (Zone zone : zones) {
			if(min >= Location.distanceMeter(copter, zone)) {
				min = Location.distanceMeter(copter, zone);
				zone1 = zone;
			}
			
		}
		return zone1;
	}
	
	public String toString() {
		String string = "";
		for (Zone zone : zones) {
			string += "- " + zone.getName() + "\n";
			}
		return String.format("Map (%d flight zones):\n%s",zones.size(),string);	
		}
	
}
