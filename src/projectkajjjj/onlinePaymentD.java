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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class onlinePaymentD extends JFrame {
	private Container c;
	private Font f;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon k;
	private ImageIcon lo;
	private JLabel ac, amount, tk, p1, p2, p3;
	private JTextField acf, amountf;
	private JButton pay, back, logout;
	private static String payable = "0";

	onlinePaymentD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800);
		setTitle("Online Payment");
		setResizable(false);
		initComponent();
	}

	public void initialize(String payable) {
		this.payable = payable;
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);

		ac = new JLabel("Account number:");
		ac.setBounds(300, 150, 150, 25);
		ac.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(ac);

		ic = new ImageIcon(getClass().getResource("smartpho.png"));
		p1 = new JLabel(ic);
		p1.setBounds(490, 10, 150, 110);
		p1.setFont(new Font("Serif", Font.BOLD, 50));
		c.add(p1);

		ps = new ImageIcon(getClass().getResource("payment.png"));
		p2 = new JLabel(ps);
		p2.setBounds(850, 250, 190, 190);
		p2.setFont(new Font("Serif", Font.BOLD, 50));
		c.add(p2);
		k = new ImageIcon(getClass().getResource("taka.png"));
		p3 = new JLabel(k);
		p3.setBounds(1000, 250, 190, 190);
		p3.setFont(new Font("Serif", Font.BOLD, 50));
		c.add(p3);

		acf = new JTextField();
		acf.setBounds(460, 150, 290, 45);
		acf.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(acf);

		amount = new JLabel("Payable Amount:");
		amount.setBounds(300, 250, 150, 25);
		amount.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(amount);
		amountf = new JTextField();
		amountf.setBounds(460, 250, 200, 45);
		amountf.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(amountf);

		tk = new JLabel("TK");
		tk.setBounds(720, 250, 250, 25);
		tk.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(tk);

		pay = new JButton("Click Here to Pay");
		pay.setBounds(460, 350, 200, 45);
		pay.setForeground(Color.BLACK);
		pay.setBackground(Color.getHSBColor(205, 255, 105));

		pay.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(pay);

		back = new JButton("Back");
		back.setBounds(390, 450, 150, 55);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));

		back.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(back);

		logout = new JButton("Log out");
		logout.setBounds(650, 450, 150, 55);
		logout.setForeground(Color.BLACK);
		logout.setBackground(Color.getHSBColor(205, 255, 105));

		logout.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(logout);

		System.out.println(payable);
		amountf.setText(payable);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartD ob = new cartD();
				dispose();
				ob.cart1();

			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				dispose();
				ob.start();

			}
		});
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acf.getText().length() != 13) {
					JOptionPane.showMessageDialog(null, "wrong acount number , please enter 13 digit of your account");
				} else {
					JOptionPane.showMessageDialog(null, "paid successfully");
					dispose();
					lastpagecustomeD ob = new lastpagecustomeD();
					ob.lastpagecustomer1();
				}

			}
		});

	}

	public static void main(String[] args) {
		onlinepayment1();
	}

	public static void onlinepayment1() {
		onlinePaymentD frame = new onlinePaymentD();
		frame.setVisible(true);
	}
}
