package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class logincustomer extends JFrame {

	private Container c;
	private JLabel user;
	private JLabel pass;
	private JTextField userf;
	private JPasswordField passf;
	private Font f;
	private JButton login, clear, back;
	public static String n, add, ph;

	logincustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("Log in ");
		setResizable(false);
		try {
			initComponent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initComponent() throws Exception {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);

		f = new Font("Arial", Font.BOLD, 20);

		user = new JLabel("user id:");
		user.setBounds(20, 300, 150, 25);
		user.setFont(f);
		c.add(user);

		pass = new JLabel("Pssword:");
		pass.setBounds(20, 350, 150, 25);
		pass.setFont(f);
		c.add(pass);

		userf = new JTextField();
		userf.setBounds(150, 300, 150, 25);
		userf.setFont(f);
		c.add(userf);

		passf = new JPasswordField();
		passf.setBounds(150, 350, 150, 25);
		passf.setFont(f);
		c.add(passf);

		login = new JButton("login");
		login.setBounds(190, 400, 150, 25);
		login.setFont(f);
		c.add(login);

		clear = new JButton("clear");
		clear.setBounds(10, 400, 150, 25);
		clear.setFont(f);
		c.add(clear);

		back = new JButton("back");
		back.setBounds(100, 450, 150, 25);
		back.setFont(f);
		c.add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				home ob = new home();
				dispose();
				ob.start();
			}
		});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userf.setText("");
				passf.setText("");

			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = userf.getText();
				String p = passf.getText();
				cheak ob = new cheak();
				boolean con = ob.cheakcus(s); // cheak() return us false when userid found,so we change the bool ,from
												// false to true.
				if (con == true)
					con = false;
				else
					con = true;

				if (con) {
					File f = new File("customer.txt");
					int c = 0;

					try {
						FileReader fr = new FileReader(f);
						BufferedReader br = new BufferedReader(fr);
						StringBuffer sb = new StringBuffer();
						String line;
						while ((line = br.readLine()) != null) {
							if (line.equals(s + " " + p)) {
								c = 1;

								break;
							}
						}

					} catch (Exception ea) {
						System.out.println("cheak error");
					}
					if (c == 1) {

						JOptionPane.showMessageDialog(null, "Found your accound", "title",
								JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "Your user id: " + s + "\nyour password " + p, "title",
								JOptionPane.ERROR_MESSAGE);

						dispose();

					profilecustomer obb = new profilecustomer();
					   obb.initialize(s);
						
						//obb.initialize(s);
						obb.profilecustomer1();

//						// obb.initializeuserid(s);
//						cheak ob1 = new cheak();
//						int lineno = ob.cheakinfo(s);
//						obb.find(lineno);
//						obb.profilecustomer1();

					}

					else {
						JOptionPane.showMessageDialog(null, "you entered wrong password\nplease try again", "title",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						logincustomer1();
					}
				} else {
					{

						JOptionPane.showMessageDialog(null, "user id not found", "title",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						logincustomer1();
					}

				}

			}
		});

	}
	public static void main(String[] args) {
		logincustomer1();
	}

	public static void logincustomer1() {
		logincustomer frame = new logincustomer();
		frame.setVisible(true);
	}

}
