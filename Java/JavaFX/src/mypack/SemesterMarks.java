package mypack;

import java.io.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SemesterMarks {

	//Instantiation..!
	static Connection con;
	DataInputStream dis = new DataInputStream(System.in);
	JFrame mainf,semf;
	JLabel IdL,semL,nameL,idLabel_For_semF,welL,colNameL,itemLabel;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JButton b1=new JButton("Validate"),itemButton = new JButton("Confirm");
	JComboBox cb1 = new JComboBox();
	//local variable gets from getting from the value (t1) text field..!
	String sid;
	
	
	//DB-Connection..!
	
	//Frame setup..!
	void showFrame()
	{
		mainf.setSize(500,300);
		mainf.setDefaultCloseOperation(mainf.EXIT_ON_CLOSE);
		mainf.setTitle("Semester Marks Insertion");
		
		semf.setSize(400,350);
		semf.setDefaultCloseOperation(semf.EXIT_ON_CLOSE);
		
		int main_fw = mainf.getWidth();
		int main_fh = mainf.getHeight();
		int sem_fw = semf.getWidth();
		int sem_fh = semf.getHeight();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int screen_W = (int)d.getWidth();
		int screen_H = (int)d.getHeight();
		int mainf_X = (int)(screen_W - main_fw)/2;
		int mainf_Y = (int)(screen_H-main_fh)/2;
		int sem_X = (int)(screen_W-sem_fw)/2;
		int sem_Y = (int)(screen_H-sem_fh)/2;
		
		mainf.setLocation(mainf_X,mainf_Y);
		semf.setLocation(sem_X,sem_Y);
		

		mainf.setVisible(true);
	}
	
	//Needed Components..!
	void components()
	{
		//mainframe
		mainf=new JFrame();
		mainf.setLayout(null);
		
		//Semester selection frame..!
		semf = new JFrame("Select the Semester");
		semf.setLayout(null);
		
		
		//Labels here..!
		IdL = new JLabel("Enter Your STUID: ");
		semL = new JLabel("Enter the Semester: ");
		colNameL = new JLabel("Erode Arts And Science College");
		
		//TextFields here..!
		t1 = new JTextField(25);
		t2 = new JTextField(25);
		
	}
	
	//Components add to frame..!
	void addComponents()
	{
		IdL.setSize(130,20);
		IdL.setLocation(50, 80);
		mainf.add(IdL);
		
		t1.setSize(190, 20);
		t1.setLocation(200,81);
		mainf.add(t1);
		
		b1.setSize(100,25);
		b1.setLocation(250,125);
		mainf.add(b1);
		
		colNameL.setSize(200,20);
		
		//College Put on center..!
		int tw = colNameL.getWidth();
		int th = colNameL.getHeight();
		int fw = 500;
		int x = (int)(fw-tw)/2;
	
		colNameL.setLocation(x,20);
		mainf.add(colNameL);
		
	}
	
	//Add listeners..!
	void addListeners(Object con)
	{
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//Value gets from text-field box(t1)..!
				sid = t1.getText();
				
				//Outer If..!
//				if(sid.compareTo("")!=0)
//				{
//					//Connection Making...!
//					try {						
//						String q = "select stuid,stuname from studentstable where stuid = ?";
//					    
//					    //Inner If Condition..!
//					    if(rs.next())
//					    {
//					    	String id = rs.getString(1);
//					    	String name = rs.getString(2);
//					    	if(id.compareToIgnoreCase(sid)==0)
//					    	{
////					    		System.out.println("\t\tHii "+name);
////					    		System.out.println("\tValidation SuccessFul..!");
//					    		mainf.setVisible(false);
//					    		
//					    		nameL = new JLabel("Name: "+name);
//					    		nameL.setSize(80,50);
//					    		
//					    		idLabel_For_semF = new JLabel("Register Number: "+id);
//					    		idLabel_For_semF.setSize(200,20);
//					    		
//					    		int fw = semf.getWidth();
//					    		int nw = nameL.getWidth();
//					    		int colNameW = colNameL.getWidth();
//					    		//System.out.println(colNameW);
//					    		int colNameLX_axis = (int)(fw-colNameW)/2;
//					    		int x = (int)(fw-nw)/2;
//					    		int idL_W = idLabel_For_semF.getWidth();
//					    		int idL_X = (int)(fw-idL_W)/2;
//					    		
//					    		
//					    		colNameL.setLocation(colNameLX_axis,20);
//					    		semf.add(colNameL);
//					    		nameL.setLocation(x,50);
//					    		semf.add(nameL);
//					    		idLabel_For_semF.setLocation(idL_X,110);
//					    		semf.add(idLabel_For_semF);
//					    		
//					    		
//					    		itemLabel = new JLabel("Select the Semester: ");
//					    		itemLabel.setSize(130,20);
//					    		itemLabel.setLocation(50,165);
//					    		
//					    		semf.add(itemLabel);
//					    		cb1.addItem("None");
//					    		cb1.addItem("I");
//					    		cb1.addItem("II");
//					    		cb1.addItem("III");
//					    		cb1.addItem("IV");
//					    		cb1.addItem("V");
//					    		cb1.addItem("VI");
//					    		
//					    		cb1.setSize(150,20);
//					    		cb1.setLocation(200,165);
//					    		semf.add(cb1);
//					    		
//					    		itemButton.setSize(80,20);
//					    		itemButton.setLocation(280,230);
//					    		semf.add(itemButton);
//					    		
//					    		//new Frame set-up..!
//					    		semf.setVisible(true);
//					    	}
//					    	
//					    }
//					    //Inner Else Part..!
//					    else {
//					    	JOptionPane.showMessageDialog(mainf, "Invalid User Registration ID..!","EASC",JOptionPane.INFORMATION_MESSAGE);
//					    	t1.setText("");
//					    }
//					} 
//					
//					catch (ClassNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					catch (SQLException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//				}
				//Outer Else part..!
//				else
//				{
//					JOptionPane.showMessageDialog(mainf, "STUID field is empty..!","EASC",JOptionPane.INFORMATION_MESSAGE);
//				}
			}
		});
		
		itemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String item = cb1.getSelectedItem().toString();
				
				if(item.equalsIgnoreCase("I"))
				{
					String q = "select * from subjectList where sem = I";
					int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
				}
				else if(item.equalsIgnoreCase("II"))
				{
					System.out.println("II - semester");
				}
				else if(item.equalsIgnoreCase("III"))
				{
					System.out.println("III - semester");
				}
				else if(item.equalsIgnoreCase("IV"))
				{
					System.out.println("IV - semester");
				}
				else if(item.equalsIgnoreCase("V"))
				{
					System.out.println("V - semester");
				}
				else if(item.equalsIgnoreCase("VI"))
				{
					System.out.println("VI - semester");
				}
			}
		});
	}
	
	//Constructor Class..!
	SemesterMarks(Object con)
	{
		addListeners(con);
		components();
		addComponents();
		showFrame();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		new SemesterMarks(con);
	}

}
