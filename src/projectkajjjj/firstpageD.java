package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import image.home;

public class firstpageD extends HomeD {
	JButton desktop, mobile;
	JLabel p1, pi;
	private ImageIcon cr;
	private Container c;
	static Timer timer;
	static int i = 0;

	void createD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Create option (create)");
		setResizable(false);

		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		cr = new ImageIcon(getClass().getResource("k.png"));
		pi = new JLabel(cr);
		pi.setBounds(1, 1, 1200, 750);
		c.add(pi);

		JButton desktop = new JButton("Desktop");
		desktop.setBounds(300, 300, 200, 35);
		desktop.setForeground(Color.BLACK);
		desktop.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(desktop);

		JButton mobile = new JButton("Mobile");
		mobile.setBounds(590, 300, 200, 35);
		mobile.setForeground(Color.BLACK);
		mobile.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(mobile);

		JProgressBar progress = new JProgressBar();
		progress.setBounds(440, 230, 250, 35);
		progress.setStringPainted(true);
		// progress.setForeground(Color.BLACK);
		// progress.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(progress);

		desktop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				i = 2;

			}
		});

		mobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home obb = new home();
				obb.start();
				timer.start();
				i = 1;

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
					else if (i == 2) {

						HomeD ob = new HomeD();

						ob.start();

					}

					x = 0;
				}

			}

		});

	}

	public static void main(String[] args) {
		firstpage1();
	}

	public static void firstpage1() {
		firstpageD frame = new firstpageD();
		frame.setVisible(true);
	}
}
