package vacant;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vacant {
	int freeSeat = 40;
	JButton[][] buttons = new JButton[10][4];
	JFrame frame;
	public Vacant() {
        ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int k = 0; k < buttons.length; k++) {
					for (int l = 0; l < buttons[k].length; l++) {
						if(e.getSource() == buttons[k][l]) {
							if(buttons[k][l].getBackground() == Color.GREEN) {
								buttons[k][l].setBackground(Color.RED);
								freeSeat--;
								frame.setTitle("Vacant : " + freeSeat);
							}
							else {
								buttons[k][l].setBackground(Color.GREEN);
								freeSeat++;
								frame.setTitle("Vacant : " + freeSeat);
							}		
						}
					}	
				}	
			}
		};
		
		frame = new JFrame("Vacant : " + freeSeat);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10,4));
        char letter;
        int count;
            
        for (int i = 0; i < 10; i++) {
        	letter = 'A';
        	for (int j = 0; j < 4 ; j++) {
        		buttons[i][j] = new JButton();
        		count = i + 1;
        		String string = "" + count + letter + "";
        		letter++;
        		buttons[i][j].setActionCommand(string);
        		buttons[i][j].setText(buttons[i][j].getActionCommand());
        		buttons[i][j].setBackground(Color.GREEN);
        	    buttons[i][j].addActionListener(listener);
        		buttonPanel.add(buttons[i][j]);		
			}	
		} 
        
        Container container = frame.getContentPane();
        container.add(buttonPanel);
        frame.setSize(300, 600);
        frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Vacant();
	}
}
