package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class chat extends JFrame {
	private Container c;
	private JLabel board,text;
	public static  JTextArea showdeatils;
	public static JTextField chatf;
	private JButton logout, send;
	private Font f;
	
	public static String secret="";
	public void set(String s) {
		showdeatils.append(s);
		showdeatils.append("\n");
		secret =showdeatils.getText();
		dispose();
		chat1();
		
	}
 
	chat() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 250, 400, 600); // setLocation+setSize
		this.setTitle("profile customer ");
		this.setResizable(false);
		initComponent();
	}
 
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
 
		c.setBackground(new Color(61, 200, 255));
 
		f = new Font("Arial", Font.BOLD, 20);
 
		board = new JLabel("Chat");
		board.setBounds(140, 1, 150, 35);
		board.setFont(new Font("Serif", Font.BOLD, 35));
		board.setForeground(Color.BLACK);
		c.add(board);
 
		
// 
//		chatf = new JTextField();
//		chatf.setBounds(100, 365, 250, 25);
//		chatf.setFont(f);
//		c.add(chatf);
		
		

 
		text = new JLabel("Text");
		text.setBounds(10, 365, 80, 25);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Serif", Font.BOLD, 25));
		text.setForeground(Color.RED);
		text.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(text);
		
		send = new JButton("Send");
		send.setBounds(150, 400, 80, 25);
		send.setForeground(Color.BLACK);
		send.setFont(new Font("Serif", Font.BOLD, 20));
		send.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(send);
		
		showdeatils = new JTextArea(secret);
		showdeatils.setBounds(10, 50, 350, 300);
				
		showdeatils.setForeground(Color.BLACK);
		showdeatils.setFont(new Font("Serif", Font.BOLD, 20));
		showdeatils.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(showdeatils);
		

 
		logout = new JButton("logout");
		logout.setBounds(146, 450, 90, 25);
		logout.setForeground(Color.BLACK);
		logout.setFont(new Font("Serif", Font.BOLD, 20));
		logout.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(logout);
		
		
		
 
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             home ob = new home();
             dispose();
             ob.start();
			}
		});
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user obj=new user();
				new Thread("Miraz : ")
				{
				public void run()
				{
				obj.miraz();
				}
				}.start();
				new Thread("Sibbir : ")
				{
				public void run()
				{
				obj.sibbir();
				}
				}.start();
				
				
			}	
             
			
		});
 
	}
 
	public static void main(String[] args) {
		chat1();
	}
 
	public static void chat1() {
		chat frame = new chat();
		frame.setVisible(true);
	}
}



////


class user extends chat{
	
	
public static String msg;
synchronized void miraz()
{
	
	
	
	
int i=0;
while(true)
{
	//Scanner sc1= new Scanner(System.in);
	String msg = JOptionPane.showInputDialog("text to delivery boy");
	if(msg.equals("bye")) {
		//showdeatils.append(Thread.currentThread().getName()+msg+"\n");
		System.out.println(Thread.currentThread().getName()+msg);
		set(Thread.currentThread().getName()+msg);
		//showdeatils.append("miraz left the chatroom\n");
		System.out.println("miraz left the chatroom");
		set("miraz left the chatroom");
		notify();
		break;
	}
	//showdeatils.setText(Thread.currentThread().getName()+msg+"\n");
System.out.println(Thread.currentThread().getName()+msg);
set(Thread.currentThread().getName()+msg);
if(i!=0)
{
notify();
}
try
{
wait();
i++;
}
catch(Exception e) {}
}
}
synchronized void sibbir()
{
	int i=0;
//Scanner sc3 = new Scanner(System.in);
while(true)
{
	
	
	String msg = JOptionPane.showInputDialog("Text to customer"); 
	if(msg.equals("bye")) {
		//showdeatils.append(Thread.currentThread().getName()+msg+"\n");
		System.out.println(Thread.currentThread().getName()+msg);
		set(Thread.currentThread().getName()+msg);
		//showdeatils.append("miraz left the chatroom\n");
		System.out.println("\nsibbir left the chatroom");
		set("sibbir left the chatroom");
		notify();
		break;
	}
	//showdeatils.append(Thread.currentThread().getName()+msg+"\n");
System.out.println(Thread.currentThread().getName()+msg);
set(Thread.currentThread().getName()+msg);
notify();
try
{
wait();
i++;
}
catch(Exception e) {}
}
}
}
 

