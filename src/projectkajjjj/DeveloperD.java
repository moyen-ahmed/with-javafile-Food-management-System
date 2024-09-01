
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

public class DeveloperD extends JFrame {

	private Container c;
	private JButton voucher, back;
	private Font f;
	private JLabel board, l, pial, pid, irfanid, moyenid, nirjonid, irfan, moyen, nirjon, tawsif, taesifid, nsu, in;
	private ImageIcon pialp, irfanp, moyenp, nirjonp, tawsifp;
//	private JButton deatials, back;

	public DeveloperD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 1200, 800); // setLocation+setSize
		setTitle("Developer");
		setResizable(false);
		setFont(new Font("Serif", Font.HANGING_BASELINE, 40));
		initComponent();
	}

	public void initComponent() {

		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(61, 200, 255));

		pial = new JLabel("Jalal Abedin pial");
		pial.setBounds(70, 220, 150, 25);
		pial.setFont(new Font("Serif", Font.BOLD, 20));
		pial.setForeground(Color.BLACK);
		c.add(pial);
		pial = new JLabel("Jalal Abedin pial");
		pial.setBounds(70, 220, 150, 25);
		pial.setFont(new Font("Serif", Font.BOLD, 20));
		pial.setForeground(Color.BLACK);
		c.add(pial);

		pid = new JLabel("ID:2211158642");
		pid.setBounds(100, 240, 150, 25);
		pid.setFont(new Font("Serif", Font.BOLD, 15));
		pid.setForeground(Color.BLACK);
		c.add(pid);

		irfan = new JLabel("Irfan Shah Mayeen");

		irfan.setBounds(255, 205, 250, 55);
		irfan.setFont(new Font("Serif", Font.BOLD, 20));
		irfan.setForeground(Color.BLACK);
		c.add(irfan);
		irfanid = new JLabel("ID:2122208642");

		irfanid.setBounds(275, 226, 250, 55);
		irfanid.setFont(new Font("Serif", Font.BOLD, 15));
		irfanid.setForeground(Color.BLACK);
		c.add(irfanid);

		moyen = new JLabel("Ishtiak Ahmed Moyen");
		moyen.setBounds(490, 200, 350, 55);
		moyen.setFont(new Font("Serif", Font.BOLD, 20));
		moyen.setForeground(Color.BLACK);
		c.add(moyen);
		moyenid = new JLabel("ID:2131580642");
		moyenid.setBounds(524, 220, 250, 55);
		moyenid.setFont(new Font("Serif", Font.BOLD, 15));
		moyenid.setForeground(Color.BLACK);
		c.add(moyenid);

		nirjon = new JLabel("Morsalin Hossain Nirjon");
		nirjon.setBounds(720, 200, 300, 55);
		nirjon.setFont(new Font("Serif", Font.BOLD, 20));
		nirjon.setForeground(Color.BLACK);
		c.add(nirjon);

		nirjonid = new JLabel("ID:2131488042");
		nirjonid.setBounds(740, 230, 300, 30);
		nirjonid.setFont(new Font("Serif", Font.BOLD, 15));
		nirjon.setForeground(Color.BLACK);
		c.add(nirjonid);

		tawsif = new JLabel("Tasbiul Hasan Towsif");

		tawsif.setBounds(960, 200, 250, 55);
		tawsif.setFont(new Font("Serif", Font.BOLD, 20));
		tawsif.setForeground(Color.BLACK);
		c.add(tawsif);
		taesifid = new JLabel("ID:2131741042");
		taesifid.setBounds(980, 220, 350, 55);
		taesifid.setFont(new Font("Serif", Font.BOLD, 15));
		taesifid.setForeground(Color.BLACK);
		c.add(taesifid);
		nsu = new JLabel("NORTH SOUTH UNIVERSITY");
		nsu.setBounds(300, 300, 700, 55);
		nsu.setFont(new Font("Serif", Font.BOLD, 45));
		nsu.setForeground(Color.BLACK);
		c.add(nsu);
		in = new JLabel("Instructed by:Monamy Islam");
		in.setBounds(450, 350, 500, 55);
		in.setFont(new Font("Serif", Font.BOLD, 30));
		in.setForeground(Color.BLACK);
		c.add(in);

		pialp = new ImageIcon(getClass().getResource("pial.png"));
		pial = new JLabel(pialp);
		pial.setBounds(30, 5, 210, 210);
		c.add(pial);

		irfanp = new ImageIcon(getClass().getResource("irfu.png"));
		irfan = new JLabel(irfanp);
		irfan.setBounds(260, 5, 210, 210);
		c.add(irfan);

		moyenp = new ImageIcon(getClass().getResource("moin.png"));
		moyen = new JLabel(moyenp);
		moyen.setBounds(490, 5, 210, 210);
		c.add(moyen);

		nirjonp = new ImageIcon(getClass().getResource("nirju.png"));
		nirjon = new JLabel(nirjonp);
		nirjon.setBounds(720, 5, 210, 210);
		c.add(nirjon);

		tawsifp = new ImageIcon(getClass().getResource("tawsif.png"));
		tawsif = new JLabel(tawsifp);
		tawsif.setBounds(950, 5, 210, 210);
		c.add(tawsif);
		voucher = new JButton("Add Voucher");
		voucher.setBounds(10, 500, 150, 35);
		voucher.setForeground(Color.black);
		voucher.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(voucher);

		back = new JButton("Back");
		back.setBounds(300, 500, 250, 35);
		back.setForeground(Color.black);
		back.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(back);

		voucher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file1 = new File("voucher.txt");
				FileOutputStream fos1 = null;
				try {

					fos1 = new FileOutputStream(file1, true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter write1 = new PrintWriter(fos1);
				String s = "monamy100";

				write1.append(s);
				write1.close();

			}
		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeD ob = new HomeD();
				ob.start();
			}
		});

	}

	public static void Developer1() {
		DeveloperD frame = new DeveloperD();
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		Developer1();
	}
}