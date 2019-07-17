package warehouse;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Lager implements ActionListener {
	JButton hinzuButton = new JButton("Pallette hinzufügen");
	JButton entfernButton = new JButton("Palette entfernen");
	JProgressBar progressBar = new JProgressBar();
	int count = 0;

	public Lager() {
		JFrame frame = new JFrame("Lager");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		progressBar.setStringPainted(true);
		progressBar.setString("0 von 10 Plätzen belegt");
		hinzuButton.addActionListener(this);
		entfernButton.addActionListener(this);

		Container container = frame.getContentPane();
		container.setLayout(new GridLayout(3, 1));
		container.add(progressBar);
		container.add(hinzuButton);
		container.add(entfernButton);

		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hinzuButton) {
			count++;
			if (count < 10) {
				progressBar.setString(count + " von 10 Plätzen belegt");
				progressBar.setBackground(Color.GREEN);
			} else {
				progressBar.setBackground(Color.RED);
				progressBar.setString(count + " von 10 Plätzen belegt");
				JOptionPane.showMessageDialog(hinzuButton, "Das Lager ist voll", "Palette hinzufügen",
						JOptionPane.WARNING_MESSAGE);

			}
		}
		if (e.getSource() == entfernButton) {
			if (count > 0) {
				count--;
				progressBar.setBackground(Color.GREEN);
				progressBar.setString(count + " von 10 Plätzen belegt");
			}
			else {
				progressBar.setBackground(new Color(238, 238, 238));
				JOptionPane.showMessageDialog(hinzuButton, "Keine Pallete zum Entfernen vorhanden", "Palette entfernen",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}

	}

	public static void main(String[] args) {
		new Lager();
	}

}
