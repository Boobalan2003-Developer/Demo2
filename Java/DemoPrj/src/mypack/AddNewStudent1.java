package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddNewStudent1 {
	Connection con;
	JFrame jf1;
	JPanel jp1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JComboBox c1,c2,c3,c4;
	JTextField t1,t2,t3,t4,t5;
	JTextArea ta1;
	JButton b1,b2,b3;
	
	String stuid,degree,deptcode,dcode,depttype,stucourse,sname,semail,smob,sadd,scity,y;
	int rollno,year;
	
	//photoUploader pu = new photoUploader();
	void createControls() {
		jf1=new JFrame("New Student Registration");
		jp1=new JPanel();
		
		l1=new JLabel("Select Year of Admission");	
		l2=new JLabel("Select the Degree");
		l3=new JLabel("Select the Department");	
		l4=new JLabel("Select the Course");
		l5=new JLabel("Student ID");	
		l6=new JLabel("Enter Student Name");
		l7=new JLabel("Enter Student Email ID");	
		l8=new JLabel("Enter Student Mobile No");
		l9=new JLabel("Enter Student Address");	
		l10=new JLabel("Enter Student City");
		l11=new JLabel("ADD NEW STUDENT");
		
		c1=new JComboBox();	c2=new JComboBox(); c3=new JComboBox();c4=new JComboBox();
		
		int tflength=30;
		
		t1=new JTextField(tflength);	
		t2=new JTextField(tflength);	
		t3=new JTextField(tflength);
		t4=new JTextField(tflength);
		t5=new JTextField(tflength);
		t1.setEditable(false);
		ta1=new JTextArea(tflength,4);
		
		b1=new JButton("Register");
		b2=new JButton("Reset");
		b3=new JButton("Close");
		
	}
	
	void addControlsToFrame() {
		jf1.setLayout(null);
		jp1.setLayout(null);
		jp1.setSize(400,450);
		l11.setBounds(130, 20, 200, 20);
		jp1.add(l11);
		
//		l1.setSize(100,20);
		l1.setBounds(20,50,200,20);
		jp1.add(l1);
		
		c1.setBounds(210,50,190,20);
		jp1.add(c1);
		
		l2.setBounds(20,80,200,20);
		jp1.add(l2);
		
		c2.setBounds(210,80,190,20);
		jp1.add(c2);
		
		l3.setBounds(20,110,200,20);
		jp1.add(l3);
		
		c3.setBounds(210,110,190,20);
		jp1.add(c3);
		
		l4.setBounds(20,140,200,20);
		jp1.add(l4);
		
		c4.setBounds(210,140,190,20);
		jp1.add(c4);
		
		l5.setBounds(20,170,200,20);
		jp1.add(l5);
		
		t1.setBounds(210,170,190,20);
		jp1.add(t1);
		
		l6.setBounds(20,200,200,20);
		jp1.add(l6);
		
		t2.setBounds(210,200,190,20);
		jp1.add(t2);
		
		l7.setBounds(20,230,200,20);
		jp1.add(l7);
		
		t3.setBounds(210,230,190,20);
		jp1.add(t3);
		
		l8.setBounds(20,260,200,20);
		jp1.add(l8);
		
		t4.setBounds(210,260,190,20);
		jp1.add(t4);
		

		l9.setBounds(20,290,200,20);
		jp1.add(l9);
		
		ta1.setBounds(210,290,190,60);
		jp1.add(ta1);
		

		l10.setBounds(20,360,200,20);
		jp1.add(l10);
		
		t5.setBounds(210,360,190,20);
		jp1.add(t5);
		
		b1.setBounds(20,390,90,25);
		jp1.add(b1);
		
		b2.setBounds(135,390,90,25);
		jp1.add(b2);
		
		b3.setBounds(250,390,90,25);
		jp1.add(b3);
		
		
		jf1.add(jp1);
	}

	void configureComboBoxes() {
		c1.addItem("-");
		c1.addItem("2024");
		c1.addItem("2025");
		c1.addItem("2026");
		c1.addItem("2027");
		
		c2.addItem("-");
		c2.addItem("UG");
		c2.addItem("PG");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830","root","");
			
			String q="select deptname from departments order by deptname";
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(q);
			c3.addItem("-");
			while(rs.next()) {
				c3.addItem(rs.getString("deptname"));
			}
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void getCourseDetail() {
		
		degree=c2.getSelectedItem().toString();
		String deptname=c3.getSelectedItem().toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830","root","");
			String q1="select depttype,deptcode from departments where deptname=?";
			
			PreparedStatement ps=con.prepareStatement(q1);
			ps.setString(1, deptname);
			ResultSet rs1=ps.executeQuery();
			if(rs1.next()) {
				depttype=rs1.getString("depttype");
				deptcode=rs1.getString("deptcode");
			}
		
			
			String q="select coursename from courses where coursedegree=? and coursetype=?";
			
			PreparedStatement ps1=con.prepareStatement(q);
			ps1.setString(1,degree);
			ps1.setString(2, depttype);
			ResultSet rs=ps1.executeQuery();
			
			c4.removeAllItems();
			
			while(rs.next()) {
				c4.addItem(rs.getString("coursename"));
			}
			y=c1.getSelectedItem().toString();
			int year=Integer.parseInt(y)-2000;
			
			stucourse = c4.getSelectedItem().toString();
			if(degree.equals("UG")) dcode="U";
			else dcode="P";
			
			String q2="select rollno from students where yoj=? and studept=? and stucourse=? and studegree=? order by rollno desc limit 1";
			
			PreparedStatement ps2=con.prepareStatement(q2);
			ps2.setString(1,y);
			ps2.setString(2,deptcode);
			ps2.setString(3, stucourse);
			ps2.setString(4,degree);
			
			ResultSet rs3=ps2.executeQuery();
			if(rs3.next())
			{
				rollno=rs3.getInt("rollno");
			}
			else 
			{
				if(degree.equals("UG")) rollno=1000;
				
				else if(degree.equals("PG")) rollno=2000;
			}
			
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	void resetData() {
		c1.setSelectedIndex(0);
		c2.setSelectedIndex(0);
		c3.setSelectedIndex(0);
		t1.setEditable(true);
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		ta1.setText("");
		t1.setEditable(false);
		c4.removeAllItems();
	}
	
	String generateStuID()
	{
		rollno=rollno+1;
		stuid=year+dcode+deptcode+rollno;
		t1.setText(stuid);
		t2.requestFocus();
		return stuid;
	}
	
	void addListeners() {
		
		t1.setText("");
		c1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==e.SELECTED)
				{
					if(!c1.getSelectedItem().toString().equals("-"))
					{
						String y = c1.getSelectedItem().toString();
						year = Integer.parseInt(y);
						year-=2000;
					}
					else
					{
						t1.setEnabled(true);
						t1.setText("");
						t1.setEnabled(true);
					}
						
				}
			}
		});
		
		c2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getStateChange()==e.SELECTED) 
				{
					if(!c3.getSelectedItem().toString().equals("-") )
						getCourseDetail();
				}
				else
				{
					t1.setEnabled(true);
					t1.setText("");
					t1.setEnabled(true);
				}
				
			}//item-state-changed close
		});//c2.listener
		
		c3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==e.SELECTED) {
					if(!c2.getSelectedItem().toString().equals("-"))
					getCourseDetail();
			}}
		}); //c3 listener ends here
		
		c4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				generateStuID();
			}
		});
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				sname=t2.getText();
				semail=t3.getText();
				smob=t4.getText();
				sadd=ta1.getText();
				scity=t5.getText();
				
				if(sname.equals("") || semail.equals("")|| smob.equals("")|| sadd.equals("")|| scity.equals("")) {
					JOptionPane.showMessageDialog(jf1,"Field Value Missing!!","StuManager",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String q4="insert into students(rollno,stuid,stuname,studept,stuemailid,stumobile,stuadd,stucity,stucourse,studegree,yoj)values(?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement ps4;
					try {
						ps4 = con.prepareStatement(q4);
						ps4.setInt(1, rollno);
						ps4.setString(2, stuid);
						ps4.setString(3, sname);
						ps4.setString(4, deptcode);
						ps4.setString(5, semail);
						ps4.setString(6, smob);
						ps4.setString(7, sadd);
						ps4.setString(8, scity);
						ps4.setString(9, c4.getSelectedItem().toString());
						ps4.setString(10, degree);
						ps4.setString(11,y);
						ps4.execute();
						
						JOptionPane.showMessageDialog(jf1,"Student Registration Success","StuManager",JOptionPane.INFORMATION_MESSAGE);
						c3.removeAllItems();
						c3.addItem("-");
						resetData();
					} 
					catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//pu.main(null);
			}
		});//b1 action listener ends here
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c3.addItem("-");
				resetData();
			}
		});//b2 ends
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(jf1,"Are you sure want to Exit..?","StuManager",2);
				if(res ==0)
				{
					System.exit(0);
				}
			}
		});
	}//addListeners() ends here
	
	void showFrame() {
		jf1.setSize(450,500);
		jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	}
	
	AddNewStudent1(){
		createControls();
		configureComboBoxes();
		addControlsToFrame();
		addListeners();
		showFrame();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new AddNewStudent1();
	}

}



