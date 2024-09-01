package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class loginoption extends JFrame{
	private JButton owner, customer, back;
	private Container c;

	loginoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("log in Option");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.pink);

		owner = new JButton("Owner");
		owner.setBounds(20, 300, 150, 25);
		c.add(owner);

		customer = new JButton("customer");
		customer.setBounds(200, 300, 150, 25);
		c.add(customer);
		back = new JButton("back");
		back.setBounds(100, 400, 150, 25);
		c.add(back);

		owner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginowner ob = new loginowner();
				dispose();
				ob.loginowner1();
			}
		});
		

		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logincustomer ob = new logincustomer();
				dispose();
				ob.logincustomer1();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home ob = new home();
				dispose();
				ob.start();
			}
		});

	}

	public void loginoption1() {
		loginoption frame = new loginoption();
		frame.setVisible(true);
	}
	

}
