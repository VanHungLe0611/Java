package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Keypad1 implements ActionListener {

	JButton[] button = new JButton[10];
	String string = new String();
	JTextField textField = new JTextField();
	JButton clearButton = new JButton("Clear");
	JButton letterButton = new JButton("#");
	JButton nullButton = new JButton("0");

	public Keypad1() {

		JFrame frame = new JFrame("Keypad");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 3));

		for (int i = 1; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setActionCommand(i + "");
			button[i].setText(button[i].getActionCommand());
			button[i].addActionListener(this);
			buttonPanel.add(button[i]);
		}

		clearButton.addActionListener(this);
		letterButton.addActionListener(this);
		nullButton.addActionListener(this);

		buttonPanel.add(clearButton);
		buttonPanel.add(nullButton);
		buttonPanel.add(letterButton);

		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(buttonPanel, BorderLayout.CENTER);
		container.add(textField, BorderLayout.SOUTH);
		frame.setSize(300, 400);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Keypad1();
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < button.length; i++) {
			if (e.getSource() == button[i]) {
				string += e.getActionCommand();
				textField.setText(string);
			}

		}
		if (e.getSource() == clearButton) {
			if (string.length() > 0) {
				string = string.substring(0, string.length() - 1);
				textField.setText(string);
			}

		}
		if (e.getSource() == letterButton) {
			string += "#";
			textField.setText(string);
		}
		if (e.getSource() == nullButton) {
			string += "0";
			textField.setText(string);

		}

	}

}
