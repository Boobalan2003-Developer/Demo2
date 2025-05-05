package mypack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ArithmeticDemo {
    JFrame jf;
    JLabel l1,l2,l3,title;
    JTextField t1,t2,t3;
    JButton b1,b2,b3,b4,b5,b6;
    
	void Controls()
	{
		jf=new JFrame("ARITHMETIC CALCULATION");
		title=new JLabel("ARITHMETIC CALCULATION");
		l1=new JLabel("Enter the First input");
		l2=new JLabel("Enter the Second input");
		l3=new JLabel("The output value");
    	t1=new JTextField(30);
    	t2=new JTextField(30);
    	t3=new JTextField(30);
		b1=new JButton("ADD");
		b2=new JButton("SUB");
		b3=new JButton("MUL");
		b4=new JButton("DIV");
		b5=new JButton("RESET");
		b6=new JButton("EXIT");	
	}
	void Addtocontrols()
	{
		jf.setLayout(null);
		jf.setLocation(800,100);
		jf.setSize(600,300);
		
		title.setLocation(200,20);
		title.setSize(190,50);
		jf.add(title);
		
		l1.setLocation(100,50);
		l1.setSize(200,80);
		jf.add(l1);
		
		l2.setLocation(100,80);
		l2.setSize(200,80);
		jf.add(l2);
		
		l3.setLocation(100,110);
		l3.setSize(200,80);
		jf.add(l3);
		
		t1.setLocation(250,80);
		t1.setSize(150,20);
		jf.add(t1);
		
		t2.setLocation(250,110);
		t2.setSize(150,20);
		jf.add(t2);

		t3.setLocation(250,140);
		t3.setSize(150,20);
		jf.add(t3);
		
		b1.setLocation(40,200);
		b1.setSize(60,20);
		jf.add(b1);
		
		b2.setLocation(120,200);
		b2.setSize(70,20);
		jf.add(b2);
	
		b3.setLocation(200,200);
		b3.setSize(70,20);
		jf.add(b3);
		
		b4.setLocation(280,200);
		b4.setSize(70,20);
		jf.add(b4);
		
		b5.setLocation(360,200);
		b5.setSize(80,20);
		jf.add(b5);

		b6.setLocation(460,200);
		b6.setSize(70,20);
		jf.add(b6);
		
	}
	
	void Liseners()
	{
		
	}
	void Showframe()
	{
      jf.setVisible(true);
	}
	//constructor Class
   ArithmeticDemo()
     {
   	   Controls();
       Addtocontrols();
       Liseners();
       Showframe();	 
     }
    //main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArithmeticDemo();
	}

}
