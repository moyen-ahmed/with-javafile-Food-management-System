
package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeD extends JFrame {

	private Container c;
	private JButton create, login;
	private Font f;
	private JLabel board, l;
	private ImageIcon la;
	private JButton deatials, back;

	public HomeD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Khaben Naki?");
		setResizable(false);
		setFont(new Font("Serif", Font.HANGING_BASELINE, 40));
		initComponent();
	}

	public void initComponent() {

		c = this.getContentPane();
		c.setLayout(null);
		// c.setBackground(new Color(61, 200, 255));

		la = new ImageIcon(getClass().getResource("kaben.png"));
		board = new JLabel(la);
		board.setBounds(1, 1, 1200, 760);
		// board.setFont(new Font("Serif", Font.BOLD, 200));

		c.add(board);

		create = new JButton("Create New Account");

		create.setBounds(170, 500, 350, 80);
		create.setForeground(Color.BLACK);
		create.setBackground(Color.getHSBColor(205, 255, 105));
		create.setFont(f);
		create.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(create);

		login = new JButton("Already have an Account");
		login.setBounds(750, 500, 350, 80);
		login.setForeground(Color.BLACK);
		login.setBackground(Color.getHSBColor(205, 255, 105));
		login.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(login);

		deatials = new JButton("Abouts");
		deatials.setBounds(450, 650, 350, 80);
		deatials.setForeground(Color.BLACK);
		deatials.setBackground(Color.getHSBColor(205, 255, 105));
		deatials.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(deatials);

		back = new JButton("back");
		back.setBounds(950, 650, 150, 55);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(new Font("Arial", Font.BOLD, 25));

		c.add(back);

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createD ob = new createD();
				dispose();
				ob.create1();
			}
		});
		deatials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeveloperD ob = new DeveloperD();
				dispose();
				ob.Developer1();
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginoptionD ob = new loginoptionD();
				dispose();
				ob.loginoption1();
			}
		});
		deatials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpageD ob = new firstpageD();
				ob.firstpage1();
			}
		});

	}

	public static void start() {
		HomeD frame = new HomeD();
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		start();
	}
}
