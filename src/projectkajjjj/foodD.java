package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class foodD extends JFrame {
	private Container c;
	private Font f, f1;
	private JLabel search;
	private JTextField searchf;
	private JButton searchb, back, cart, clear;
	private JTextArea searcha;

	foodD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("food");
		setResizable(false);
		initComponent();

	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);
		f1 = new Font("Arial", Font.BOLD, 30);

		search = new JLabel("Click Here to see All resturent :");
		search.setBounds(340, 10, 350, 45);
		search.setFont(f);
		c.add(search);

		searchb = new JButton("Click");
		searchb.setBounds(660, 70, 200, 45);
		searchb.setForeground(Color.black);
		searchb.setFont(f);
		searchb.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(searchb);

		searcha = new JTextArea();
		searcha.setBounds(10, 125, 1200, 450);
		searcha.setFont(f1);
		searcha.setForeground(Color.BLACK);

		searchb.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(searcha);

		back = new JButton("Back");
		back.setBounds(150, 600, 200, 50);
		back.setForeground(Color.BLACK);

		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(f);
		c.add(back);

		cart = new JButton("Next");
		cart.setBounds(820, 600, 200, 50);
		cart.setForeground(Color.BLACK);
		cart.setBackground(Color.getHSBColor(205, 255, 105));
		cart.setFont(f);
		c.add(cart);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logincustomerD ob = new logincustomerD();
				dispose();
				ob.logincustomer1();

			}
		});
		//
		searcha.setText("");
		searchb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searcha.setText("");

				try {
					File file = new File("resname.txt");

					Scanner input;

					input = new Scanner(file);

					int cnt = 1;
					while (input.hasNext()) {
						String resname = input.next();
						String numbering = String.valueOf(cnt);
						searcha.append(numbering + ".");
						searcha.append(resname);
						searcha.append("\n");
						cnt++;

					}
					input.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectfoodD ob = new selectfoodD();
				dispose();

				ob.selectfood1();

			}
		});

		searcha = new JTextArea();
		searcha.setBounds(10, 125, 350, 350);
		c.add(searcha);

	}

	public static void main(String[] args) {
		food1();
	}

	public static void food1() {
		foodD frame = new foodD();
		frame.setVisible(true);
	}
}
