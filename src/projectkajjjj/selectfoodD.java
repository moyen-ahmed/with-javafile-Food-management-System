package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class selectfoodD extends JFrame {
	private Container c;
	private JLabel food, title, item, total, search, p1, p2, p3, p4, p5, p6, p8, p7;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	private ImageIcon P1;
	private ImageIcon P2;
	private ImageIcon P3;
	private ImageIcon P4;
	private ImageIcon P5;
	private ImageIcon P6;

	private JTextArea monitor, totala, itemf;
	private JTextField foodf, searchf;
	private JButton cart, back, clear, more, select, quantity, quantity2, searchb;
	private Font f, f1;
	public static int tk = 0, q = 1;
	public String q1;
	public String s;

	selectfoodD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("select food");
		setResizable(false);
		initComponent();

	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);
		f1 = new Font("Serif", Font.ITALIC, 18);

		ic = new ImageIcon(getClass().getResource("hamburge.png"));
		ps = new ImageIcon(getClass().getResource("chicken.png"));
		ky = new ImageIcon(getClass().getResource("hotdog.png"));
		P1 = new ImageIcon(getClass().getResource("pz.png"));
		P2 = new ImageIcon(getClass().getResource("soda.png"));
		P3 = new ImageIcon(getClass().getResource("pizza.png"));
		P4 = new ImageIcon(getClass().getResource("kaba.png"));
		P5 = new ImageIcon(getClass().getResource("fried.png"));
		P6 = new ImageIcon(getClass().getResource("dount.png"));
		log = new ImageIcon(getClass().getResource("coffe.png"));
		p1 = new JLabel(ic);
		p1.setBounds(600, 65, 150, 150);
		c.add(p1);
		p2 = new JLabel(ps);
		p2.setBounds(820, 100, 150, 150);
		c.add(p2);
		p3 = new JLabel(ky);
		p3.setBounds(620, 290, 110, 110);
		c.add(p3);
		p4 = new JLabel(log);
		p4.setBounds(1050, 10, 110, 110);
		c.add(p4);
		p5 = new JLabel(P1);
		p5.setBounds(780, 360, 150, 150);
		c.add(p5);
		p6 = new JLabel(P2);
		p6.setBounds(790, 580, 150, 150);
		c.add(p6);
		p7 = new JLabel(P3);
		p7.setBounds(950, 595, 150, 150);
		c.add(p7);
		p8 = new JLabel(P4);
		p8.setBounds(1000, 250, 150, 150);
		c.add(p8);
		p8 = new JLabel(P5);
		p8.setBounds(550, 520, 150, 150);
		c.add(p8);
		p8 = new JLabel(P6);
		p8.setBounds(950, 410, 150, 150);
		c.add(p8);
		p8 = new JLabel(P4);
		p8.setBounds(600, 65, 150, 150);
		c.add(p8);

		title = new JLabel("Your Searched food");
		title.setBounds(20, 70, 250, 25);
		title.setFont(f);
		c.add(title);
		monitor = new JTextArea();
		monitor.setBounds(10, 100, 580, 300);
		monitor.setFont(f1);
		c.add(monitor);

		food = new JLabel("Select Food   :");
		food.setBounds(10, 420, 150, 25);
		food.setFont(f);
		c.add(food);

		search = new JLabel("Search Resturent :");
		search.setBounds(90, 5, 250, 35);
		search.setFont(f);
		c.add(search);

		foodf = new JTextField();
		foodf.setBounds(155, 410, 270, 35);
		foodf.setFont(f);
		c.add(foodf);

		searchf = new JTextField();
		searchf.setBounds(300, 10, 270, 35);
		searchf.setFont(f);
		c.add(searchf);

		item = new JLabel("Quantity         :");
		item.setBounds(10, 480, 250, 55);
		item.setFont(f);
		c.add(item);

		select = new JButton("Select");
		select.setBounds(470, 410, 124, 35);
		select.setForeground(Color.BLACK);
		select.setBackground(Color.getHSBColor(205, 255, 105));
		select.setFont(f);
		c.add(select);

		itemf = new JTextArea("1");
		itemf.setBounds(170, 480, 50, 25);
		itemf.setFont(f);
		c.add(itemf);

		total = new JLabel("Your total bill:");
		total.setBounds(10, 550, 150, 25);
		total.setFont(f);
		c.add(total);

		totala = new JTextArea("0.00");
		totala.setBounds(190, 550, 250, 35);
		totala.setFont(f);
		c.add(totala);

		back = new JButton("Back");
		back.setBounds(10, 700, 190, 45);
		back.setForeground(Color.BLACK);
		back.setFont(f);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(back);

		clear = new JButton("Clear");
		clear.setBounds(10, 650, 190, 45);
		clear.setForeground(Color.BLACK);
		clear.setFont(f);
		clear.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(clear);

		more = new JButton("Add Food");
		more.setBounds(280, 650, 190, 45);
		more.setFont(f);
		more.setForeground(Color.BLACK);
		more.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(more);

		cart = new JButton("Add to cart");
		cart.setBounds(280, 700, 190, 45);
		cart.setFont(f);
		cart.setForeground(Color.BLACK);
		cart.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(cart);

		quantity = new JButton("+");
		quantity.setBounds(280, 470, 60, 60);
		quantity.setForeground(Color.BLACK);
		quantity.setBackground(Color.getHSBColor(205, 255, 105));
		quantity.setFont(f);
		c.add(quantity);

		searchb = new JButton("Search");
		searchb.setBounds(600, 10, 150, 50);
		searchb.setForeground(Color.BLACK);
		searchb.setBackground(Color.getHSBColor(205, 255, 105));
		searchb.setFont(f);
		c.add(searchb);

		quantity2 = new JButton("-");
		quantity2.setBounds(370, 470, 60, 60);

		quantity2.setForeground(Color.BLACK);
		quantity2.setBackground(Color.getHSBColor(205, 255, 105));
		quantity2.setFont(f);
		c.add(quantity2);

		try {
			File file = new File("temfood.txt");
			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				monitor.append(input.next());
				monitor.append(" ");
				monitor.append(input.next());

				monitor.append(" \n");

			}

		} catch (Exception e) {
			System.out.println("select food error");
		}
		monitor.setText("");

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodf.setText("");
				itemf.setText("");
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodD ob = new foodD();
				dispose();
				ob.food1();

			}
		});
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				selectfood1();

			}
		});
		searchb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitor.setText("");
				String restaurantname = searchf.getText();
				cartD ob = new cartD(); /// passsing restant name to varify restaurant voucher
				ob.initialize2(restaurantname);
				if (restaurantname.isEmpty())
					JOptionPane.showMessageDialog(null, "please type a resturant name :");
				try {
					File file = new File("foodlist.txt");
					Scanner input = new Scanner(file);
					int c = 0, stop = 0;
					cheakD ob1 = new cheakD();

					int x = ob1.chk(restaurantname + "start");// start
					int y = ob1.chk(restaurantname + "end");// end
					File file1 = new File("temfood.txt");
					PrintWriter output = new PrintWriter(file1);

					while (input.hasNext()) {
						c++;
						input.next();
						if (c == x) {
							for (int i = x; i < y; i++) {
								try {

									String foodname = input.next();
									output.print(foodname);
									output.print(" ");
									monitor.append(foodname);
									monitor.append(" ");

									// String foodname = input.next();
									i++;
									String pricename = input.next();

									monitor.append(pricename);
									monitor.append(" ");
									output.print(pricename);
									output.print(" ");
									// String price = input.next();
									i++;
									stop = 1;
									monitor.append("\n");
									output.print("\n");
								} catch (Exception e1) {
									System.out.println("tem error");
								}

							}
						}

						if (stop == 1) {
							output.close();
							break;
						}
					}
				} catch (Exception ee) {
					System.out.println("res error");
				}

			}

		});
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				s = foodf.getText();

				cheakD ob = new cheakD();
				int foodprice = ob.selectfood(s);
				if (foodprice == 0)
					JOptionPane.showMessageDialog(null,
							"This food will be available as soon as,Thanks for using our app");

				tk = tk + foodprice * q;
				String stotal = String.valueOf(tk);
				System.out.println(stotal);
				totala.setText(stotal);
				System.out.println(tk);
				q = 1;
				itemf.setText("1");
				// foodf.setText("");

			}
		});

		quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = foodf.getText();
				if (s.isEmpty())
					JOptionPane.showMessageDialog(null, "please select a food first");
				else {

					q++;
					String q1 = String.valueOf(q);
					itemf.setText(q1);
				}

			}
		});
		quantity2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = foodf.getText();
				if (s.isEmpty())

					JOptionPane.showMessageDialog(null, "please select a food . ");
				else {
					if (q <= 1) {
						JOptionPane.showMessageDialog(null, "You can't order less than 1 item", "Error Quantity",
								JOptionPane.INFORMATION_MESSAGE);
						q = 1;
						String q1 = String.valueOf(q);
						itemf.setText(q1);

					}

					else {
						q--;
						String q1 = String.valueOf(q);
						itemf.setText(q1);
					}

				}
			}
		});

		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartD ob = new cartD();
				ob.initialize(tk);

				tk = 0;
				dispose();
				ob.cart1();

			}
		});

	}

	public static void main(String[] args) {

		selectfood1();
	}

	public static void selectfood1() {
		selectfoodD frame = new selectfoodD();
		frame.setVisible(true);

	}
	// tk=10+20=
	// money=0;

}
