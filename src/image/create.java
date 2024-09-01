package image;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class create extends home {

	private JButton owner, customer, back;
	private Container c;

	create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 400, 600); // setLocation+setSize
		setTitle("create");
		setResizable(false);
		initComponent();
	}

	public void initComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);

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
				Owner ob = new Owner();
				dispose();
				ob.owner1();
			}
		});

		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customar ob = new customar();
				dispose();
				ob.customar1();
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

	public void create1() {
		create frame = new create();
		frame.setVisible(true);
	}
}



