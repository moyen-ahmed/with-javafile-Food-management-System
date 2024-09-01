package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OnlinePayment extends JFrame {
	private Container c;
	private Font f;
	private JLabel ac,amount,tk;
	private JTextField acf,amountf;
	private JButton pay,back,logout;
	private static String payable="0";

	OnlinePayment(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600);
		setTitle("Online Payment");
		setResizable(false);
		initComponent();
	}
	
	public void initialize(String payable) {
		this.payable=payable;
		}
 
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		
		f = new Font("Arial", Font.BOLD, 20);
		

		ac = new JLabel("Account number:");
		ac.setBounds(10, 200, 150, 25);
		ac.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(ac);
		acf = new JTextField();
		acf.setBounds(160, 203, 200, 25);
		acf.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(acf);
		
		amount = new JLabel("Payable Amount:");
		amount.setBounds(10,250, 150, 25);
		amount.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(amount);
		amountf = new JTextField();
		amountf.setBounds(160,250, 100, 25);
		amountf.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(amountf);
		
		tk = new JLabel("TK");
		tk.setBounds(270,250, 150, 25);
		tk.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(tk);
		
		pay = new JButton("Click Here to Pay");
		pay.setBounds(90,320, 200, 25);
		pay.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(pay);
		
		back = new JButton("Back");
		back.setBounds(10,380, 150, 25);
		back.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(back);
		
		logout = new JButton("Log out");
		logout.setBounds(210,380, 150, 25);
		logout.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(logout);
		
		System.out.println(payable);
		amountf.setText(payable);

		logout = new JButton("Log out");
		logout.setBounds(210,380, 150, 25);
		logout.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(logout);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart ob = new cart();
				dispose();
				ob.cart1();
				
		   
			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home ob = new home();
				dispose();
				ob.start();
				
		   
			}
		});
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"paid successfully");
				dispose();
				lastpagecustomer ob = new lastpagecustomer();
				ob.lastpagecustomer1();
				
		   
			}
		});
		
		
		
		
	}
	 public static void main(String[] args) {
		 onlinepayment1();
	 }
	

	public static void onlinepayment1(){
		OnlinePayment frame = new OnlinePayment();
		frame.setVisible(true);
	}
}
