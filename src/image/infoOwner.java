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

public class infoOwner extends JFrame {
	private String s,ph, res,loca, opT,cloT1,vocr,miniamnt,dis;
	private Container c;
	private Font f;
	private JLabel dt,last;
	private JLabel user;
	private JLabel phnumber;
	private JLabel resturent;
	private JLabel addres;
	private JLabel opinT;
	private JLabel cloT;
	private JLabel voc;
	private JLabel minamunt,discount;
	public JTextField userf;
	public JTextField phnumbef;
	public JTextField resturnNf;
	public JTextField addressf;
	public JTextField opTf;
	private JTextField clseTf;
	private JTextField vocerf;
	public JTextField minamuntf,discountf,lastf;
	private JButton save, clear, back, next;
	public static String x;
	
	public void initialize(String x) {
		this.x=x;
	}

	public infoOwner() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("Owner Deatils");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		f = new Font("Arial", Font.BOLD, 20);

		dt = new JLabel("__Owner Information__");
		dt.setBounds(20, 10, 400, 25);
		dt.setFont(new Font("Serif", Font.BOLD, 30));
		dt.setForeground(Color.blue);
		c.add(dt);
		user = new JLabel("First Name:");
		user.setBounds(20, 50, 150, 25);
		user.setFont(f);
		c.add(user);
		last = new JLabel("Last Name:");
		last.setBounds(19,80, 150, 25);
	    last.setFont(f);
		c.add(last);

		phnumber = new JLabel("Phn Number :");
		phnumber.setBounds(20,110, 150, 25);
		phnumber.setFont(f);
		c.add(phnumber);

		resturent = new JLabel("Resturent name :");
		resturent.setBounds(20, 140, 150, 25);
		resturent.setFont(f);
		c.add(resturent);

		addres = new JLabel("Addres :");
		addres.setBounds(20, 170, 150, 25);
		addres.setFont(f);
		c.add(addres);

		opinT = new JLabel("Opening Time :");
		opinT.setBounds(20, 200, 150, 25);
		opinT.setFont(f);
		c.add(opinT);

		cloT = new JLabel("Closing Time :");
		cloT.setBounds(20, 230, 150, 25);
		cloT.setFont(f);
		c.add(cloT);

		voc = new JLabel("Voucher Code :");
		voc.setBounds(20, 260, 150, 25);
		voc.setFont(f);
		c.add(voc);
		
		discount = new JLabel("discount :");
		discount.setBounds(20, 290, 150, 25);
		discount.setFont(f);
		//discount.setForeground(Color.blue);
		c.add(discount);

		minamunt = new JLabel("Min. amnt. vcr ");
		minamunt.setBounds(20, 330, 150, 25);
		minamunt.setFont(f);
		c.add(minamunt);

		/// field start

		userf = new JTextField();
		userf.setBounds(200, 50, 150, 25);
		userf.setFont(f);
		c.add(userf);
		
		lastf = new JTextField();
		lastf.setBounds(200, 80, 150, 25);
	    lastf.setFont(f);
		c.add(lastf);

		phnumbef = new JTextField("01");
		phnumbef.setBounds(200, 110, 150, 25);
		phnumbef.setFont(f);
		c.add(phnumbef);

		resturnNf = new JTextField();
		resturnNf.setBounds(200, 140, 150, 25);
		resturnNf.setFont(f);
		c.add(resturnNf);

		addressf = new JTextField();
		addressf.setBounds(200, 170, 150, 25);
		addressf.setFont(f);
		c.add(addressf);

		opTf = new JTextField();
		opTf.setBounds(200, 200, 150, 25);
		opTf.setFont(f);
		c.add(opTf);

		clseTf = new JTextField();
		clseTf.setBounds(200, 230, 150, 25);
		clseTf.setFont(f);
		c.add(clseTf);

		vocerf = new JTextField();
		vocerf.setBounds(200, 260, 150, 25);
		vocerf.setFont(f);
		c.add(vocerf);
		
		discountf = new JTextField();
		discountf.setBounds(200, 290, 150, 25);
		discountf.setFont(f);
		//discount.setForeground(Color.blue);
		c.add(discountf);

		minamuntf = new JTextField();
		minamuntf.setBounds(200, 330, 150, 25);
		minamuntf.setFont(f);
		c.add(minamuntf);

