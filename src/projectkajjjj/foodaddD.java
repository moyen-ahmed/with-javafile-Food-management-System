package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class foodaddD extends JFrame {

	private Container c;
	private Font f;
	private JLabel bo, price;
	private JLabel add;
	private JLabel pass, p1, p2;
	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon log;
	public JTextField addf, pricef;
	private JPasswordField passf;
	private JButton ad, save, end, back, clear;
	public static String resname;
	public static int count = 0;

	public void initialize(String resname) {
		this.resname = resname;
	}

	foodaddD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Food add");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		f = new Font("Arial", Font.BOLD, 20);

		bo = new JLabel("Add Food Menu");
		bo.setBounds(380, 50, 400, 45);
		bo.setFont(new Font("Serif", Font.BOLD, 50));
		bo.setForeground(Color.BLACK);

		ic = new ImageIcon(getClass().getResource("hamburge.png"));
		ps = new ImageIcon(getClass().getResource("chicken.png"));
		ky = new ImageIcon(getClass().getResource("bk.png"));
		log = new ImageIcon(getClass().getResource("endin.png"));

		p2 = new JLabel(ps);
		p2.setBounds(890, 5, 140, 140);
		c.add(p2);
		c.add(bo);
		p1 = new JLabel(ic);
		p1.setBounds(70, 10, 140, 140);
		c.add(p1);

		price = new JLabel("Price        :");
		price.setBounds(290, 250, 350, 35);
		price.setFont(f);
		c.add(price);

		add = new JLabel("Add Book :");
		add.setBounds(290, 170, 150, 25);
		add.setFont(f);
		c.add(add);
		addf = new JTextField();
		addf.setBounds(400, 160, 280, 45);
		addf.setFont(f);
		c.add(addf);

		pricef = new JTextField();
		pricef.setBounds(400, 250, 280, 46);
		pricef.setFont(f);
		c.add(pricef);

		ad = new JButton("Add");
		ad.setBounds(750, 190, 170, 55);
		ad.setForeground(Color.BLACK);
		ad.setFont(new Font("Arial", Font.BOLD, 22));
		ad.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(ad);

		end = new JButton(log);
		end.setBounds(600, 345, 70, 70);
		c.add(end);

		back = new JButton(ky);

		back.setBounds(350, 345, 70, 70);
		c.add(back);

		ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File file = new File("foodlist.txt");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write = new PrintWriter(fos);
				if (count == 0) {
					write.append(resname + "start");
					write.append("\n");
				}

				String s = addf.getText();
				String p = pricef.getText();
				if (s.isEmpty()) {
					System.out.println("you disn't put any food");
				} else {
					write.append(s);
					write.append(" ");
					if (p.isEmpty()) {
						System.out.println("you disn't put any price");
					} else {
						write.append(p);
						write.append("\n");
						write.close(); // if need close use in the last
						count++;

					}
					addf.setText("");
					pricef.setText("");

				}

			}

		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeD ob = new HomeD();
				dispose();
				ob.start();

//				
			}
		});

		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("foodlist.txt");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write = new PrintWriter(fos);

				write.append(resname + "end");
				write.append("\n");
				write.close();
				count = 0;
				profileownerD ob = new profileownerD();
				dispose();
				ob.profileowner1();

//				
			}
		});

	}

	public static void main(String[] args) {
		foodadd1();

	}

	public static void foodadd1() {
		System.out.println(resname);
		foodaddD frame = new foodaddD();
		frame.setVisible(true);

	}
}
