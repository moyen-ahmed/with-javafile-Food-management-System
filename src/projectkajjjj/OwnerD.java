package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OwnerD extends JFrame {

	private Container c;
	private Font f;
	private JLabel user, kyf, board;
	private JLabel pass;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	public JTextField userf;
	private JPasswordField passf;
	private JButton save, clear, back;

	OwnerD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("0wner Create Account(owner)");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);

		ic = new ImageIcon(getClass().getResource("iduser.png"));
		ps = new ImageIcon(getClass().getResource("pass.png"));
		ky = new ImageIcon(getClass().getResource("key.png"));
		log = new ImageIcon(getClass().getResource("creat (1).png"));
		user = new JLabel(ic);
		user.setBounds(303, 290, 70, 50);
		c.add(user);
		board = new JLabel(log);
		board.setBounds(350, 50, 500, 200);
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

		save = new JButton("Sign Up");
		save.setBounds(590, 480, 250, 60);
		save.setForeground(Color.BLACK);
		save.setBackground(Color.getHSBColor(205, 255, 105));
		save.setFont(f);
		c.add(save);

		clear = new JButton("Clear");
		clear.setBounds(430, 580, 250, 60);
		clear.setForeground(Color.BLACK);
		clear.setBackground(Color.getHSBColor(205, 255, 105));
		clear.setFont(f);
		c.add(clear);

		back = new JButton("Back");
		back.setBounds(290, 480, 250, 60);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(f);
		c.add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createD ob = new createD();
				dispose();
				ob.create1();
			}
		});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userf.setText(" ");
				passf.setText("");
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//
				File file = new File("owner.txt");
				FileOutputStream fos = null;
				cheakD ob = new cheakD();
				try {
					fos = new FileOutputStream(file, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write = new PrintWriter(fos);
				String s;
				s = userf.getText();
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "you didn't enter anything");
					dispose();
					owner1();
				}

				else if (ob.cheakown(s)) { // call cheak() for is anyone previously use this userid
					write.append(s);
					write.append("\n");
					JOptionPane.showMessageDialog(null, "user id Successfull");

					String p = passf.getText();

					write.append(p);
					write.append("\n");
					write.append(s + " " + p); // using for matching username and password in log in method()
					write.append("\n");

					// JOptionPane.showMessageDialog(null, "your account is created\nyour user user
					// id :" + s, "title",
					// JOptionPane.INFORMATION_MESSAGE);

					// JOptionPane.showMessageDialog(null, "please keep your password and userid
					// safe", "title",
					// JOptionPane.INFORMATION_MESSAGE);

					dispose();

					write.close();
					try {
						infoOwnerD ob1 = new infoOwnerD();
						ob1.initialize(userf.getText());
						dispose();
						ob1.infoOwner1();
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else // if previously use this user id
				{
					JOptionPane.showMessageDialog(null, "this user id is already booked.");

					dispose();
					owner1();
				}
			}

		});

	}

	public static boolean cheak(String str) {
		File f = new File("owner.txt");
		int c = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(str)) {
					c = 1;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("cheak error");
		}
		if (c == 1)
			return false;
		else
			return true;

	}

	public static void main(String[] args) {
		owner1();
	}

	public static void owner1() {
		OwnerD frame = new OwnerD();
		frame.setVisible(true);
	}
}
