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

public class infocustomerD extends JFrame {
	private Container c;
	private Font f;
	private JLabel user, addres, phnumber, Deatil;
	private ImageIcon us, add, phn, deat;

	public JTextField userf;
	private JTextField addresf;
	private JTextField phnumberf;
	private JButton save, clear, back;
	public static String x;

	public void initialize(String x) {
		this.x = x;

	}

	infocustomerD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("info customer");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));
		f = new Font("Arial", Font.BOLD, 20);

		us = new ImageIcon(getClass().getResource("namee.png"));
		add = new ImageIcon(getClass().getResource("loca.png"));
		phn = new ImageIcon(getClass().getResource("call.png"));
		deat = new ImageIcon(getClass().getResource("deat.png"));

		Deatil = new JLabel(deat);
		Deatil.setBounds(360, 5, 250, 250);
		c.add(Deatil);

		user = new JLabel(us);
		user.setBounds(210, 230, 80, 80);

		c.add(user);

		addres = new JLabel(add);
		addres.setBounds(220, 305, 80, 80);
		addres.setFont(f);
		c.add(addres);

		phnumber = new JLabel(phn);
		phnumber.setBounds(220, 400, 80, 80);
		phnumber.setFont(f);
		c.add(phnumber);

		userf = new JTextField();
		userf.setBounds(350, 260, 350, 45);
		userf.setFont(f);
		c.add(userf);
		addresf = new JTextField();
		addresf.setBounds(350, 350, 350, 45);
		addresf.setFont(f);
		c.add(addresf);

		phnumberf = new JTextField();
		phnumberf.setBounds(350, 420, 350, 45);
		phnumberf.setFont(f);
		c.add(phnumberf);

		save = new JButton("Save");
		save.setBounds(550, 510, 150, 60);
		save.setForeground(Color.black);
		save.setBackground(Color.getHSBColor(205, 255, 105));
		save.setFont(f);
		c.add(save);
		clear = new JButton("Clear");
		clear.setBounds(420, 620, 150, 60);
		clear.setForeground(Color.black);
		clear.setBackground(Color.getHSBColor(205, 255, 105));
		clear.setFont(f);
		c.add(clear);
		back = new JButton("Back");
		back.setBounds(300, 510, 150, 60);
		back.setForeground(Color.black);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		back.setFont(f);
		c.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createD ob = new createD();
				dispose();
				ob.create1();
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userf.setText(" ");
				addresf.setText("");
				phnumberf.setText("");
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				File file = new File("infoCustomer.txt");
				File file1 = new File("voucher.txt");
				FileOutputStream fos = null;
				FileOutputStream fos1 = null;
				try {
					fos = new FileOutputStream(file, true);
					fos1 = new FileOutputStream(file1, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write = new PrintWriter(fos);
				PrintWriter write1 = new PrintWriter(fos1);

				String s = userf.getText();
				write.append(x + " " + "name" + " " + s);
				write.append("\n");

				String p = addresf.getText();
				write.append(x + " " + "address" + " " + p);
				write.append("\n");

				String ph = phnumberf.getText();
				write.append(x + " " + "phone" + " " + ph);
				write.append("\n");

				write.append(x + "all" + " " + s + " " + p + " " + ph);
				write.append("\n");
				write1.append(x + " " + x + "tk50\n");
				JOptionPane.showMessageDialog(null, "your Deatials are saved");
				// System.out.println();
				// System.out.println("your user name is" + s);
				// System.out.println("your Address is " + p);
				// System.out.println("Your PhnNumber is" + ph);

				// infoowner ob=new infoowner();
				// ob.infoown(s);
				write.close();
				write1.close();
				// profilecustomer ob1 = new profilecustomer();
				logincustomerD ob2 = new logincustomerD();
				dispose();

				ob2.logincustomer1();
				// ob1.initialize(s, p, ph);

				// obb.profilecustomer1();

				try {
					fos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
	}

	public static boolean cheak(String str) {
		File f = new File("infocustomer.txt");
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
		infoCustomer1();
	}

	public static void infoCustomer1() {
		infocustomerD frame = new infocustomerD();
		frame.setVisible(true);

	}
}
