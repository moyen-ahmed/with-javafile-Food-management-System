package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class End extends JFrame {
	private Container c;
	private JLabel end, title, ph, board;
	private JTextArea showdeatils;
	private JButton chat, home;
	private Font f;
	public static String name, address, phone, trans;

	public void initialize(String name, String address, String phone, String trans) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.trans = trans;

	}

	End() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800);
		setTitle("End");

		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);

		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);

		board = new JLabel("Your order information");
		board.setBounds(430, 25, 550, 55);
		board.setFont(new Font("Serif", Font.BOLD, 40));
		board.setForeground(Color.BLACK);
		c.add(board);

		showdeatils = new JTextArea();
		showdeatils.setBounds(400, 150, 450, 335);
		showdeatils.setFont(f);
		c.add(showdeatils);

		end = new JLabel("Have patience  Your food is comming Soon.....");
		end.setBounds(280, 600, 550, 35);
		end.setFont(new Font("Serif", Font.BOLD, 26));
		end.setForeground(Color.BLACK);
		c.add(end);

		title = new JLabel("Details");
		title.setBounds(280, 150, 250, 25);
		title.setFont(new Font("Serif", Font.BOLD, 28));
		title.setForeground(Color.BLACK);
		c.add(title);

		chat = new JButton("Chat");
		chat.setBounds(400, 500, 150, 45);
		chat.setForeground(Color.BLACK);
		chat.setFont(new Font("Serif", Font.BOLD, 20));
		chat.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(chat);

		home = new JButton("Home");
		home.setBounds(650, 500, 150, 45);
		home.setForeground(Color.BLACK);
		home.setFont(new Font("Serif", Font.BOLD, 20));
		home.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(home);
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chat ob = new chat();
				ob.chat1();

			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		showdeatils.append("name : " + name + "\n");
		showdeatils.append("adress : " + address + "\n");
		showdeatils.append("phone  : " + phone + "\n");

		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chat ob = new chat();
				// ob.chat1();

			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilecustomerD ob = new profilecustomerD();
				dispose();
				ob.profilecustomer1();

			}
		});

	}

	public static void main(String[] args) {
		end1();
	}

	public static void end1() {
		End frame = new End();
		frame.setVisible(true);
	}
}
