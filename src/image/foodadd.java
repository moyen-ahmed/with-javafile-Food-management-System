package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class foodadd extends JFrame {
	 
	private Container c;
	private Font f;
	private JLabel bo,price;
	private JLabel add;
	private JLabel pass;
	public JTextField addf,pricef;
	private JPasswordField passf;
	private JButton ad, save, end, back, clear;
	public static String resname="a" ;
	public static int count=0;
	
	
	public void initialize(String resname) {
		this.resname=resname;
	}
 
	foodadd() {
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
		
		
 
		bo = new JLabel("**Add Food Menu**");
		bo.setBounds(70, 50, 350, 35);
		bo.setFont(new Font("Serif", Font.BOLD, 30));
		bo.setForeground(Color.blue);
		
	
		c.add(bo);
		
		price = new JLabel("Price");
		price.setBounds(10, 190, 350, 35);
		price.setFont(f);
		c.add(price);
 
		add = new JLabel("Add Food:");
		add.setBounds(10, 160, 150, 25);
		add.setFont(f);
		c.add(add);
		addf = new JTextField();
		addf.setBounds(110, 160, 130, 25);
		addf.setFont(f);
		c.add(addf);
		
		pricef = new JTextField();
		pricef.setBounds(110, 190, 130, 25);
		pricef.setFont(f);
		c.add(pricef);
		
		
		ad = new JButton("Add");
		ad.setBounds(250, 175, 130, 25);
		ad.setFont(f);
		c.add(ad);
		
		end = new JButton("End");
		end.setBounds(250, 260, 130, 25);
		end.setFont(f);
		c.add(end);
		
		back = new JButton("Logout");
		back.setBounds(10, 260, 130, 25);
		back.setFont(f);
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
				if(count==0) {
					write.append(resname+"start");
					write.append("\n");
				}
				
				String s = addf.getText();
				String p = pricef.getText();
				if (s.isEmpty()) {
					System.out.println("you disn't put any food");

				}  
				else{ 
			       write.append(s);
			       write.append(" ");

					 if (p.isEmpty()) {
							System.out.println("you disn't put any price");

						}  
						else{ 
					       write.append(p);
					       write.append("\n");
					        write.close();  // if need close use in the last
					        count++;
					       
					      
						}
					 addf.setText("");
					 pricef.setText("");
			       
			     
				}
				
				 
				 
				
			} 
				
			
				
			});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				home ob = new home();
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
				
				  write.append(resname+"end");
				  write.append("\n");
				  write.close();
				  count=0;
				  
				  profileowner ob=new profileowner();
				  dispose();
				  ob.profileowner1();
				  
				  
				  
				  
			       

					
				
			
				
//				
			}
		});
		
		
 
	}
 
	public static void main(String[] args) {
 
	foodadd1();
	
 
	}	public static void foodadd1() {
		System.out.println(resname);
		foodadd frame=new foodadd ();
		frame.setVisible(true);
		
		
	}
}

