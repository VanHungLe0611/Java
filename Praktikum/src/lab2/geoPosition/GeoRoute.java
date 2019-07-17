package lab2.geoPosition;

import java.util.ArrayList;

import lab1.geoPosition.GeoPosition;

public class GeoRoute implements Distance, Comparable<GeoRoute>{
	private String name;
	private ArrayList<GeoPosition> waypoints = new ArrayList<GeoPosition>();
	
	public GeoRoute(String name, ArrayList<GeoPosition> waypoints) {
		super();
		this.name = name;
		this.waypoints = waypoints;
	}

	public GeoRoute(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addWaypoint(GeoPosition waypoint)
	{
		
	}
	
	public void removeWaypoint(int index)
	{
		
	}
	
	public int getNumberWaypoints() {
		return 0;
	}
	
	public GeoPosition getWaypoint(int index)
	{
		return null;
	}
	
	public GeoPosition[] getWaypoints() {
		return null;
	}
	
	public double getDistance() {
		return 0;
		
	}
	public int compareTo(GeoRoute other)
	{
		if(this.getClass().equals(other.getClass()))
		{
			return 1;
		}
		return 0;
		
	}
	
	public String toString() {
		return null;
	}
	
}