		save = new JButton("save");
		save.setBounds(190, 400, 150, 25);
		save.setFont(f);
		c.add(save);
		clear = new JButton("clear");
		clear.setBounds(10, 400, 150, 25);
		clear.setFont(f);
		c.add(clear);
		back = new JButton("back");
		back.setBounds(10, 450, 150, 25);
		back.setFont(f);
		c.add(back);
		next = new JButton("Next");
		next.setBounds(190, 450, 150, 25);
		next.setFont(f);
		c.add(next);
		
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create ob = new create();
				dispose();
				ob.create1();
			}
		});
		/*
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodadd ob =new foodadd();
				ob.initialize(res);
				ob.foodadd1();
//				//calll login owner 
//				ggg
//	ggg
//	
//	g
			}
		});

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
		
		
		
		save.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null,"you didn't enter any name");
					//infoOwner1();

				} else  { // call cheak() for is anyone previously use this userid
					write.append(x+" "+"name"+" "+s);
					write.append("\n");
					
				
				
					
					
					 
					 ph = phnumbef.getText();
					
					
					if(ph.isEmpty() || ph.length()!=11){
						JOptionPane.showMessageDialog(null,"Wrong phone number");
						
						//infoOwner1();
						
					}else {
					
					write.append(x+" "+"phone"+" "+ph);
					write.append("\n");
					
					
					
					
					
					 res = resturnNf.getText();
					
						if(res.isEmpty()) {
							JOptionPane.showMessageDialog(null,"you didn't enter any address");
							
						}
						else {
					
					write.append(x+" "+"restaurant"+" "+res);
					write.append("\n");
					write2.append(res);
					write2.append("\n");
				
						
					
                   
					 loca = addressf.getText();
					if(loca.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"you didn't enter any address");
						//infoOwner1();
					}
					else {
					write.append(x+" "+"address"+" "+loca);
					write.append("\n");
					
					
                    
                    
                   
					 opT = opTf.getText();
					if(opT.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"you didn't enter any password");
					//	infoOwner1();
					}
					else {
					write.append(x+" "+"openting"+" "+opT);
					write.append("\n");
				
					
                    
                    
                      
                   
					 cloT1 = clseTf.getText();
					if(cloT1.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"you didn't enter any password");
					//	infoOwner1();
					}
					else {
					//System.out.println("Enter resturent closing time ");
					write.append(x+" "+"closing"+" "+cloT1);
					write.append("\n");
					
					
					
                      
                    
                   
					 vocr = vocerf.getText();
					if(vocr.isEmpty())
					{
						//JOptionPane.showMessageDialog(null,"you didn't enter any voucher code");
					//	infoOwner1();
						write.append("null");
						write.append("\n");
						
						
					}
					else {
					//System.out.println("Enter voucher code ");
					write.append(x+" "+"voucher"+" "+vocr);
					write.append("\n");
					
					
					
					dis = discountf.getText();
					if(dis.isEmpty()) {
						JOptionPane.showMessageDialog(null,"you didn't enter any voucher code");
						//write1.append(res+" "+"null"+" "+"0");
						//write1.append("\n");
					}
					else {
						
						
				
					
                    
                   
					 miniamnt = minamuntf.getText();
					if(miniamnt.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"you didn't enter any password");
					//	infoOwner1();
					}
					else {
					//System.out.println("Enter min amunt for get voucher ");
					write.append(x+" "+"minimumorder"+" "+miniamnt);
					write.append("\n");
					write.append(x+"all"+" "+s + " "+loca+" "+ph+" " + res +" "+ opT + " " + cloT1 +" "+ vocr +" "
							+ miniamnt); 
					write1.append(res+" "+vocr+" "+dis+" "+ miniamnt);
					write1.append("\n");
					
					
                     

					// using for matching username and password in log in method()
					write.append("\n");
					JOptionPane.showMessageDialog(null,"your Deatials are saved");
					//System.out.println();
					//System.out.println("your user name is" + s);

					//System.out.println("Your PhnNumber is" + ph);
					//System.out.println("Al are saved");
					// infoowner ob=new infoowner();
					// ob.infoown(s);
					write.close();
					write1.close();
					write2.close();
					profileowner ob=new profileowner();
					
					ob.initialize(x);
					dispose();
					ob.profileowner1();
					try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				//} else // if previously use this user id
				//{
				//	System.out.println("it already booked.");
				//	dispose();
				///	// login custer......
			}
				
			}	}}}}}}}	}
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
		infoOwner frame = new infoOwner();
		frame.setVisible(true);

	}
}