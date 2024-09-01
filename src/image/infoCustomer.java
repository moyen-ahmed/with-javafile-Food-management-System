
package image;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class infoCustomer extends JFrame {
	private Container c;
	private Font f;
	private JLabel user,addres,phnumber,Deatil;
	
	public JTextField userf;
	private JTextField addresf;
	private JTextField phnumberf;
	private JButton save, clear, back;
	public static String x;
	
	public void initialize(String x) {
		this.x=x;
	}
 
	infoCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("owner create");
		setResizable(false);
		initComponent();
	}
 
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		f = new Font("Arial", Font.BOLD, 20);
 
		Deatil = new JLabel("***Customer Deatilas**** ");
		Deatil.setBounds(20, 100, 450, 50);
		Deatil.setFont(new Font("Serif", Font.BOLD, 30));
		Deatil.setForeground(Color.blue);
		c.add(Deatil);
 
		user = new JLabel("Full Name:");
		user.setBounds(20, 200, 150, 25);
		user.setFont(f);
		c.add(user);
 
		addres = new JLabel("Address");
		addres.setBounds(20, 250, 150, 25);
		addres.setFont(f);
		c.add(addres);
 
		phnumber = new JLabel("Phn Number");
		phnumber.setBounds(20, 300, 150, 25);
		phnumber.setFont(f);
		c.add(phnumber);
 
		userf = new JTextField();
		userf.setBounds(150, 200, 150, 25);
		userf.setFont(f);
		c.add(userf);
		addresf = new JTextField();
		addresf.setBounds(150, 250, 150, 25);
		addresf.setFont(f);
		c.add(addresf);
 
		phnumberf = new JTextField();
		phnumberf.setBounds(150, 300, 150, 25);
		phnumberf.setFont(f);
		c.add(phnumberf);
 
		save = new JButton("save");
		save.setBounds(190, 400, 150, 25);
		save.setFont(f);
		c.add(save);
		clear = new JButton("clear");
		clear.setBounds(10, 400, 150, 25);
		clear.setFont(f);
		c.add(clear);
		back = new JButton("back");
		back.setBounds(100, 450, 150, 25);
		back.setFont(f);
		c.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create ob = new create();
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
				
				
 
			        String s=userf.getText();
					write.append(x+" "+"name"+" "+s);
					write.append("\n");
				
					String p = addresf.getText();
					write.append(x+" "+"address"+" "+p);
					write.append("\n");
 
					String ph = phnumberf.getText();
					write.append(x+" "+"phone"+" "+ph);
					write.append("\n");
 
					write.append(x+"all"+" "+s + " " + p + " " + ph);
					write.append("\n");
					write1.append(x+" "+x+"tk50\n");
					JOptionPane.showMessageDialog(null, "your Deatials are saved");
					//System.out.println();
					//System.out.println("your user name is" + s);
					//System.out.println("your Address is " + p);
					//System.out.println("Your PhnNumber is" + ph);
					
					// infoowner ob=new infoowner();
					// ob.infoown(s);
					write.close();
					write1.close();
					//profilecustomer ob1 = new profilecustomer();
					logincustomer ob2 = new logincustomer();
					dispose();
					
					ob2.logincustomer1();
					//ob1.initialize(s, p, ph);
					
					//obb.profilecustomer1();
					
					
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
		infoCustomer frame = new infoCustomer();
		frame.setVisible(true);
 
	}
}
 
 