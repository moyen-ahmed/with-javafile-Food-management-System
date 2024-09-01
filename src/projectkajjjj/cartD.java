package projectkajjjj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class cartD extends JFrame {
	private Container c;
	private Font f;
	private JLabel board, pay, tak, toatal;

	private ImageIcon ic;
	private ImageIcon ps;
	private ImageIcon ky;
	private ImageIcon lo;
	private JLabel v;
	private JTextArea toatala;
	private JButton vc;
	private JButton yes, no, back, next;
	private JLabel m;
	private JComboBox cb;
	private String[] pytype = { "Select", "Cash on delivery", "Online Payment" };
	public static int totaltk;
	public static String s = "null";
	public static String id, voucher, discount2 = "50", minimumamount2 = "100";
	private static String resname, resvoucher, discount, minimumamount;
	private static String stotal, voucheruser;
	private static int flag = 0;

	public void initialize1(String id) { // user id taken for user unique voucher
		// System.out.println("unique :" + voucher);
		this.id = id;
		cheakD ob = new cheakD();
		voucher = ob.voucher(id);
	}

	public void initialize2(String resname) { // restaurant name taken for restaurant voucher
		this.resname = resname;
	}

	//

	public void initialize(int tk) {
		totaltk = tk;
	}

	public cartD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800);
		setTitle("cartD");
		setResizable(false);

		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);

		toatal = new JLabel("Toatal Amount :");
		toatal.setBounds(330, 250, 150, 25);
		toatal.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(toatal);
		ic = new ImageIcon(getClass().getResource("payment.png"));
		ps = new ImageIcon(getClass().getResource("vsa.png"));
		ky = new ImageIcon(getClass().getResource("taka.png"));
		// lo = new ImageIcon(getClass().getResource("taka.png"));

		board = new JLabel(ic);
		board.setBounds(470, 5, 300, 205);
		c.add(board);

		v = new JLabel(ps);
		v.setBounds(800, 190, 300, 205);
		c.add(v);
		tak = new JLabel(ky);
		tak.setBounds(820, 500, 300, 205);
		c.add(tak);

		m = new JLabel("Payment          : ");
		m.setBounds(330, 450, 150, 25);
		m.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(m);
		toatal = new JLabel("Do you have any voucher code :");
		toatal.setBounds(330, 340, 350, 25);
		toatal.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(toatal);

		cb = new JComboBox(pytype);
		cb.setBounds(390, 490, 150, 35);
		cb.setForeground(Color.BLACK);
		cb.setBackground(Color.BLUE);
		cb.setEditable(true);
		c.add(cb);

		toatala = new JTextArea();
		toatala.setBounds(520, 250, 300, 40);

		toatala.setFont(f);
		c.add(toatala);

		yes = new JButton("Yes");
		yes.setBounds(750, 400, 150, 35);
		yes.setForeground(Color.BLACK);
		yes.setBackground(Color.getHSBColor(205, 255, 105));
		yes.setFont(f);
		c.add(yes);
		no = new JButton("No");
		no.setBounds(550, 400, 150, 35);
		no.setForeground(Color.BLACK);
		no.setBackground(Color.getHSBColor(205, 255, 105));
		no.setFont(f);
		c.add(no);

		back = new JButton("back");
		back.setBounds(550, 560, 150, 35);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(f);
		c.add(back);
		next = new JButton("next");
		next.setBounds(750, 560, 150, 35);
		next.setForeground(Color.BLACK);
		next.setBackground(Color.getHSBColor(205, 255, 105));

		next.setFont(f);
		c.add(next);

		stotal = String.valueOf(totaltk);
		toatala.setText(stotal);

		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				voucheruser = JOptionPane.showInputDialog("Type your voucher code :");
				System.out.println(voucheruser);

				try {
					File file = new File("voucher.txt");

					Scanner input = new Scanner(file);

					while (input.hasNext()) {
						if (input.next().equals(resname)) {
							resvoucher = input.next();
							discount = input.next();
							minimumamount = input.next();

							break;
						}

					}

					input.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (voucheruser.equals(voucher) && flag == 0) {
					if (totaltk >= 100) {
						JOptionPane.showInternalMessageDialog(null, "voucher successfully added and you got 50 tk");
						totaltk = totaltk - 50;
						stotal = String.valueOf(totaltk);
						flag++;

						toatala.setText(stotal);
						System.out.println("total tk :" + totaltk);
					} else {
						JOptionPane.showMessageDialog(null, "please buy more than 100 TK");
					}
				} else if (voucheruser.equals(resvoucher) && flag == 0) {
					Integer mnamount = Integer.valueOf(minimumamount);
					Integer dis = Integer.valueOf(discount);
					if (totaltk >= mnamount) {
						JOptionPane.showInternalMessageDialog(null,
								"voucher successfully added and you got " + dis + " tk");
						totaltk = totaltk - dis;
						stotal = String.valueOf(totaltk);
						flag++;
						System.out.println(stotal);
						toatala.setText(stotal);
					}

					else {
						if (flag > 0)
							JOptionPane.showMessageDialog(null, "You already used a voucher code");
						else
							JOptionPane.showMessageDialog(null, "please buy more than " + mnamount + "TK");
					}

				}

			}
		});

		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "press ok to go next");
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectfoodD ob = new selectfoodD();
				dispose();
				ob.selectfood1();
			}
		});

		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				s = cb.getSelectedItem().toString();

				///// tui ja korar kor
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = "Online Payment", b = "Cash on delivery";
				if (s.equals(a)) {
					onlinePaymentD ob = new onlinePaymentD();
					dispose();
					System.out.println("cash");
					System.out.println(stotal);
					ob.initialize(stotal);
					ob.onlinepayment1();
				} else if (s.equals(b)) {
					dispose();
					lastpagecustomeD ob = new lastpagecustomeD();
					dispose();
					ob.lastpagecustomer1();
				} else if (s.equals("null")) {

					JOptionPane.showMessageDialog(null, "Please select a payment method");
					System.out.println("else");
					s = "null";
					dispose();
					cart1();
				}

			}
		});

	}

	public static void main(String[] args) {
		cart1();
	}

	public static void cart1() {
		cartD frame = new cartD();
		frame.setVisible(true);

	}

}
