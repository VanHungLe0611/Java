package lab4.geoTracking;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GeoGUI extends MouseAdapter implements ActionListener{
	private static GeoMap panelMap;
	private static JPanel panelMenu;
	private JLabel labelDistance;
	private JLabel labelPosition;
	private JFrame pointFrame;
	private JButton buttonReset = new JButton("Route zurücksetzen");
	private GeoPosition topLeft = new GeoPosition(53.5631389, 10.008555555555555);
	private int shown = 0;
	
	public GeoGUI() {
		//create frame for GUI
		JFrame frame = new JFrame("Geografische Wegstrecken");
		pointFrame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		
		//create panel with map and MouseListener
		panelMap = new GeoMap();
		panelMap.addMouseListener(this);
		panelMap.addMouseMotionListener(this);
		labelDistance = new JLabel(panelMap.labelDistance());
		labelPosition = new JLabel(String.format("Aktuelle Position (lat,long): " + topLeft));
		
		// Event handling for button
		buttonReset.setActionCommand("Zurücksetzen der Strecke");
		buttonReset.addActionListener(this);
		
		//create panel with button and displays for distance and position
		panelMenu = new JPanel();
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));
		panelMenu.add(buttonReset);
		panelMenu.add(Box.createHorizontalGlue());
		panelMenu.add(labelDistance);
		panelMenu.add(Box.createHorizontalGlue());
		panelMenu.add(labelPosition);
		panelMenu.add(Box.createHorizontalGlue());
		
		//add panel and map to frame
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(panelMenu);
		frame.add(panelMap);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	//MouseListener for route-setting
	public void mouseDragged (MouseEvent event){
		System.out.printf("(x,y) = (%d, %d)\n", event.getX(), event.getY());
		panelMap.addPoint(event.getX(), event.getY());
		labelDistance.setText(panelMap.labelDistance());
		shown = panelMap.checkRoute(pointFrame, shown);
	}
	
	@Override
	//MouseListener for actual position on the map
	public void mouseMoved (MouseEvent event){
		labelPosition.setText(String.format("Aktuelle Position (lat , long): " + panelMap.getPosition(event.getX(), event.getY())));
	}
	
	
	@Override
	//ActionListener for route-resetting (button)
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());

		if (event.getSource() == buttonReset) {
			panelMap.clear();
			shown = 0;
			labelDistance.setText(panelMap.labelDistance());
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("a");
	}

}
