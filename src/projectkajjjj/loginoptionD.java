
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

public class loginoptionD extends JFrame {
	private JButton owner, customer, back;
	private Container c;
	private JLabel board;
	private ImageIcon l;

	loginoptionD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800);
		setTitle("log in Option");
		setResizable(false);

		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setBackground(new Color(61, 200, 255));
		c.setLayout(null);

		l = new ImageIcon(getClass().getResource("login (1).png"));

		board = new JLabel(l);
		board.setBounds(300, 50, 700, 300);
//		board.setBackground(Color.BLACK);
//		board.setFont(new Font("Didot", Font.BOLD, 47));
		c.add(board);

		owner = new JButton("Owner");
		owner.setBounds(180, 500, 250, 80);
		owner.setForeground(Color.BLACK);
		owner.setBackground(Color.getHSBColor(205, 255, 105));
		owner.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(owner);

		customer = new JButton("customer");
		customer.setBounds(900, 500, 250, 80);
		customer.setForeground(Color.BLACK);
		customer.setBackground(Color.getHSBColor(205, 255, 105));
		customer.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(customer);

		back = new JButton("back");
		back.setBounds(500, 600, 250, 80);
		back.setForeground(Color.BLACK);

		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(new Font("Arial", Font.BOLD, 25));
		c.add(back);

		owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginownerD ob = new loginownerD();
				dispose();
				ob.loginowner1();
			}
		});

		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logincustomerD ob = new logincustomerD();
				dispose();
				ob.logincustomer1();
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
		loginoption1();
	}

	public static void loginoption1() {
		loginoptionD frame = new loginoptionD();
		frame.setVisible(true);
	}

}
