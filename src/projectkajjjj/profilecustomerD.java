package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class profilecustomerD extends JFrame {
	private Container c;
	private Font f, f1;
	private JLabel name, address, phone, title;
	private JTextArea namef, addressf, phonef;
	private JButton edit, gotofood, logout, voucher;
	private static String x, y, z, i;
	private ImageIcon us, ad, phn, deat;
	private String n, add, ph;

	public void initialize(String x) {
		this.x = x;

	}

	profilecustomerD() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 30, 1200, 800);

		this.setTitle("profile customer ");
		this.setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		us = new ImageIcon(getClass().getResource("namee.png"));
		ad = new ImageIcon(getClass().getResource("loca.png"));
		phn = new ImageIcon(getClass().getResource("call.png"));
		deat = new ImageIcon(getClass().getResource("deat.png"));

		f = new Font("Arial", Font.BOLD, 20);
		f1 = new Font("Arial", Font.BOLD, 25);

		title = new JLabel(deat);
		title.setBounds(450, 5, 250, 250);
		title.setFont(f1);
		title.setForeground(Color.blue);
		c.add(title);

		name = new JLabel(us);
		name.setBounds(230, 230, 80, 80);
		name.setFont(f);
		c.add(name);
		address = new JLabel(ad);
		address.setBounds(220, 305, 100, 80);
		address.setFont(f);
		c.add(address);
		phone = new JLabel(phn);
		phone.setBounds(170, 350, 250, 150);
		phone.setFont(f);
		c.add(phone);
		edit = new JButton("Edit");
		edit.setBounds(290, 500, 250, 65);
		edit.setForeground(Color.black);
		edit.setBackground(Color.getHSBColor(205, 255, 105));
		edit.setFont(f);
		c.add(edit);
		gotofood = new JButton("Order Food");
		gotofood.setBounds(290, 600, 250, 65);
		gotofood.setForeground(Color.black);
		gotofood.setBackground(Color.getHSBColor(205, 255, 105));
		gotofood.setFont(f);
		c.add(gotofood);
		logout = new JButton("Logout");
		logout.setBounds(620, 500, 250, 65);
		logout.setForeground(Color.black);
		logout.setBackground(Color.getHSBColor(205, 255, 105));
		logout.setFont(f);
		c.add(logout);
		voucher = new JButton("Vouchers");
		voucher.setBounds(620, 600, 250, 65);
		voucher.setForeground(Color.black);
		voucher.setBackground(Color.getHSBColor(205, 255, 105));
		voucher.setFont(f);
		c.add(voucher);
//
		namef = new JTextArea();
		namef.setBounds(350, 260, 450, 45);
		namef.setFont(f);
		c.add(namef);
		addressf = new JTextArea();
		addressf.setBounds(350, 340, 450, 45);
		addressf.setFont(f);
		c.add(addressf);
		phonef = new JTextArea();
		phonef.setBounds(350, 420, 450, 45);
		phonef.setFont(f);
		c.add(phonef);
		FileOutputStream fos = null;
		cheakD ob = new cheakD();

		try {
			File file = new File("infoCustomer.txt");
			Scanner input = new Scanner(file);

			while (input.hasNext()) {

				String d = input.next();
				if (d.equals(x + "all")) {
					n = input.next();
					add = input.next();
					ph = input.next();
					input.close();
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("select food error");
		}

		namef.append(n);
		addressf.append(add);
		phonef.append(ph);
		System.out.println(n + "\n" + add);

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				dispose();
				ob.start();
			}
		});

		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		gotofood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				foodD ob = new foodD();
				dispose();
				ob.food1();
			}
		});
		cartD ob4 = new cartD(); /// passing user id to cart for doing vaoucher
		ob4.initialize1(x);

		voucher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheakD ob1 = new cheakD();
				String v = ob1.voucher(x);

				JOptionPane.showMessageDialog(null, "your voucher code : " + v + "\nuse this to get 50 tk discount");

			}
		});

	}

	public static void main(String[] args) {
		profilecustomer1();
	}

	public static void profilecustomer1() {
		profilecustomerD frame = new profilecustomerD();
		frame.setVisible(true);
	}
}
