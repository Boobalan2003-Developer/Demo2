package mypack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class Demo3 {

	JFrame jf;
	JLabel l1,l2,l3;
	JButton b1;
	JComboBox cb1;
	JRadioButton rb1,rb2;
	ButtonGroup bg1;
	JPanel jp1;
	TitledBorder tb1;
	
	void layoutControls()
	{
		
		//Frame Set-up..!
		jf = new JFrame("Erode Arts and Science College");
		
		int sw,sh;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		sw = (int)d.getWidth();
		sh = (int)d.getHeight();
		
		int fw = 400;
		int fh = 300;
		int x = (int)(sw-fw)/2;
		int y = (int)(sh-fh)/2;
		
		jf.setLayout(null);
		jf.setSize(fw,fh);
		jf.setLocation(x,y);
		//jf.getContentPane().setBackground(new Color(255,0,35,55));
		
		//Panel Set-up..!
		jp1 = new JPanel();
		jp1.setSize(200,80);
		tb1 = BorderFactory.createTitledBorder("Select The Login");
		jp1.setBorder(tb1);
		jp1.setLayout(null);
		//jp1.setBackground(new Color(255,0,35,55));
		
		
		//For find Center position Frame
		int pw = jp1.getWidth();
		int x1 = (int)(fw-pw)/2;
		jp1.setLocation(x1,70);
		
		jf.add(jp1);
		
		//Radio Button-1 Set-up..!
		rb1 = new JRadioButton("Administration");
		rb2 = new JRadioButton("Student");
		rb1.setSize(130,20);
		rb1.setLocation(10,20);
		
		//Radio Button-2 Set-up..!
		rb2.setSize(100,20);
		rb2.setLocation(10,50);
		jp1.add(rb1);
		jp1.add(rb2);
		
		//Button Group Set-up..!
		bg1 = new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		
		//Button Set-up..!
		b1 = new JButton("Log-in");
		b1.setSize(90,20);
		b1.setLocation(210,200);
		jf.add(b1);
	}
	
	void addListeners()
	{
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ButtonModel si = bg1.getSelection();
				if(si==rb1)
				{
					System.out.println("This is Administration Selection..!");
				}
				else
				{
					System.out.println("Error..!");
				}
			}
		});
	}
	
	void showFrame()
	{

		jf.setVisible(true);
	}
	
	Demo3()
	{
		layoutControls();
		addListeners();
		showFrame();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo3();
	}

}
