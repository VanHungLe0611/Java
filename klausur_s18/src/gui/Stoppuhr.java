package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stoppuhr {
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stopp");
	JLabel timeLabel = new JLabel("       0 s");
	CountThread countThread = new CountThread();
	int count = 0;
	boolean stopThread = true;

	public Stoppuhr() {
		JFrame frame = new JFrame("Stoppuhr");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		buttonPanel.add(start);
		buttonPanel.add(stop);
		start.setEnabled(true);
		stop.setEnabled(false);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(false);
				stop.setEnabled(true);
				countThread.start();

			}
		});

		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopThread = false;
				stop.setEnabled(false);

			}
		});

		JPanel timePanel = new JPanel();
		timePanel.setLayout(new BorderLayout());
		timePanel.add(timeLabel, BorderLayout.CENTER);

		Container container = frame.getContentPane();
		container.setLayout(new GridLayout(1, 2));
		container.add(timePanel);
		container.add(buttonPanel);

		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	public class CountThread extends Thread {
		public void run() {
			while (stopThread) {
				try {
					Thread.sleep(1000);
					count = count + 1;
					timeLabel.setText("       " + count + "s");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		new Stoppuhr();
	}

}
