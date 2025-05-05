package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ArithmaticCalculator {

	JFrame jf = new JFrame();
	JLabel l1 = new JLabel("SIMPLE ARITHMATIC CALCULATOR");
	JLabel l2 = new JLabel("Enter Input 1 (Number):");
	JLabel l3 = new JLabel("Enter Input 2 (Number):");
	JLabel l4 = new JLabel("Output: ");
	
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(10);
	
	JButton b1= new JButton("ADD (+)");
	JButton b2= new JButton("SUB (-)");
	JButton b3= new JButton("MUL (*)");
	JButton b4= new JButton("DIV (/)");
	JButton b5= new JButton("RESET");
	JButton b6= new JButton("CLOSE");
	
	
	
	void layoutControls()
	{
		jf.setSize(600,400);
		jf.setLocation(510,30);
		jf.setTitle("Simple Calculator");
		jf.setLayout(null);
		jf.setVisible(true);
		
		l1.setSize(250,20);
		int fw=jf.getWidth();
		int tw=l1.getWidth();
		int x=(fw-tw)/2;
		l1.setLocation(x,20);
		jf.add(l1);
		
		
		l2.setSize(190,50);
		l2.setLocation(150,60);
		jf.add(l2);
		
		t1.setSize(80,20);
		t1.setLocation(310,78);
		jf.add(t1);
		
		l3.setSize(190,50);
		l3.setLocation(150,95);
		jf.add(l3);
		
		t2.setSize(80,20);
		t2.setLocation(310,113);
		jf.add(t2);
		
		l4.setSize(190,50);
		l4.setLocation(150,125);
		jf.add(l4);
		
		t3.setSize(80,20);
		t3.setLocation(310,138);
		jf.add(t3);
		
		
		b1.setSize(80,20);
		b1.setLocation(20,218);
		jf.add(b1);
		
		b2.setSize(80,20);
		b2.setLocation(110,218);
		jf.add(b2);
		
		b3.setSize(80,20);
		b3.setLocation(200,218);
		jf.add(b3);
		
		b4.setSize(80,20);
		b4.setLocation(290,218);
		jf.add(b4);
		
		b5.setSize(80,20);
		b5.setLocation(380,218);
		jf.add(b5);
		
		b6.setSize(80,20);
		b6.setLocation(470,218);
		jf.add(b6);
	}
	
	void addListener()
	{
		//Addition operation..!
				b1.addActionListener(new ActionListener() {
			
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String inp1,inp2,op;
					
					inp1 = t1.getText();
					inp2 = t2.getText();
					
					if((inp1.compareTo("")==0) && (inp2.compareTo("")==0))
					{
						t1.setText("");
						t2.setText("");
						JOptionPane.showMessageDialog(null, "Please fills all the Input Fields..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
					} 
					else if(inp1.compareTo("")==0)
					{
						JOptionPane.showMessageDialog(null, "Please fill the 1st Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(inp2.compareTo("")==0)
					{
						JOptionPane.showMessageDialog(null, "Please fills 2nd Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else
					{
						int input1,input2,output;
						try 
						{
							input1 = Integer.parseInt(inp1);
							input2 = Integer.parseInt(inp2);
							output = input1+input2;
							op = String.valueOf(output);
						
							t3.setText(op);
						}
						catch(NumberFormatException nfa)
						{
							JOptionPane.showMessageDialog(null, "Empty/Space/Letters are not Accepted.Please Give the Number..!", "Error Occured..!", JOptionPane.INFORMATION_MESSAGE);
							t1.setText("");	
							t2.setText("");
							t3.setText("");
						}
					}
				}
			});
				//Subtraction operation..!
				b2.addActionListener(new ActionListener() {
					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String inp1,inp2,op;
						
						inp1 = t1.getText();
						inp2 = t2.getText();
						
						if(inp1.compareTo("")==0 && inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills all the Input Fields..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp1.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fill the 1st Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills 2nd Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						
						else
						{
							int input1,input2,output;
							try 
							{
								input1 = Integer.parseInt(inp1);
								input2 = Integer.parseInt(inp2);
								output = input1-input2;
								op = String.valueOf(output);
							
								t3.setText(op);
							}
							catch(NumberFormatException nfa)
							{
								JOptionPane.showMessageDialog(null, "Empty/Space/Letters are not Accepted.Please Give the Number..!", "Error Occured..!", JOptionPane.INFORMATION_MESSAGE);
								t1.setText("");	
								t2.setText("");
								t3.setText("");
							}
						}	
					}
				});
				
				//Multiplication operation..!
				b3.addActionListener(new ActionListener() {
					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String inp1,inp2,op;
						
						inp1 = t1.getText();
						inp2 = t2.getText();
						
						if(inp1.compareTo("")==0 && inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills all the Input Fields..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp1.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fill the 1st Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills 2nd Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						
						else
						{
							int input1,input2,output;
							try 
							{
								input1 = Integer.parseInt(inp1);
								input2 = Integer.parseInt(inp2);
								output = input1*input2;
								op = String.valueOf(output);
							
								t3.setText(op);
							}
							catch(NumberFormatException nfa)
							{
								JOptionPane.showMessageDialog(null, "Empty/Space/Letters are not Accepted.Please Give the Number..!", "Error Occured..!", JOptionPane.INFORMATION_MESSAGE);
								t1.setText("");	
								t2.setText("");
								t3.setText("");
							}
						}	
					}
				});
				
				//Division operation..!
				b4.addActionListener(new ActionListener() {
								
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String inp1,inp2,op;
						
						inp1 = t1.getText();
						inp2 = t2.getText();
						
						if(inp1.compareTo("")==0 && inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills all the Input Fields..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp1.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fill the 1st Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(inp2.compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Plese fills 2nd Input Field..!", "Input Mismatch Error", JOptionPane.INFORMATION_MESSAGE);
						}
						
						else
						{
							int input1,input2;
							float output;
							try 
							{
								input1 = Integer.parseInt(inp1);
								input2 = Integer.parseInt(inp2);
								
								if(input2 == 0)
								{
									JOptionPane.showMessageDialog(null,"Divided by Number is ZERO. It's Not Acceptable. please give the positive or negative Natural numbers","Input MisMatch Error..!",JOptionPane.INFORMATION_MESSAGE);
								}
								output = input1/input2;
								op = String.valueOf(output);
							
								t3.setText(op);
							}
							catch(NumberFormatException nfa)
							{
								JOptionPane.showMessageDialog(null, "Empty/Space/Letters are not Accepted.Please Give the Number..!", "Error Occured..!", JOptionPane.INFORMATION_MESSAGE);
								t1.setText("");	
								t2.setText("");
								t3.setText("");
							}	
						}
					}
				});
				
				//Reset operation..!
				b5.addActionListener(new ActionListener() {
						
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t1.setText("");	
						t2.setText("");
						t3.setText("");
					}
				});
			
				//Exit operation..!
				b6.addActionListener(new ActionListener() {
					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
	}
	void showFrame()
	{
		layoutControls();
		addListener();
	}
	public ArithmaticCalculator()
	{
		showFrame();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArithmaticCalculator();
	}
}
