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

public class logincustomerD extends JFrame {

	private Container c;
	private JLabel board;
	private JLabel user;
	private JLabel img;
	private JLabel pass;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	private JLabel kyf;
	private JTextField userf;
	private JPasswordField passf;
	private Font f;

	private JButton login, back;
	public static String n, add, ph;

	logincustomerD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(200, 30, 1200, 800);// setLocation+setSize
		setTitle("Log in customer");
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
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 25);

		ic = new ImageIcon(getClass().getResource("iduser.png"));
		ps = new ImageIcon(getClass().getResource("pass.png"));
		ky = new ImageIcon(getClass().getResource("key.png"));
		log = new ImageIcon(getClass().getResource("log.png"));

		user = new JLabel(ic);

		user.setBounds(303, 290, 70, 50);
		user.setFont(f);
		c.add(user);

		board = new JLabel(log);
		board.setBounds(500, 150, 100, 100);
		board.setFont(new Font("Didot", Font.BOLD, 55));
		c.add(board);

		pass = new JLabel(ps);
		pass.setBounds(300, 370, 70, 58);
		pass.setFont(f);
		c.add(pass);

		kyf = new JLabel(ky);
		kyf.setBounds(700, 370, 50, 50);
		kyf.setFont(f);
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
		login.setBounds(590, 480, 250, 55);
		login.setForeground(Color.BLACK);
		login.setBackground(Color.getHSBColor(205, 255, 105));
		login.setFont(f);
		c.add(login);

		back = new JButton("back");
		back.setBounds(290, 480, 250, 55);
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

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = userf.getText();
				String p = passf.getText();
				cheakD ob = new cheakD();
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

						profilecustomerD obb = new profilecustomerD();
						obb.initialize(s);

						// obb.initialize(s);
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
		logincustomerD frame = new logincustomerD();
		frame.setVisible(true);
	}

}
