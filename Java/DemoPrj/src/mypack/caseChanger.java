package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class caseChanger {
	
	JFrame jf = new JFrame("CHANGE THE CASE");
	JLabel title = new JLabel("CHANGE THE CASE");
	JLabel l1 = new JLabel("Enter a String: ");
	JLabel l2 = new JLabel("Changed Case: ");

	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	
	JButton b1 = new JButton("EXIT");
	
	
	void addListeners()
	{
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		t1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				String str = t1.getText();
				System.out.println(str.length());
			    
				if(str.compareTo("")==0)
				{
					JOptionPane.showMessageDialog(null, "Empty/spaces/Numbers or not Accepted..!","Input Mismatch Error..!",JOptionPane.INFORMATION_MESSAGE);
				}
				char ch;
			    for (int i = 0; i < str.length(); i++) 
			    {
			        ch = str.charAt(i);
			        
			        if (Character.isLowerCase(ch)) 
			        {
			        	t2.setText(str.toUpperCase());
			        } 
			        else if (Character.isUpperCase(ch)) 
			        {
			        	t2.setText(str.toLowerCase());
			        }
			    }
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	void LayoutControls()
	{
		jf.setLayout(null);
		jf.setSize(450,350);
		jf.setLocation(500,30);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		title.setSize(130,20);
		
		int fw = jf.getWidth();
		int tw = title.getWidth();
		int x=(fw-tw)/2;
		
		title.setLocation(x,20);
		jf.add(title);
		
		l1.setSize(200,20);
		l1.setLocation(75,120);
		jf.add(l1);
		
		t1.setSize(100,20);
		t1.setLocation(265,122);
		jf.add(t1);
		
		l2.setSize(200,20);
		l2.setLocation(75,160);
		jf.add(l2);
		
		t2.setSize(100,20);
		t2.setLocation(265,162);
		jf.add(t2);
		

		b1.setSize(200,20);
		int bw = b1.getWidth();
		int bx=(fw-bw)/2;
		b1.setLocation(bx,230);
		jf.add(b1);
		
		
	}
	void showFrame()
	{
		addListeners();
		LayoutControls();
	}
	
	caseChanger()
	{
		showFrame();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new caseChanger();
	}

}

