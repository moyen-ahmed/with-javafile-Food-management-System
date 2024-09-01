package image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import projectkajjjj.HomeD;

public class firstpage {
	JButton desktop, mobile;
	static Timer timer;
	static int i = 0;

	public static void main(String[] args) {

		JFrame frame = new JFrame("progress bar");
		frame.setBounds(100, 100, 394, 269);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton desktop = new JButton("desktop");
		desktop.setBounds(10, 77, 150, 25);
		frame.add(desktop);
		JButton mobile = new JButton("Mobile");
		mobile.setBounds(170, 77, 150, 25);
		frame.add(mobile);

		JProgressBar progress = new JProgressBar();
		progress.setBounds(106, 37, 175, 29);
		progress.setStringPainted(true);
		frame.add(progress);

		desktop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				ob.start();
				timer.start();
				i = 2;

			}
		});

		mobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				home ob = new home();
//				ob.start();
				timer.start();
				i = 1;
				// JOptionPane.showMessageDialog(null,"ki re");

			}
		});

		timer = new Timer(5, new ActionListener() {

			private int x = 0;

			public void actionPerformed(ActionEvent argo) {

				progress.setValue(x++);

				if (x == 101) {
					timer.stop();
					if (i == 1)
						JOptionPane.showMessageDialog(null, "mobile");
					else if (i == 2)
						JOptionPane.showMessageDialog(null, "desktop");
					x = 0;
				}

			}

		});
	}

}
