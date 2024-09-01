package image;

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

public class selectfood extends JFrame {
	private Container c;
	private JLabel food, title, item, total;
	private JTextArea monitor, totala, itemf,foodpic;
	private JTextField foodf, searchf;
	private JButton cart, back, clear, more, select, quantity, quantity2, searchb;
	private Font f, f1;
	private ImageIcon img;
	public static int tk = 0, q = 1;
	public String q1;
	public String s;
	

	selectfood() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 800); // setLocation+setSize
		setTitle("Select food");
		setResizable(false);
		initComponent();

	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		f = new Font("Arial", Font.BOLD, 16);
		f1 = new Font("Serif", Font.ITALIC, 18);
		img = new ImageIcon(getClass().getResource("pizza.png"));
		

		title = new JLabel(" Search ");
		title.setBounds(20, 15, 70, 25);
		title.setFont(f);
		c.add(title);

		searchf = new JTextField();
		searchf.setBounds(100, 15, 120, 25);
		searchf.setFont(f);
		searchf.setForeground(Color.red);
		c.add(searchf);

		searchb = new JButton("search");
		searchb.setBounds(230, 15, 120, 25);
		searchb.setFont(f);
		searchb.setForeground(Color.red);
		c.add(searchb);

		monitor = new JTextArea();
		monitor.setBounds(10, 45, 350, 150);
		monitor.setFont(f1);
		monitor.setForeground(Color.darkGray);
		c.add(monitor);
		

		food = new JLabel("Select Food");
		food.setBounds(10, 205, 150, 25);
		food.setFont(f);
		c.add(food);

		foodf = new JTextField();
		foodf.setBounds(115, 205, 170, 25);
		foodf.setFont(f);
		foodf.setForeground(Color.red);
		c.add(foodf);

		item = new JLabel("Quantity");
		item.setBounds(10, 245, 150, 25);
		item.setFont(f);
		c.add(item);

		select = new JButton("Select");
		select.setBounds(288, 205, 85, 25);
		select.setFont(f);
		c.add(select);

		itemf = new JTextArea("1");
		itemf.setBounds(115, 245, 50, 25);
		itemf.setFont(f);
		c.add(itemf);

		total = new JLabel("Your total bill:");
		total.setBounds(10, 295, 150, 25);
		total.setFont(f);
		c.add(total);

		totala = new JTextArea("0.00");
		totala.setBounds(120, 295, 150, 25);
		totala.setFont(f);
		c.add(totala);

		back = new JButton("Back");
		back.setBounds(10, 415, 150, 25);
		c.add(back);

		clear = new JButton("clear");
		clear.setBounds(10, 335, 150, 25);
		c.add(clear);

		more = new JButton("add Food");
		more.setBounds(210, 335, 150, 25);
		c.add(more);

		cart = new JButton("Add to cart");
		cart.setBounds(210, 415, 150, 25);
		c.add(cart);

		quantity = new JButton("+");
		quantity.setBounds(180, 245, 45, 30);
		quantity.setFont(f);
		c.add(quantity);

		quantity2 = new JButton("-");
		quantity2.setBounds(230, 245, 45, 30);
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
				food ob = new food();
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
				cart ob = new cart();             /// passsing restant name to varify restaurant voucher
				ob.initialize2(restaurantname);
				if (restaurantname.isEmpty())
					JOptionPane.showMessageDialog(null, "please type a resturant name :");
				try {
					File file = new File("foodlist.txt");
					Scanner input = new Scanner(file);
					int c = 0, stop = 0;
					cheak ob1 = new cheak();

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
				
				
				
				cheak ob = new cheak();
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
				//foodf.setText("");

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
				cart ob = new cart();
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
		selectfood frame = new selectfood();
		frame.setVisible(true);
		
	}
	// tk=10+20=
	// money=0;

}
