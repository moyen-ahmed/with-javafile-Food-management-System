package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class food extends JFrame {
	private Container c;
	private Font f,f1;
	private JLabel search;


	private JButton searchb,back,cart;
	private JTextArea searcha;
	
	food(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("owner create");
		setResizable(false);
		initComponent();
		
	}
	public void initComponent(){
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.gray);
		
		
	
		
		 
	
		
		
		
		
		
		

		f = new Font("Arial", Font.BOLD, 20);
		f1 = new Font("Arial", Font.BOLD,30);
		
		search = new JLabel("Click here to see all restaurant:");
		search.setBounds(10,10,300,25);
		search.setFont(f);
		c.add(search);
		
		searchb=new JButton("Click");
		searchb.setBounds(220,50,150,25);
		c.add(searchb);
		
		
		searcha=new JTextArea();
		searcha.setBounds(10,125,350,350);
		searcha.setFont(f1);
		searcha.setForeground(Color.magenta);
		searcha.setBackground(Color.pink);
		c.add(searcha);
		
		
		back=new JButton("Back");
		back.setBounds(10,500,150,25);
		back.setFont(f);
		c.add(back);
		
		cart=new JButton("Next");
		cart.setBounds(220,500,150,25);
		cart.setFont(f);
		c.add(cart);
		
		

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logincustomer ob= new logincustomer();
				dispose();
				ob.logincustomer1();
				
				
			}
		});
		//
		searcha.setText("");
		searchb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searcha.setText("");
				
				try {
				  File file = new File("resname.txt");
				 
				  
				   Scanner input;
				
					input = new Scanner(file);
				
				    int cnt =1;
				   while (input.hasNext()) {
				   String resname = input.next();
				   String numbering=String.valueOf(cnt);
				   searcha.append(numbering+".");
				   searcha.append(resname);
				   searcha.append("\n");
				   cnt++;
				  
				   }
				   input.close();
				}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		
		

		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectfood ob = new selectfood();
				dispose();
				
				ob.selectfood1();
				
			}
		});
		
		searcha=new JTextArea();
		searcha.setBounds(10,125,350,350);
		c.add(searcha);
		
		
}
	public static void main(String[] args) {
		food1();
	}
	
	
	
	public static void food1() {
		food frame = new food();
		frame.setVisible(true);
	}
}
