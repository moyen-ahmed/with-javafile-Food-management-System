package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class profileowner extends JFrame {
	private Container c;
	private Font f;
	private JLabel name ,resname,title,address,phone;
	private JTextArea namef,addressf,phonef,resnamef;
	private JButton logout ,edit,foodaddb,voucherb;
	private static String id="a";
	String namea,addressa,phonea,resnamea,vouchera,discounttka,minordertka;
	profileowner(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 250, 400, 600); // setLocation+setSize
		this.setTitle("owner profile ");
		this.setResizable(false);
		initComponent();
	}
	
	public void initialize(String id) {
		this.id=id;
	}
	
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);

		f = new Font("Arial", Font.BOLD, 20);
		
		
		title  = new JLabel("Your Profile");
		title.setBounds(120, 45, 150, 25);
	    title.setFont(f);
		title .setForeground(Color.blue);
		c.add(title);
		
		name = new JLabel("name");
		name.setBounds(15, 100, 150, 25);
		name.setFont(f);
		c.add(name);
		
		namef = new JTextArea();
		namef.setBounds(100, 100, 150, 25);
		namef.setFont(f);
		c.add(namef);
		
		address = new JLabel("Address");
		address.setBounds(15, 150, 150, 25);
		address.setFont(f);
		c.add(address);
		phone = new JLabel("Mobile");
		phone.setBounds(15, 200, 150, 25);
		phone.setFont(f);
		c.add(phone);
		
		addressf = new JTextArea();
		addressf.setBounds(100, 150, 150, 25);
		addressf.setFont(f);
		c.add(addressf);
		phonef = new JTextArea();
		phonef.setBounds(100, 200, 150, 25);
		phonef.setFont(f);
		c.add(phonef);
		
		resname = new JLabel("Restaurant");
		resname.setBounds(15, 250, 150, 25);
		resname.setFont(f);
		c.add(resname);
		resnamef = new JTextArea();
		resnamef.setBounds(125, 250, 150, 25);
		resnamef.setFont(f);
		c.add(resnamef);
		
		edit = new JButton("Edit");
		edit.setBounds(15, 300, 150, 25);
		edit.setFont(f);
		c.add(edit);
		
		logout = new JButton("Logout");
		logout.setBounds(15, 370, 150, 25);
		logout.setFont(f);
		c.add(logout);
		
		foodaddb = new JButton("Add Food");
		foodaddb.setBounds(200, 300, 150, 25);
		foodaddb.setFont(f);
		c.add(foodaddb);
		
		voucherb = new JButton("Vouchers");
		voucherb.setBounds(200, 370, 150, 25);
		voucherb.setFont(f);
		c.add(voucherb);
		
		
		
		FileOutputStream fos = null;
		cheak ob = new cheak();

		
		
		try {
		File file = new File("infoowner.txt");
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			
			String d= input.next();
			if(d.equals(id+"all")) {
				
				namea= input.next();
				addressa=input.next();
				phonea=input.next();
				resnamea =input.next();
				
				
				break;
			}
			
		 
		   }
		input.close();
		  
		
		   
		}catch(Exception e) {
			System.out.println("select food error");
		}
		
		namef.append(namea);
		addressf.append(addressa);
		phonef.append(phonea);
		resnamef.append(resnamea);
		
		
		foodaddb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			foodadd ob = new foodadd() ;
			dispose();
			ob.initialize(resnamea);
			ob.foodadd1();
				
		 }
		});
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home ob = new home();
			dispose();
			ob.start();
			

			}
		});
		
		
		
		
		
		}
public static void main(String[] args) {
	profileowner1();
}
	          
	public static void profileowner1() {
		profileowner frame = new profileowner();
		frame.setVisible(true);
	}
}

