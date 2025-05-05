package mypack;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Internal1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internal1 frame = new Internal1();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Internal1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\ESEC_Logo.png"));
		setTitle("ABC Arts and Science college");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel	p1 =new JPanel();
		p1.setBounds(98,10,1400,165);
//		p1.setBackground(new Color(226, 226, 226));
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("Erode Sengunthar Engineering College");
		l1.setForeground(new Color(128, 0, 0));
		l1.setFont(new Font("Arial", Font.BOLD, 27));
		l1.setBounds(420, 30, 520, 34);
		p1.add(l1);
		
		JLabel l2 = new JLabel("(Affiliated to Anna University,Chennai)");
		l2.setForeground(new Color(128, 0, 0));
		l2.setFont(new Font("Arial", Font.BOLD, 18));
		l2.setBounds(490, 77, 428, 23);
		p1.add(l2);
		
		JLabel l3 = new JLabel("Approved by UCG for 2(f),12(B) & Re- Accredited by NAAC A++");
		l3.setForeground(new Color(128, 0, 0));
		l3.setFont(new Font("Arial", Font.BOLD, 14));
		l3.setBounds(441, 110, 448, 23);
		p1.add(l3);
		
		JLabel l4 = new JLabel("Erode.");
		l4.setForeground(new Color(128, 0, 0));
		l4.setFont(new Font("Arial", Font.BOLD, 18));
		l4.setBounds(616, 140, 58, 23);
		p1.add(l4);
		
		JPanel	p2 =new JPanel();
		p2.setBounds(98,165,1400,190);
		p2.setBackground(new Color(233, 233, 233));
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l5 = new JLabel("Student Allocated");
		l5.setFont(new Font("Arial", Font.BOLD, 18));
		l5.setBounds(30,16, 180, 22);
		p2.add(l5);
		
		JLabel l6 = new JLabel("Academic Year");
		l6.setFont(new Font("Arial", Font.BOLD, 13));
		l6.setBounds(30, 58, 109, 16);
		p2.add(l6);
		
		JLabel l7 = new JLabel("Degree ");
		l7.setFont(new Font("Arial", Font.BOLD, 13));
		l7.setBounds(378, 58, 64, 16);
		p2.add(l7);
		
		JLabel l8= new JLabel("Department");
		l8.setFont(new Font("Arial", Font.BOLD, 13));
		l8.setBounds(641, 58, 109, 16);
		p2.add(l8);
		
		JLabel l9 = new JLabel("Course");
		l9.setFont(new Font("Arial", Font.BOLD, 13));
		l9.setBounds(997, 58, 109, 16);
		p2.add(l9);
		
		JLabel l10 = new JLabel("Year");
		l10.setFont(new Font("Arial", Font.BOLD, 13));
		l10.setBounds(40, 115, 109, 16);
		p2.add(l10);
		
		JLabel l11= new JLabel("Section");
		l11.setFont(new Font("Arial", Font.BOLD, 13));
		l11.setBounds(378,115, 109, 16);
		p2.add(l11);
		
		JLabel l12 = new JLabel("Semester");
		l12.setFont(new Font("Arial", Font.BOLD, 13));
		l12.setBounds(30, 170, 109, 16);
		p2.add(l12);
		
		JLabel l13= new JLabel("Subject code ");
		l13.setFont(new Font("Arial", Font.BOLD, 13));
		l13.setBounds(378,170, 109, 16);
		p2.add(l13);
		
		JLabel l14= new JLabel("Subject Name");
		l14.setFont(new Font("Arial", Font.BOLD, 13));
		l14.setBounds(635,170, 109, 16);
		p2.add(l14);

		JLabel l15= new JLabel("Type of Paper");
		l15.setFont(new Font("Arial", Font.BOLD, 13));
		l15.setBounds(1000,140, 109, 16);
		p2.add(l15);
		
		JLabel l16= new JLabel("Major of Paper");
		l16.setFont(new Font("Arial", Font.BOLD, 13));
		l16.setBounds(1200,140, 109, 16);
		p2.add(l16);
		
		
		JComboBox cb1 = new JComboBox();
		cb1.setBounds(138, 56, 155, 21);
		p2.add(cb1);
		
		JComboBox cb2= new JComboBox();
		cb2.setBounds(436, 56, 120, 21);
		p2.add(cb2);

		JComboBox cb3 = new JComboBox();
		cb3.setBounds(722, 56, 208, 21);
		p2.add(cb3);
		
		JComboBox cb4= new JComboBox();
		cb4.setBounds(1050, 55, 150, 21);
		p2.add(cb4);
		
		JComboBox cb5 = new JComboBox();
		cb5.setBounds(138, 112, 155, 21);
		p2.add(cb5);
		
		JComboBox cb6= new JComboBox();
		cb6.setBounds(436,112, 80, 20);
		p2.add(cb6);

		JComboBox cb7 = new JComboBox();
		cb7.setBounds(138,166, 155, 21);
		p2.add(cb7);
		
		JComboBox cb8= new JComboBox();
		cb8.setBounds(470,166, 120, 21);
		p2.add(cb8);
	
	    JTextField t1= new JTextField();
	    t1.setColumns(10);
	    t1.setBounds(728, 166, 170,22);
	    p2.add(t1);
	
	    JTextField t2 = new JTextField();
        t2.setColumns(10);
		t2.setBounds(966, 169, 150,22);
		p2.add(t2);
		
		JTextField t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(1170,169,150,22);
		p2.add(t3);
		
		JPanel	p3 =new JPanel();
		p3.setBounds(98,333,1400,180);
		p3.setBackground(new Color(233, 233, 233));
		contentPane.add(p3);
		p3.setLayout(null);
		
		JLabel l17= new JLabel("Minimum Marks");
		l17.setFont(new Font("Arial", Font.BOLD, 13));
		l17.setBounds(30,40, 108, 13);
		p3.add(l17);
		
		JLabel l18 = new JLabel("Maximum Marks");
		l18.setFont(new Font("Arial", Font.BOLD, 13));
		l18.setBounds(420,40, 108, 13);
		p3.add(l18);
		
		JLabel l19=  new JLabel("Portion");
		l19.setFont(new Font("Arial", Font.BOLD, 13));
		l19.setBounds(830,40, 108, 13);
		p3.add(l19);
		
		JLabel l20= new JLabel("Minimum Marks");
		l20.setFont(new Font("Arial", Font.BOLD, 13));
		l20.setBounds(30,100, 108, 13);
		p3.add(l20);
		
		JLabel l21 = new JLabel("Maximum Marks");
		l21.setFont(new Font("Arial", Font.BOLD, 13));
		l21.setBounds(420,100, 108, 13);
		p3.add(l21);
		
		JLabel l22=  new JLabel("Portion");
		l22.setFont(new Font("Arial", Font.BOLD, 13));
		l22.setBounds(830,100, 108, 13);
		p3.add(l22);
		
		JLabel l23= new JLabel("Time/Duration");
		l23.setFont(new Font("Arial", Font.BOLD, 13));
		l23.setBounds(30,158, 108, 13);
		p3.add(l23);
		
		JLabel l24 = new JLabel("Exam Date");
		l24.setFont(new Font("Arial", Font.BOLD, 13));
		l24.setBounds(420,158, 108, 13);
		p3.add(l24);
		
		JLabel l25=  new JLabel("Correction Date");
		l25.setFont(new Font("Arial", Font.BOLD, 13));
		l25.setBounds(800,158, 108, 13);
		p3.add(l25);
		
		
		JTextField t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(150,36,200,22);
		p3.add(t4);
		
		JTextField t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(540,36,200,22);
		p3.add(t5);

		JTextField t6= new JTextField();
		t6.setColumns(10);
		t6.setBounds(910,36,200,22);
		p3.add(t6);
		
		JTextField t7= new JTextField();
		t7.setColumns(10);
		t7.setBounds(150,96,200,22);
		p3.add(t7);
		
		JTextField t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(540,96,200,22);
		p3.add(t8);
		
		JTextField t9= new JTextField();
		t9.setColumns(10);
		t9.setBounds(910,96,200,22);
		p3.add(t9);	
		
		JTextField t10= new JTextField();
		t10.setColumns(10);
		t10.setBounds(150,153,200,22);
		p3.add(t10);
		
		JTextField t11 = new JTextField();
		t11.setColumns(10);
		t11.setBounds(540,153,200,22);
		p3.add(t11);
		
		JTextField t12= new JTextField();
		t12.setColumns(10);
		t12.setBounds(910,153,200,22);
		p3.add(t12);	
		
		JButton b1 = new JButton("Submit");
		b1.setBackground(new Color(191, 242, 240));
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("Arial", Font.BOLD, 13));
		b1.setBounds(650,550,180,25);
		contentPane.add(b1);
		
		cb1.addItem("SELECT..");
		cb1.addItem("2024-2027");
		cb1.addItem("2025-2028");
		cb1.addItem("2026-2029");	
		cb1.addItem("2027-2030");	
		cb1.addItem("2028-2031");
		cb1.addItem("2029-2032");
		cb1.addItem("2030-2033");
		
	    cb2.addItem("SELECT..");
	    cb2.addItem("UG");
	    cb2.addItem("PG");
	    
	    cb3.addItem("SELECT..");
	    cb3.addItem("BCA");
	    cb3.addItem("Computer Science");    
	    cb3.addItem("Commerce");
	    cb3.addItem("COM CA");
	    cb3.addItem("Tamil");
	    cb3.addItem("English");
	    cb3.addItem("Information technology");
	    
	    
		
    	cb3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==e.SELECTED)
				{
					String deptname=cb3.getSelectedItem().toString();
			    	String degree=cb2.getSelectedItem().toString();
				    
					System.out.print(deptname);
					if(!(deptname).equalsIgnoreCase("select.."))
					{
						try 
					    {	
					    	Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
							String q="select deptcode from departments where deptname=?";
							PreparedStatement ps1=con.prepareStatement(q);
							
							ps1.setString(1,deptname);
							ResultSet rs1=ps1.executeQuery();
							
							if(rs1.next());
							System.out.print("value "+rs1.getString("deptcode"));
							
					    }
					    catch(Exception e1)
					    {
					    	System.out.print("Exception occured.."+e1);
					    }

					}
					else
					{
						System.out.print("Exception occured..?????");
					}
				}
			}
		});
	}

}