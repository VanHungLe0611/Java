package lab4.geoTracking;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GeoMap extends JPanel {
	private GeoRoute routeMap = new GeoRoute("Wegstrecke");
	private ArrayList<Integer> listRouteX = new ArrayList<Integer>();
	private ArrayList<Integer> listRouteY = new ArrayList<Integer>();
	private ArrayList<GeoPosition> trackpoints = new ArrayList<GeoPosition>();
	private ArrayList<Integer> listCoordsX = new ArrayList<Integer>();
	private ArrayList<Integer> listCoordsY = new ArrayList<Integer>();
	private BufferedImage map;
	
	public GeoMap() {
		newMap();
	}

	//read image
	void newMap(){
		File image = new File("lab4/geoTracking/OSM_BerlinerTor.png");
		try{
			map = ImageIO.read(image);
		}
		catch(IOException e){
			System.out.println("Das Bild konnte nicht geladen werden.");
		}
		File route = new File("lab4/geoTracking/RouteGeo.txt");
		try {
			FileReader reader = new FileReader(route);
			BufferedReader buffReader = new BufferedReader(reader);
			try {
				while(buffReader.ready()){
					String a = buffReader.readLine();
					String[] b = a.split(",");
					double lat = Double.parseDouble(b[0]);
					double lon = Double.parseDouble(b[1]);
					trackpoints.add(new GeoPosition(lat,lon));
					listRouteY.add((int) ((53.5631389 - lat) * map.getHeight()/(53.5631389 - 53.5566389)));
					listRouteX.add((int) ((lon - 10.008555555555555) * map.getWidth() / (10.025 - 10.008555555555555)));
				}
				try {
					buffReader.close();
				} catch (IOException e) {
					System.out.println("Problem mit der Textdatei!");
				}
			} catch (IOException e) {
				System.out.println("Problem mit der Textdatei!");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Die Textdatei mit der Route konnte nicht gefunden werden.");
		}
		repaint();
	}

	//get size of the picture for panel dimensions
	public Dimension getPreferredSize() {
		return new Dimension(map.getWidth(), map.getHeight());
	}
	
	//calculating actual GeoPosition
	public GeoPosition getPosition(int x, int y){
		double latitude = 53.5631389 - (double) y / map.getHeight() * (53.5631389 - 53.5566389);
		double longitude = 10.008555555555555 + (double) x / map.getWidth() * (10.025 - 10.008555555555555);
		
		return new GeoPosition(latitude, longitude);
	}
	
	//painting route to the panel/map
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		if(map != null){
			g.drawImage(map, 0, 0, this);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		
		int numberPassed = routeMap.passedTrackpoints(trackpoints);
		
		g2d.setColor(Color.GREEN);
		int numberTrackpoints = listRouteX.size();
		if (numberTrackpoints > 1) {
			for (int i = 0; i < numberPassed; i++){
				int mx = listRouteX.get(i);
				int my = listRouteY.get(i); 
				int r = 5;
				g2d.fillOval(mx-r, my-r, 2*r, 2*r);
			}
			for (int i = 1; i < numberPassed; i++) {
				g.drawLine(
						listRouteX.get(i - 1), 
						listRouteY.get(i - 1), 
						listRouteX.get(i), 
						listRouteY.get(i)
					);
			}
		}
		
		g2d.setColor(Color.RED);
		if(numberPassed > 0 && numberPassed < trackpoints.size())
			g.drawLine(listRouteX.get(numberPassed - 1), listRouteY.get(numberPassed - 1), 
				listRouteX.get(numberPassed), listRouteY.get(numberPassed));
		if (numberTrackpoints > numberPassed) {
			for (int i = numberPassed; i < numberTrackpoints; i++){
				int mx = listRouteX.get(i);
				int my = listRouteY.get(i); 
				int r = 5;
				g2d.fillOval(mx-r, my-r, 2*r, 2*r);
			}
			for (int i = numberPassed + 1; i < numberTrackpoints; i++) {
				g.drawLine(
						listRouteX.get(i - 1), 
						listRouteY.get(i - 1), 
						listRouteX.get(i), 
						listRouteY.get(i)
					);
			}
		}
		
		g2d.setColor(Color.BLUE);
		int numberPoints = listCoordsX.size();
		if (numberPoints > 1) {
			for (int i = 1; i < numberPoints; i++) {
				g.drawLine(
					listCoordsX.get(i - 1), 
					listCoordsY.get(i - 1), 
					listCoordsX.get(i), 
					listCoordsY.get(i)
				);
			}
		}
	}
	
	//add waypoints to the route
	public void addPoint(int x, int y) {
		listCoordsX.add(x);
		listCoordsY.add(y);
		routeMap.addWaypoint(getPosition(x, y));
		repaint();
	}
	
	//clear GeoRoute and the panel (reset function)
	public void clear() {
		listCoordsX.clear();
		listCoordsY.clear();
		
		for (int i = routeMap.getNumberWaypoints() - 1; i >= 0; i--){
			routeMap.removeWaypoint(i);
		}

		repaint();
	}
	
	//label to display the actual position on the map
	public JLabel labelPosition() {
		JLabel label = new JLabel ("Aktuelle Position:");
		return label;
	}
	
	//label to display the length of the route
	public String labelDistance() {
		return String.format("Streckenlänge: %.1f km", routeMap.getDistance());
	}

	public int checkRoute(JFrame frame, int shown) {
		if(routeMap.passedTrackpoints(trackpoints) == trackpoints.size() && shown == 0) {
			JOptionPane.showMessageDialog(frame, "Sie haben die Strecke erfolgreich absolviert!", 
					"Glückwunsch", JOptionPane.INFORMATION_MESSAGE);
			shown = 1;
		}
		return shown;
	}
}
