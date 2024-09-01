package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class infoOwnerD extends JFrame {
	private Container c;
	private String s, ph, res, loca, opT, cloT1, vocr, miniamnt, dis;

	private Font f;
	private JLabel dt, discount;
	private JLabel user;
	private JLabel phnumber;
	private JLabel resturent;
	private JLabel addres;
	private JLabel opinT;
	private JLabel cloT;
	private JLabel voc;
	private JLabel minamunt;
	public JTextField userf;
	private JLabel Savel, Cleanl, Backl, Nextl;
	public JTextField phnumbef;
	public JTextField resturnNf;
	public JTextField addressf;

	public JTextField discountf;
	public JTextField opTf;
	private JTextField clseTf;
	private JTextField vocerf;
	public JTextField minamuntf;
	private JButton next, clear, back;
	private ImageIcon Clean, Back, Next;
	public static String x;

	public void initialize(String x) {
		this.x = x;

	}

	public infoOwnerD() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("info owner");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);

		dt = new JLabel("__Owner Information__");
		dt.setBounds(370, 20, 400, 25);
		dt.setFont(new Font("Serif", Font.BOLD, 35));
		dt.setForeground(Color.BLACK);
		c.add(dt);
		// Save = new ImageIcon(getClass().getResource("oke.png"));
		Clean = new ImageIcon(getClass().getResource("muca.png"));
		Back = new ImageIcon(getClass().getResource("bk.png"));
		Next = new ImageIcon(getClass().getResource("dana.png"));

		user = new JLabel("First Name :");
		user.setBounds(210, 70, 150, 25);
		user.setFont(f);
		c.add(user);

		phnumber = new JLabel("Phn Number :");
		phnumber.setBounds(210, 130, 150, 25);
		phnumber.setFont(f);
		c.add(phnumber);

		resturent = new JLabel("Resturent name :");
		resturent.setBounds(210, 200, 150, 25);
		resturent.setFont(f);
		c.add(resturent);

		addres = new JLabel("Addres :");
		addres.setBounds(210, 265, 150, 25);
		addres.setFont(f);
		c.add(addres);

		opinT = new JLabel("Opening Time :");
		opinT.setBounds(210, 330, 150, 25);
		opinT.setFont(f);
		c.add(opinT);

		cloT = new JLabel("Closing Time :");
		cloT.setBounds(210, 395, 150, 25);
		cloT.setFont(f);
		c.add(cloT);

		voc = new JLabel("Voucher Code :");
		voc.setBounds(210, 460, 150, 25);
		voc.setFont(f);
		c.add(voc);

		minamunt = new JLabel("Discount : ");
		minamunt.setBounds(210, 580, 150, 25);
		minamunt.setFont(f);
		c.add(minamunt);
		discount = new JLabel("Min. amnt. vcr ");
		discount.setBounds(210, 525, 150, 25);
		discount.setFont(f);
		c.add(discount);

		/// field start

		userf = new JTextField();
		userf.setBounds(440, 65, 400, 45);
		userf.setFont(f);
		c.add(userf);

		phnumbef = new JTextField("01");
		phnumbef.setBounds(440, 135, 400, 45);
		phnumbef.setFont(f);
		phnumbef.setForeground(Color.red);
		c.add(phnumbef);

		resturnNf = new JTextField();
		resturnNf.setBounds(440, 200, 400, 45);
		resturnNf.setFont(f);
		c.add(resturnNf);

		addressf = new JTextField();
		addressf.setBounds(440, 265, 400, 45);
		addressf.setFont(f);
		c.add(addressf);

		opTf = new JTextField("10 GMT(+6)");
		opTf.setBounds(440, 330, 400, 45);
		opTf.setFont(f);
		opTf.setForeground(Color.red);
		c.add(opTf);

		clseTf = new JTextField("23 GMT(+6)");
		clseTf.setBounds(440, 395, 400, 45);
		clseTf.setFont(f);
		clseTf.setForeground(Color.red);
		c.add(clseTf);

		vocerf = new JTextField();
		vocerf.setBounds(440, 460, 400, 45);
		vocerf.setFont(f);
		c.add(vocerf);

		minamuntf = new JTextField();
		minamuntf.setBounds(440, 580, 400, 45);
		minamuntf.setFont(f);
		c.add(minamuntf);

		discountf = new JTextField();
		discountf.setBounds(440, 525, 400, 45);
		discountf.setFont(f);
		c.add(discountf);

		next = new JButton(Next);
		next.setBounds(900, 670, 70, 70);
		c.add(next);

		clear = new JButton(Clean);
		clear.setBounds(550, 670, 70, 70);

		c.add(clear);

		back = new JButton(Back);
		back.setBounds(200, 670, 70, 70);

		back.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createD ob = new createD();
				dispose();
				ob.create1();
			}
		});
		/*
		 * next.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { foodadd ob =new foodadd();
		 * ob.initialize(res); ob.foodadd1(); // //calll login owner // ggg // ggg // //
		 * g } });
		 * 
		 */
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userf.setText("");
				phnumbef.setText("");
				resturnNf.setText("");
				addressf.setText("");
				opTf.setText("");
				clseTf.setText("");
				vocerf.setText("");
				minamuntf.setText("");

			}
		});

		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				File file = new File("infoowner.txt");
				FileOutputStream fos = null;
				File file1 = new File("voucher.txt");
				FileOutputStream fos1 = null;
				File file2 = new File("resname.txt");
				FileOutputStream fos2 = null;
				try {
					fos = new FileOutputStream(file, true);
					fos1 = new FileOutputStream(file1, true);
					fos2 = new FileOutputStream(file2, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write = new PrintWriter(fos);
				PrintWriter write1 = new PrintWriter(fos1);
				PrintWriter write2 = new PrintWriter(fos2);

				s = userf.getText();
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "you didn't enter any name");
					// infoOwner1();

				} else { // call cheak() for is anyone previously use this userid
					write.append(x + " " + "name" + " " + s);
					write.append("\n");

					ph = phnumbef.getText();

					if (ph.isEmpty() || ph.length() != 11) {
						JOptionPane.showMessageDialog(null, "Wrong phone number");

					} else {

						write.append(x + " " + "phone" + " " + ph);
						write.append("\n");

						res = resturnNf.getText();

						if (res.isEmpty()) {
							JOptionPane.showMessageDialog(null, "you didn't enter any address");

						} else {

							write.append(x + " " + "restaurant" + " " + res);
							write.append("\n");
							write2.append(res);
							write2.append("\n");

							loca = addressf.getText();
							if (loca.isEmpty()) {
								JOptionPane.showMessageDialog(null, "you didn't enter any address");
								// infoOwner1();
							} else {
								write.append(x + " " + "address" + " " + loca);
								write.append("\n");

								opT = opTf.getText();
								if (opT.isEmpty()) {
									JOptionPane.showMessageDialog(null, "you didn't enter any password");
									// infoOwner1();
								} else {
									write.append(x + " " + "openting" + " " + opT);
									write.append("\n");

									cloT1 = clseTf.getText();
									if (cloT1.isEmpty()) {
										JOptionPane.showMessageDialog(null, "you didn't enter any password");
										// infoOwner1();
									} else {
										// System.out.println("Enter resturent closing time ");
										write.append(x + " " + "closing" + " " + cloT1);
										write.append("\n");

										vocr = vocerf.getText();
										if (vocr.isEmpty()) {
											// JOptionPane.showMessageDialog(null,"you didn't enter any voucher code");
											// infoOwner1();
											write.append("null");
											write.append("\n");

										} else {
											// System.out.println("Enter voucher code ");
											write.append(x + " " + "voucher" + " " + vocr);
											write.append("\n");

											dis = discountf.getText();
											if (dis.isEmpty()) {
												JOptionPane.showMessageDialog(null,
														"you didn't enter any voucher code");
												// write1.append(res+" "+"null"+" "+"0");
												// write1.append("\n");
											} else {

												miniamnt = minamuntf.getText();
												if (miniamnt.isEmpty()) {
													JOptionPane.showMessageDialog(null,
															"you didn't enter any password");
													// infoOwner1();
												} else {
													// System.out.println("Enter min amunt for get voucher ");
													write.append(x + " " + "minimumorder" + " " + miniamnt);
													write.append("\n");
													write.append(x + "all" + " " + s + " " + loca + " " + ph + " " + res
															+ " " + opT + " " + cloT1 + " " + vocr + " " + miniamnt);
													write1.append(res + " " + vocr + " " + dis + " " + miniamnt);
													write1.append("\n");

													write.append("\n");
													JOptionPane.showMessageDialog(null, "your Deatials are saved");

													write.close();
													write1.close();
													write2.close();
													profileownerD ob = new profileownerD();

													ob.initialize(x);
													dispose();
													ob.profileowner1();
													try {
														fos.close();
													} catch (IOException e1) {

														e1.printStackTrace();
													}

												}

											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
	}

	public static boolean cheak(String str) {
		File f = new File("infoowner.txt");
		int c = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(str)) {
					c = 1;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("cheak error");
		}
		if (c == 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		infoOwner1();
	}

	public static void infoOwner1() {
		infoOwnerD frame = new infoOwnerD();
		frame.setVisible(true);

	}
}
