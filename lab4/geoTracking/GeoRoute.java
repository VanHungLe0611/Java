package lab4.geoTracking;

import java.util.ArrayList;

public class GeoRoute implements Distance, Comparable<GeoRoute> {
	private String name;
	private ArrayList <GeoPosition> waypoints;
	
	public GeoRoute(String name) {
		this.name = name;
		waypoints = new ArrayList <GeoPosition>(); 
	}

	public GeoRoute(String name, ArrayList<GeoPosition> waypoints) {
		this.name = name;
		this.waypoints = new ArrayList <GeoPosition> (waypoints);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addWaypoint(GeoPosition waypoint){
		waypoints.add(waypoint);
	}
	
	public void removeWaypoint(int index){
		if(waypoints.isEmpty())
			System.out.println("Die Liste ist bereits leer!");
		else if(index < 0 || index > getNumberWaypoints() - 1)
			System.out.println("Index nicht in der Liste enthalten!");
		else
			waypoints.remove(index);
	}
	
	public int getNumberWaypoints(){
		return waypoints.size();
	}
	
	public GeoPosition getWaypoint(int index){
		return waypoints.get(index);
	}
	
	public GeoPosition[] getWaypoints(){
		GeoPosition[] arrayWaypoints = new GeoPosition[getNumberWaypoints()];
		waypoints.toArray(arrayWaypoints);
		return arrayWaypoints;
	}

	public double getDistance() {
		double distanceAll = 0.0;
		int numberWaypoints = getNumberWaypoints();
		for(int i = 0; i < numberWaypoints - 1; i++){
			distanceAll += waypoints.get(i).distanceInKm(getWaypoint(i + 1));
		}
		return distanceAll;
	}

	public String toString() {
		String description = String.format("%s (%.1f km)", name, getDistance());
		return  description;
	}
	
	public int compareTo(GeoRoute other) {
		return (int) (getDistance() - other.getDistance());
	}
	
	public int passedTrackpoints(ArrayList<GeoPosition> Trackpoints){
		int numPassed = 0;
		
		for (GeoPosition point : waypoints){
			if(numPassed < Trackpoints.size()){
				if(point.distanceInKm(Trackpoints.get(numPassed)) < 0.025){
					numPassed++;
				}
			}
		}
		
		return numPassed;
	}
}
