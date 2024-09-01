package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class lastpagecustomer extends JFrame {
	private Container c;
	private Font f;
	private JButton back,save,next;
	private JLabel name,address,ph,board;
	private JTextField namef,addressf,phf;
	
	

	
	
	lastpagecustomer(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600);
		setTitle("Online Payment");
		setResizable(false);
		initComponent();
	}
	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);
		
		f = new Font("Arial", Font.BOLD, 20);
		
		
		board = new JLabel("Order Location");
		board.setBounds(100, 15, 150, 25);
		board.setFont(new Font("Serif", Font.BOLD, 18));
		board.setForeground(Color.BLACK);
		c.add(board);
 
 
		name = new JLabel("Name     :");
		name.setBounds(10, 55, 150, 25);
		name.setFont(new Font("Serif", Font.BOLD, 18));
		name.setForeground(Color.BLACK);
		c.add(name);
 
		namef = new JTextField();
		namef.setBounds(135, 55, 170, 25);
		namef.setFont(f);
		c.add(namef);
 
		address = new JLabel("Address :");
		address.setBounds(10,120, 130, 25);
		address.setFont(new Font("Serif", Font.BOLD, 18));
		address.setForeground(Color.BLACK);
		c.add(address);
 
		addressf = new JTextField();
		addressf.setBounds(135, 120, 170, 25);
		addressf.setFont(f);
		c.add(addressf);
 
		ph = new JLabel("Number:");
		ph.setBounds(10,170, 150, 25);
		ph.setFont(new Font("Serif", Font.BOLD, 18));
		ph.setForeground(Color.BLACK);
		c.add(ph);
		phf = new JTextField("01");
		phf.setBounds(135, 170, 170, 25);
		phf.setFont(f);
		c.add(phf);
		
		
		
		
		
		
		next = new JButton("Next");
		next.setBounds(200, 300, 150, 35);
		next.setForeground(Color.BLACK);
		next.setBackground(Color.getHSBColor(205, 255, 105));
		next.setFont(new Font("Serif", Font.BOLD, 20));
		c.add(next);
 
		back = new JButton("Back");
		back.setBounds(10,300, 150, 35);
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Serif", Font.BOLD, 20));
		back.setBackground(Color.getHSBColor(205, 255, 105));
		c.add(back);
		
		String namea="null",addressa="null",pha="null";
		namea=namef.getText();
		addressa=addressf.getText();
		pha=phf.getText();
		System.out.println(namea);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (namef.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"you didn't enter any name");
					

				} else  { 
					    if(addressf.getText().isEmpty()) {
					    	JOptionPane.showMessageDialog(null,"you didn't enter your Location");
					    }
					    else {
					    	  if(phf.getText().isEmpty() || phf.getText().length()!=11) {
					    		  JOptionPane.showMessageDialog(null,"Wrong phone number");
					    	  }
					    	  else {
					    		  End ob = new End();
					    		  ob.initialize(namef.getText(),addressf.getText(),phf.getText(),"9LI4T75S6"+namef.getText());
					    		  ob.end1();
					    	  }
					    }
					
				}
			

			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			JOptionPane.showMessageDialog(null,"please select your order location");
			

			}
		});
		
 



	}
	
	
	
	
	public static void main(String[] args) {
		lastpagecustomer1();
	}
	public static void lastpagecustomer1(){
		lastpagecustomer frame = new lastpagecustomer();
		frame.setVisible(true);
	}
}
