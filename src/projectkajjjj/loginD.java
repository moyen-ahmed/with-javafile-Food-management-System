package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginD extends JFrame {

	private Container c;
	private JLabel user;
	private JLabel pass;
	private JTextField userf;
	private JPasswordField passf;
	private Font f;
	private JButton login, clear, back;

	loginD() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 250, 400, 600); // setLocation+setSize
		this.setTitle("Log in ");
		this.setResizable(false);
		initComponent();
	}

	public void initComponent() {
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

				System.out.println("here" + s);

			}
		});

	}

	public static void main(String[] args) {
		login1();
	}

	public static void login1() {
		loginD frame = new loginD();
		frame.setVisible(true);
	}
}
