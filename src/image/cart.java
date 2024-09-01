package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class cart extends JFrame {
	private Container c;
	private Font f;
	private JLabel board;
	private JLabel toatal;
	private JLabel v;
	private JTextArea toatala;
	private JButton vc;
	private JButton yes,no,back,next;
	private JLabel m;
	private JComboBox cb;
	private String[] pytype = { "Cash on delivery", "Online Payment" };
	public static int totaltk;
	public static String s="null";
    public static String id, voucher, discount2="50", minimumamount2="100";
    private static String resname,resvoucher ,discount ,minimumamount;
   public static String stotal,voucheruser;
   public static int flag =0;
	
	public void initialize1(String id) {   //user id taken for user unique voucher
		System.out.println("unique :"+voucher);
		this.id=id;
		cheak ob = new cheak();
		voucher =ob.voucher(id);
		}
	public void initialize2(String resname) {  // restaurant name taken for restaurant voucher
		this.resname=resname;
		}
	
	//
	
public void initialize(int tk) {
		totaltk=tk;
}
	
	
	 
	
 
	public cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600);
		setTitle("cart");
		setResizable(false);
		
		initComponent();
	}
 
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		f = new Font("Arial", Font.BOLD, 20);
 
		toatal = new JLabel("Toatal Amount :");
		toatal.setBounds(20, 200, 150, 25);
		toatal.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(toatal);
 
		board = new JLabel("Payment Board :");
		board.setBounds(10, 20, 300, 205);
		board.setFont(new Font("Serif", Font.BOLD, 30));
		c.add(board);
 
		m = new JLabel("Payment ");
		m.setBounds(20, 350, 150, 25);
		m.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(m);
		
		toatal = new JLabel("Do you have any voucher");
		toatal.setBounds(20, 240, 250, 25);
		toatal.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(toatal);
 
		cb = new JComboBox(pytype);
		cb.setBounds(50, 380, 100, 25);
		cb.setEditable(true);
		c.add(cb);
 
		toatala = new JTextArea();
		toatala.setBounds(170, 200, 150, 25);
		toatala.setFont(f);
		c.add(toatala);
 
		yes = new JButton("Yes");
		yes.setBounds(50, 280, 100, 25);
		yes.setFont(f);
		c.add(yes);
		no = new JButton("No");
		no.setBounds(210, 280, 100, 25);
		no.setFont(f);
		c.add(no);
		
		back = new JButton("back");
		back.setBounds(50,460, 100, 25);
		back.setFont(f);
		c.add(back);
		next = new JButton("next");
		next.setBounds(250,460, 100, 25);
		next.setFont(f);
		c.add(next);
		
		stotal=String.valueOf(totaltk);
		toatala.setText(stotal);
		
 
		
 
//		toatala.addAncestorListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		    voucheruser = JOptionPane.showInputDialog("Type your voucher code :");
		    System.out.println(voucheruser);
		    
		    
			try {
				File file = new File("voucher.txt");
				 
				 Scanner input = new Scanner(file);
				
			
			
			   while (input.hasNext()) {
			   if(input.next().equals(resname)) {
				   resvoucher=input.next(); 
				   discount=input.next(); 
				   minimumamount=input.next();
				   
				   break;
			   }
			   
			   
			   }
			  
			 
			   input.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(voucheruser.equals(voucher) && flag==0) {
				if(totaltk>=100) {
					 JOptionPane.showInternalMessageDialog(null,"voucher successfully added and you got 50 tk");
					totaltk=totaltk-50;
					stotal=String.valueOf(totaltk);
					flag++;
					
				       toatala.setText(stotal);
					 System.out.println("total tk :"+totaltk);
				}
				else {
					JOptionPane.showMessageDialog(null,"please buy more than 100 TK");
				}
			}
			else if(voucheruser.equals(resvoucher) && flag ==0) {
				 Integer mnamount = Integer.valueOf(minimumamount);
				 Integer dis = Integer.valueOf(discount);
				 if(totaltk>=mnamount) {
					 JOptionPane.showInternalMessageDialog(null,"voucher successfully added and you got "+dis+" tk");
					 totaltk=totaltk-dis;
					  stotal=String.valueOf(totaltk);
					  flag++;
					  System.out.println(stotal);
					 toatala.setText(stotal);
				 }
					 
				 else
				 {
					 if(flag>0)
				  JOptionPane.showMessageDialog(null,"You already used a voucher code"); 
					 else
					 JOptionPane.showMessageDialog(null,"please buy more than "+mnamount+"TK");
				 }
				 
				 
			}
			
			
			
			
			
			
		  
		    
		
		
			}
		});
		
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  JOptionPane.showMessageDialog(null,"press ok to go next");
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    selectfood ob= new selectfood();
		    dispose();
		    ob.selectfood1();
			}
		});
		
		cb.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 s=cb.getSelectedItem().toString();
				
				///// tui ja korar kor
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 String a="Online Payment",b="Cash on delivery";
				 if(s.equals(a)) {
						OnlinePayment ob = new OnlinePayment();
						dispose();
						System.out.println("cash");
						 System.out.println(stotal);
						ob.initialize(stotal);
						ob.onlinepayment1();
						}
				else if(s.equals(b)) {
					dispose();
					lastpagecustomer ob = new lastpagecustomer();
					ob.lastpagecustomer1();					}
				else if (s.equals("null")) {
					
					JOptionPane.showMessageDialog(null,"Please select a payment method");
					System.out.println("else");
					s="null";
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
		cart frame = new cart();
		frame.setVisible(true);
 
	}
 
}
 

