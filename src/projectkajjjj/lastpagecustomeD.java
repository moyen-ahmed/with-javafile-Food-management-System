package projectkajjjj;

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

public class lastpagecustomeD extends JFrame {
	private Container c;
	private JLabel name, address, ph, board;
	private JTextField namef, addressf, phf;
	private JButton save, next, back;
	private Font f;

	lastpagecustomeD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800);
		setTitle("Online Payment(lastpage)");

		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);

		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);
		board = new JLabel("Order Information");
		board.setBounds(400, 25, 350, 25);
		board.setFont(new Font("Serif", Font.BOLD, 35));
		board.setForeground(Color.BLACK);
		c.add(board);

		name = new JLabel("Name     :");
		name.setBounds(280, 100, 150, 25);
		name.setFont(new Font("Serif", Font.BOLD, 18));
		name.setForeground(Color.BLACK);
		c.add(name);

		namef = new JTextField();
		namef.setBounds(400, 100, 350, 35);
		namef.setFont(f);
		c.add(namef);

		address = new JLabel("Address :");
		address.setBounds(280, 150, 250, 25);
		address.setFont(new Font("Serif", Font.BOLD, 18));
		address.setForeground(Color.BLACK);
		c.add(address);

		addressf = new JTextField();
		addressf.setBounds(400, 150, 350, 35);
		addressf.setFont(f);
		c.add(addressf);

		ph = new JLabel("Contact     :");
		ph.setBounds(280, 200, 250, 25);
		ph.setFont(new Font("Serif", Font.BOLD, 18));
		ph.setForeground(Color.BLACK);
		c.add(ph);
		phf = new JTextField();
		phf.setBounds(400, 200, 350, 35);
		phf.setFont(f);
		c.add(phf);

		next = new JButton("Next");
		next.setBounds(600, 300, 150, 45);
		next.setForeground(Color.BLACK);
		next.setFont(new Font("Serif", Font.BOLD, 20));
		next.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(next);

		back = new JButton("Back");
		back.setBounds(350, 300, 150, 45);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(back);

		String namea = "null", addressa = "null", pha = "null";
		namea = namef.getText();
		addressa = addressf.getText();
		pha = phf.getText();
		System.out.println(namea);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (namef.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "you didn't enter any name");

				} else {
					if (addressf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "you didn't enter your Location");
					} else {
						if (phf.getText().isEmpty() || phf.getText().length() != 11) {
							JOptionPane.showMessageDialog(null, "Wrong phone number");
						} else {
							End ob = new End();
							ob.initialize(namef.getText(), addressf.getText(), phf.getText(),
									"9LI4T75S6" + namef.getText());
							ob.end1();
						}
					}

				}

			}
		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "please select your order location");

			}
		});

	}

	public static void main(String[] args) {
		lastpagecustomer1();
	}

	public static void lastpagecustomer1() {
		lastpagecustomeD frame = new lastpagecustomeD();
		frame.setVisible(true);
	}
}
