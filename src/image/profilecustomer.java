package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class profilecustomer extends JFrame {
	private Container c;
	private Font f, f1;
	private JLabel name, address, phone, title;
	private JTextArea namef, addressf, phonef;
	private JButton edit, gotofood, logout, voucher;
	public  static String x="a";
	private static String n, add, ph;

//	public void initializeuserid(String i) throws Exception {
//		this.i=i;
//		find();
//	}

/*	public void find(int  line) {
 try {
			File file = new File("infoCustomer.txt");
			Scanner input;
			input = new Scanner(file);
			int e = 0;
			String arr[]=new String[3];
			while (input.hasNext())
             {
				e++;
				input.next();
				if(e==line) {
					arr[0]=input.next();
					arr[1]=input.next();
					arr[2]=input.next();
					initialize(arr[0],arr[1],arr[2]);
					break;
					}
				
				

			

		}} catch (FileNotFoundException e) {
			System.out.println("hello2");
			e.printStackTrace();
		}}
*/
	public void initialize(String x) {
		this.x = x;
		  
	}

	profilecustomer() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 250, 400, 600); // setLocation+setSize
		this.setTitle("profile customer ");
		this.setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);

		f = new Font("Arial", Font.BOLD, 20);
		f1 = new Font("Arial", Font.BOLD, 25);

		title = new JLabel("Your Profile");
		title.setBounds(120, 45, 150, 25);
		title.setFont(f1);
		title.setForeground(Color.blue);
		c.add(title);
		
		namef = new JTextArea();
		namef.setBounds(100, 100, 150, 25);
		namef.setFont(f);
		c.add(namef);
		addressf = new JTextArea();
		addressf.setBounds(100, 150, 150, 25);
		addressf.setFont(f);
		c.add(addressf);
		phonef = new JTextArea();
		phonef.setBounds(100, 200, 150, 25);
		phonef.setFont(f);
		c.add(phonef);

		name = new JLabel("name");
		name.setBounds(15, 100, 150, 25);
		name.setFont(f);
		c.add(name);
		address = new JLabel("Address");
		address.setBounds(15, 150, 150, 25);
		address.setFont(f);
		c.add(address);
		phone = new JLabel("Mobile");
		phone.setBounds(15, 200, 150, 25);
		phone.setFont(f);
		c.add(phone);
		edit = new JButton("Edit");
		edit.setBounds(15, 300, 150, 25);
		edit.setFont(f);
		c.add(edit);
		gotofood = new JButton("Order Food");
		gotofood.setBounds(200, 300, 150, 25);
		gotofood.setFont(f);
		c.add(gotofood);
		logout = new JButton("Logout");
		logout.setBounds(15, 370, 150, 25);
		logout.setFont(f);
		c.add(logout);
		voucher = new JButton("Vouchers");
		voucher.setBounds(200, 370, 150, 25);
		voucher.setFont(f);
		c.add(voucher);

		// File file = new File("customer.txt");
		FileOutputStream fos = null;
		cheak ob = new cheak();

		
		
		try {
		File file = new File("infoCustomer.txt");
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			
			String d= input.next();
			if(d.equals(x+"all")) {
				n= input.next();
				add=input.next();
				ph=input.next();
				input.close();
				break;
			}
			
		 
		   }
		  
		
		   
		}catch(Exception e) {
			System.out.println("select food error");
		}
		
		
		
		namef.append(n);
		addressf.append(add);
		phonef.append(ph);
		System.out.println(n+"\n"+add);
		
		
		
		
		

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home ob = new home();
				dispose();
				ob.start();
			}
		});
		
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		gotofood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				food ob = new food();
				dispose();
				ob.food1();
			}
		});
		cart ob4 = new cart();     ///passing user id to cart for doing vaoucher
		ob4.initialize1(x);
		
		voucher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheak ob1=new cheak();
				String v=ob1.voucher(x);
				
              JOptionPane.showMessageDialog(null,"your voucher code : "+v+"\nuse this to get 50 tk discount" );
				
			}
		});
		
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
              
				
			}
		});

	}
	public static void main(String[] args) {
		profilecustomer1();
	}

	public static void profilecustomer1() {
		profilecustomer frame = new profilecustomer();
		frame.setVisible(true);
	}
}
