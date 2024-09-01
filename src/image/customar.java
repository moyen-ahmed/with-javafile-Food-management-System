package image;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class customar extends JFrame {

	private Container c;
	private Font f;
	private JLabel user;
	private JLabel pass;
	public JTextField userf;
	private JPasswordField passf;
	private JButton save, clear, back;

	customar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("Customer create");
		setResizable(false);
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

		save = new JButton("save");
		save.setBounds(190, 400, 150, 25);
		save.setFont(f);
		c.add(save);

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
				create ob = new create();
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
				cheak ob=new cheak();
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
					JOptionPane.showMessageDialog(null,"You didn't enter anyting ");
					customar1();
				}
				

				else if (ob.cheakcus(s)) {
					write.append(s);
					write.append("\n");

					JOptionPane.showMessageDialog(null,"user id Successfull");

					String p = passf.getText();
					//System.out.println("Enter your password: ");
					write.append(p);
					write.append("\n");
					write.append(s+" "+p); // using for matching username and password in log in method()
					write.append("\n");
					JOptionPane.showMessageDialog(null,"your account is created\nyour account is created");
					JOptionPane.showMessageDialog(null,"please keep your password and userid safe\n");
					
					// infoowner ob=new infoowner();
					// ob.infoown(s);
					write.close();
					dispose();
					infoCustomer obb = new infoCustomer();
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
					JOptionPane.showMessageDialog(null,"it already booked.");
					
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
		customar frame = new customar();
		frame.setVisible(true);
	}
}


