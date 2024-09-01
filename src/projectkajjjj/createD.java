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

public class createD extends HomeD {
	private JLabel pi;
	private ImageIcon cr;
	private JButton owner, customer, back;
	private Container c;

	createD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Create option (create)");
		setResizable(false);

		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		cr = new ImageIcon(getClass().getResource("creat (1).png"));
		pi = new JLabel(cr);
		pi.setBounds(240, 20, 800, 300);

		c.add(pi);

		owner = new JButton("Owner");
		owner.setBounds(240, 480, 250, 80);
		owner.setForeground(Color.black);
		owner.setBackground(Color.getHSBColor(205, 255, 105));
		owner.setFont(new Font("Arial", Font.BOLD, 25));

		c.add(owner);

		customer = new JButton("Customer");
		customer.setBounds(770, 480, 250, 80);
		customer.setForeground(Color.BLACK);
		customer.setBackground(Color.getHSBColor(205, 255, 105));
		customer.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(customer);

		back = new JButton("Back");
		back.setBounds(500, 600, 250, 80);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(back);

		owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerD ob = new OwnerD();
				dispose();
				ob.owner1();
			}
		});

		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customarD ob = new customarD();
				dispose();
				ob.customar1();
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				dispose();
				ob.start();
			}
		});

	}

	public static void main(String[] args) {
		create1();
	}

	public static void create1() {
		createD frame = new createD();
		frame.setVisible(true);
	}
}
