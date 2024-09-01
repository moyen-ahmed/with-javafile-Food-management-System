package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginownerD extends JFrame {

	private Container c;
	private JLabel user;
	private JLabel img;
	private JLabel pass;
	private JLabel board;
	private JTextField userf;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	private JLabel kyf;
	private JPasswordField passf;
	private Font f;
	private JButton login, clear, back;

	loginownerD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Log in owner");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 25);
		ic = new ImageIcon(getClass().getResource("iduser.png"));
		ps = new ImageIcon(getClass().getResource("pass.png"));
		ky = new ImageIcon(getClass().getResource("key.png"));
		log = new ImageIcon(getClass().getResource("log.png"));

		user = new JLabel(ic);
		user.setBounds(303, 290, 70, 50);
		c.add(user);
		board = new JLabel(log);
		board.setBounds(500, 150, 100, 100);
		c.add(board);

		pass = new JLabel(ps);
		pass.setBounds(300, 360, 80, 80);

		c.add(pass);

		kyf = new JLabel(ky);
		kyf.setBounds(700, 370, 50, 50);
		c.add(kyf);

		userf = new JTextField();
		userf.setBounds(430, 300, 250, 35);
		userf.setFont(f);
		c.add(userf);

		passf = new JPasswordField();
		passf.setBounds(430, 380, 250, 35);
		passf.setFont(f);
		c.add(passf);

		login = new JButton("Login");
		login.setBounds(590, 480, 250, 80);
		login.setForeground(Color.BLACK);
		login.setBackground(Color.getHSBColor(205, 255, 105));
		login.setFont(f);
		c.add(login);

		clear = new JButton("clear");
		clear.setBounds(450, 600, 250, 80);
		clear.setForeground(Color.BLACK);
		clear.setBackground(Color.getHSBColor(205, 255, 105));
		clear.setFont(f);
		c.add(clear);

		back = new JButton("back");
		back.setBounds(290, 480, 250, 80);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(f);
		c.add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeD ob = new HomeD();
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
				cheakD ob = new cheakD();

				boolean con = ob.cheakown(s); // cheak() return us false when userid found,so we change the bool ,from
												// false to true.
				if (con == true)
					con = false;
				else
					con = true;

				if (con) {
					File f = new File("owner.txt");
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
						JOptionPane.showMessageDialog(null, "Your user id: " + s + "\nyour password: " + p, "title",
								JOptionPane.ERROR_MESSAGE);

						profileownerD obb = new profileownerD();
						obb.initialize(s);
						dispose();
						obb.profileowner1();

						// profile of customer

						// ob.infocustom(userid);

					}

					else {
						System.out.println("wrong");
						loginowner1();
					}
				} else {
					{

						System.out.println("user id not found");
						loginowner1();
					}

				}

			}
		});

	}

	public static void main(String[] args) {
		loginowner1();
	}

	public static void loginowner1() {
		loginownerD frame = new loginownerD();
		frame.setVisible(true);
	}

}
