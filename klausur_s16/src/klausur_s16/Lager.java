package klausur_s16;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Lager {
	int pallette = 0;
	public Lager() {
		JFrame frame = new JFrame("Lager");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        JProgressBar progressBar = new JProgressBar(0, 10);
        progressBar.setString(pallette + " von 10 Plätzen belegt" );
       
      
        JButton hinzufügenButton = new JButton("Palette hinzufügen");
        JButton entfernButton = new JButton("Pallette entfernen");
        hinzufügenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			    if(pallette < progressBar.getMaximum()) {
			    pallette += 1;
				progressBar.setForeground(Color.GREEN);
				progressBar.setValue(pallette);
				progressBar.setString(pallette + " von 10 Plätzen belegt" );
			    }else {
			    	progressBar.setForeground(Color.RED);
			    	JOptionPane.showMessageDialog(progressBar, "Das Lager ist voll", "Palette hinzufügen", JOptionPane.INFORMATION_MESSAGE);
			    }
			}
		});
        
        entfernButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pallette > progressBar.getMinimum()) {
				pallette -= 1;
				progressBar.setForeground(Color.GREEN);
				progressBar.setValue(pallette);
			   progressBar.setString(pallette + " von 10 Plätzen belegt" );
				}else {
					JOptionPane.showMessageDialog(progressBar, "Keine Pallette zum Entfernen", "Pallette entfernen", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
        progressBar.setStringPainted(true);
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 1));
        container.add(progressBar);
        container.add(hinzufügenButton);
        container.add(entfernButton);
        frame.setVisible(true);

	}
	public static void main(String[] args) {
		new Lager();
	}
	

}
