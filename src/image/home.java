package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class home extends JFrame {

	private Container c;
	private JButton create, login;
	private Font f;

	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("Nsu Panda");
		setResizable(true);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);

		create = new JButton("Create New Account");
		create.setBounds(20, 300, 150, 25);
		c.add(create);

		login = new JButton("Already have an Account");
		login.setBounds(180, 300, 200, 25);
		c.add(login);

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create ob = new create();
				dispose();
				ob.create1();
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginoption ob = new loginoption();
				dispose();
				ob.loginoption1();
			}
		});

	}

	public static void start() {
		home frame = new home();
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		start();
	}
}
