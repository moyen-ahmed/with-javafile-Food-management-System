package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class profileownerD extends JFrame {
	private Container c;
	private Font f;
	private JLabel name, resname, title, address, phone;
	private JTextArea namef, addressf, phonef, resnamef;
	private JButton logout, edit, foodaddb, voucherb;
	private static String id = "a", namea, addressa, phonea, resnamea, vouchera, discounttka, minordertka;

	profileownerD() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 30, 1200, 800);
		// setLocation+setSize
		this.setTitle("owner profile ");
		this.setResizable(false);
		initComponent();
	}

	public void initialize(String id) {
		this.id = id;
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);

		title = new JLabel("Your Profile");
		title.setBounds(500, 25, 250, 35);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.BLACK);
		c.add(title);

		name = new JLabel("Name         :");
		name.setBounds(280, 100, 150, 25);
		name.setFont(f);
		c.add(name);

		namef = new JTextArea();
		namef.setBounds(400, 100, 350, 35);
		namef.setFont(f);
		c.add(namef);

		address = new JLabel("Address    :");
		address.setBounds(280, 150, 150, 25);
		address.setFont(f);
		c.add(address);
		phone = new JLabel("Contact      :");
		phone.setBounds(280, 200, 250, 25);
		phone.setFont(f);
		c.add(phone);

		addressf = new JTextArea();
		addressf.setBounds(400, 150, 350, 35);
		addressf.setFont(f);
		c.add(addressf);
		phonef = new JTextArea();
		phonef.setBounds(400, 200, 350, 35);
		phonef.setFont(f);
		c.add(phonef);

		resname = new JLabel("Restaurant :");
		resname.setBounds(280, 250, 150, 25);
		resname.setFont(f);
		c.add(resname);
		resnamef = new JTextArea();
		resnamef.setBounds(400, 250, 350, 35);
		resnamef.setFont(f);
		c.add(resnamef);

		edit = new JButton("Edit");
		edit.setBounds(400, 300, 150, 45);
		edit.setForeground(Color.BLACK);
		edit.setBackground(Color.getHSBColor(205, 255, 105));

		edit.setFont(f);
		c.add(edit);

		logout = new JButton("Logout");
		logout.setBounds(600, 380, 150, 45);
		logout.setForeground(Color.BLACK);
		logout.setBackground(Color.getHSBColor(205, 255, 105));

		logout.setFont(f);
		c.add(logout);

		foodaddb = new JButton("Add Food");
		foodaddb.setBounds(600, 300, 150, 45);
		foodaddb.setForeground(Color.BLACK);
		foodaddb.setBackground(Color.getHSBColor(205, 255, 105));

		foodaddb.setFont(f);
		c.add(foodaddb);

		voucherb = new JButton("Vouchers");
		voucherb.setBounds(400, 380, 150, 45);
		voucherb.setForeground(Color.BLACK);
		voucherb.setBackground(Color.getHSBColor(205, 255, 105));

		voucherb.setFont(f);
		c.add(voucherb);

		FileOutputStream fos = null;
		cheakD ob = new cheakD();

		try {
			File file = new File("infoowner.txt");
			Scanner input = new Scanner(file);

			while (input.hasNext()) {

				String d = input.next();
				if (d.equals(id + "all")) {

					namea = input.next();
					addressa = input.next();
					phonea = input.next();
					resnamea = input.next();

					break;
				}

			}
			input.close();

		} catch (Exception e) {
			System.out.println("select food error");
		}

		namef.append(namea);
		addressf.append(addressa);
		phonef.append(phonea);
		resnamef.append(resnamea);

		foodaddb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodaddD ob = new foodaddD();
				ob.initialize(resnamea);
				dispose();
				ob.foodadd1();

			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				dispose();
				ob.start();

			}
		});

	}

	public static void main(String[] args) {
		profileowner1();
	}

	public static void profileowner1() {
		profileownerD frame = new profileownerD();
		frame.setVisible(true);
	}
}
