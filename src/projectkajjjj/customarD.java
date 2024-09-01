package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class customarD extends JFrame {

	private Container c;
	private Font f;
	private JLabel user;
	private JLabel pass;
	private JLabel cr;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	public JTextField userf;
	private JPasswordField passf;
	private JButton save, clear, back;

	customarD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Customer");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);

		ic = new ImageIcon(getClass().getResource("iduser.png"));
		ps = new ImageIcon(getClass().getResource("pass.png"));
		ky = new ImageIcon(getClass().getResource("key.png"));
		log = new ImageIcon(getClass().getResource("cre.png"));

		cr = new JLabel(log);
		cr.setBounds(350, 100, 420, 105);
		c.add(cr);

		user = new JLabel(ic);
		user.setBounds(343, 270, 70, 70);
		user.setFont(f);
		c.add(user);

		pass = new JLabel(ps);
		pass.setBounds(343, 370, 79, 58);
		pass.setFont(f);
		c.add(pass);

		userf = new JTextField();
		userf.setBounds(450, 290, 290, 45);
		userf.setFont(f);
		c.add(userf);

		passf = new JPasswordField();
		passf.setBounds(450, 380, 290, 45);
		passf.setFont(f);
		c.add(passf);

		save = new JButton("save");
		save.setBounds(650, 480, 250, 70);
		save.setFont(new Font("Arial", Font.BOLD, 35));
		save.setForeground(Color.BLACK);
		save.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(save);

		clear = new JButton("clear");
		clear.setBounds(300, 480, 250, 70);
		clear.setFont(new Font("Arial", Font.BOLD, 35));
		clear.setForeground(Color.BLACK);
		clear.setBackground(Color.getHSBColor(205, 255, 105));

		c.add(clear);

		back = new JButton("back");
		back.setBounds(490, 600, 250, 70);
		back.setFont(new Font("Arial", Font.BOLD, 35));
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));

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

				userf.setText("");
				passf.setText("");
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//

				File file = new File("customer.txt");
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
					System.out.println("you disn't enter anything");
					customar1();
				}

				else if (ob.cheakcus(s)) {
					write.append(s);
					write.append("\n");

					System.out.println("user id Successfull");

					String p = passf.getText();
					System.out.println("Enter your password: ");
					write.append(p);
					write.append("\n");
					write.append(s + " " + p); // using for matching username and password in log in method()
					write.append("\n");
					System.out.println("your account is created");
					System.out.println("your user user id :" + s);
					System.out.println("your password :*******");
					System.out.println("please keep your password and userid safe");
					// infoowner ob=new infoowner();
					// ob.infoown(s);
					write.close();
					dispose();
					infocustomerD obb = new infocustomerD();
					obb.initialize(s);
					obb.infoCustomer1();
					try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else // if previously use this user id
				{
					System.out.println("it already booked.");
					dispose();
					customar1();
				}
			}

		});

	}

	public static void main(String[] args) {
		customar1();
	}

	public static void customar1() {
		customarD frame = new customarD();
		frame.setVisible(true);
	}
}
