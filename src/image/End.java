package image;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
 
public class End extends JFrame {
	private Container c;
	private JLabel end, title, board;
	private JTextArea showdeatils;
	private JButton chat, home;
	private Font f;
	public static String name,address,phone,trans;
 
	
	public void initialize(String name ,String address, String phone,String trans) {
		this.name = name;
		this.address=address;
		this.phone = phone;
		this.trans=trans;
		
	}
	
	End() {
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
 
		board = new JLabel("Your Order Informaton");
		board.setBounds(50, 25, 350, 55);
		board.setFont(new Font("Serif", Font.BOLD,25));
		board.setForeground(Color.BLACK);
		c.add(board);
 
		showdeatils = new JTextArea();
		showdeatils.setBounds(10, 100, 350, 250);
		showdeatils.setFont(f);
		c.add(showdeatils);
		
 
		end = new JLabel("Have patience  Your food is comming Soon.....");
		end.setBounds(5, 445, 350, 25);
		end.setFont(new Font("Serif", Font.BOLD,17));
		end.setForeground(Color.BLACK);
		c.add(end);
 
		
 
		chat = new JButton("Chat");
		chat.setBounds(10, 400, 150, 35);
		chat.setForeground(Color.BLACK);
		chat.setFont(new Font("Serif", Font.BOLD, 20));
		chat.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(chat);
 
		home = new JButton("home");
		home.setBounds(200, 400, 150, 35);
		home.setForeground(Color.BLACK);
		home.setFont(new Font("Serif", Font.BOLD, 20));
		home.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(home);
		
		
		showdeatils.append("name : "+name+"\n");
		showdeatils.append("adress : "+address+"\n");
		showdeatils.append("phone  : "+phone+"\n");
		
		
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profilecustomer ob = new profilecustomer();
				dispose();
				ob.profilecustomer1();
 
			}
		});
 
	}
 
	public static void main(String[] args) {
		end1();
	}
 
	public static void end1() {
		End frame = new End();
		frame.setVisible(true);
	}
}
 
