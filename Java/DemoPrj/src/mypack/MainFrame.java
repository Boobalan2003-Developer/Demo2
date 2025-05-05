package mypack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private JFrame reg_frame = new JFrame();
    private static MainFrame mainframe;
    private JPanel mainpanel;
    private JTextField mail_textfield;
    private JPasswordField passwordField;

    static Connection con;
    String dept, depttype,course,year,degree,stuid,deptcode,degcode,sname,semail,smob,scity,sadd;
    int rollno,y;

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JComboBox<String> c1, c2, c3, c4;
    JTextField t1, t2, t3, t4, t5;
    JTextArea ta1;
    JButton reg_btn, reset_btn, exit_btn;
    private JTextField usernameField;

    
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
    
    public void reg_frame() {
        l1 = new JLabel("Select Year of Admission");
        l2 = new JLabel("Select the Degree");
        l3 = new JLabel("Select the Department");
        l4 = new JLabel("Select the Course");
        l5 = new JLabel("Student ID");
        l6 = new JLabel("Enter Student Name");
        l7 = new JLabel("Enter Student Email ID");
        l8 = new JLabel("Enter Student Mobile No");
        l9 = new JLabel("Enter Student Address");
        l10 = new JLabel("Enter Student City");
        l11 = new JLabel("ADD NEW STUDENT");

        c1 = new JComboBox<>();
        c2 = new JComboBox<>();
        c3 = new JComboBox<>();
        c4 = new JComboBox<>();

        c1.addItem("-");
        c1.addItem("2024");
        c1.addItem("2025");
        c1.addItem("2026");
        c1.addItem("2027");

        c2.addItem("-");
        c2.addItem("UG");
        c2.addItem("PG");

        c3.addItem("-");
        c4.addItem("-");

        t1 = new JTextField(30);
        t1.setEditable(false);
        t2 = new JTextField(30);
        t3 = new JTextField(30);
        t4 = new JTextField(30);
        t5 = new JTextField(30);
        ta1 = new JTextArea(30, 4);

        reg_btn = new JButton("Register");
        reset_btn = new JButton("Reset");
        exit_btn = new JButton("Close");

        reg_frame.getContentPane().setLayout(null);

        l11.setBounds(180, 20, 200, 20);
        reg_frame.getContentPane().add(l11);

        l1.setBounds(20, 50, 200, 20);
        c1.setBounds(210, 50, 190, 20);
        reg_frame.getContentPane().add(l1);
        reg_frame.getContentPane().add(c1);

        l2.setBounds(20, 80, 200, 20);
        c2.setBounds(210, 80, 190, 20);
        reg_frame.getContentPane().add(l2);
        reg_frame.getContentPane().add(c2);

        l3.setBounds(20, 110, 200, 20);
        c3.setBounds(210, 110, 190, 20);
        reg_frame.getContentPane().add(l3);
        reg_frame.getContentPane().add(c3);

        l4.setBounds(20, 140, 200, 20);
        c4.setBounds(210, 140, 190, 20);
        reg_frame.getContentPane().add(l4);
        reg_frame.getContentPane().add(c4);

        l5.setBounds(20, 170, 200, 20);
        t1.setBounds(210, 170, 190, 20);
        reg_frame.getContentPane().add(l5);
        reg_frame.getContentPane().add(t1);

        
        c2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    degree = c2.getSelectedItem().toString();
                    
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830", "root", "");
                        String q = "SELECT deptname FROM departments ORDER BY deptname";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(q);

                        c3.removeAllItems();
                        c3.addItem("-");
                        while (rs.next()) {
                            c3.addItem(rs.getString("deptname"));
                        }

                    } catch (ClassNotFoundException | SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        c3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == e.SELECTED) {
                    String deptName = c3.getSelectedItem().toString();
                    try {
                        String q = "SELECT depttype,deptcode FROM departments WHERE deptname=?";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, deptName);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            depttype = rs.getString("depttype");
                            deptcode=rs.getString("deptcode");
                        }

                        c4.removeAllItems();
                        
                        String q1 = "SELECT coursename FROM courses WHERE coursetype=? AND coursedegree=?";
                        PreparedStatement ps1 = con.prepareStatement(q1);
                        ps1.setString(1, depttype);
                        ps1.setString(2, c2.getSelectedItem().toString());
                        ResultSet rs1 = ps1.executeQuery();
                        while (rs1.next()) {
                            c4.addItem(rs1.getString("coursename"));
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        c4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==e.SELECTED)
				{
					course=c4.getSelectedItem().toString();
					year=c1.getSelectedItem().toString();
					generateStuid();
				}
			}
		});

        
        reg_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sname=t2.getText();
				semail=t3.getText();
				smob=t4.getText();
				sadd=ta1.getText();
				scity=t5.getText();
				if(!(sname).isEmpty())
				{
					if(!(semail).isEmpty())
					{
						if(!(smob).isEmpty())
						{
							if(!(sadd).isEmpty())
							{
								if(!(scity).isEmpty())
								{
									JOptionPane.showMessageDialog(reg_frame,"All details are got..!","EASC",JOptionPane.INFORMATION_MESSAGE);
									resetData();
								}
								else
								{
									JOptionPane.showMessageDialog(reg_frame,"City is missing","EASC",JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(reg_frame,"Address is missing","EASC",JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(reg_frame,"Mobile Number is missing","EASC",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(reg_frame,"E-Mail ID is missing","EASC",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(reg_frame,"Name is missing","EASC",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
       
        l6.setBounds(20, 200, 200, 20);
        t2.setBounds(210, 200, 190, 20);

        reg_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        reset_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetData();
			}
		});
        
        exit_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res=JOptionPane.showConfirmDialog(reg_frame,"Are You sure want to quit..?","EASC",2);
				if(res==0)
				{
				System.exit(0);
				}
			}
		});
        
        reg_frame.getContentPane().add(l6);
        reg_frame.getContentPane().add(t2);

        l7.setBounds(20, 230, 200, 20);
        t3.setBounds(210, 230, 190, 20);
        reg_frame.getContentPane().add(l7);
        reg_frame.getContentPane().add(t3);

        l8.setBounds(20, 260, 200, 20);
        t4.setBounds(210, 260, 190, 20);
        reg_frame.getContentPane().add(l8);
        reg_frame.getContentPane().add(t4);

        l9.setBounds(20, 290, 200, 20);
        ta1.setBounds(210, 290, 190, 60);
        reg_frame.getContentPane().add(l9);
        reg_frame.getContentPane().add(ta1);

        l10.setBounds(20, 360, 200, 20);
        t5.setBounds(210, 360, 190, 20);
        reg_frame.getContentPane().add(l10);
        reg_frame.getContentPane().add(t5);

        reg_btn.setBounds(20, 400, 90, 25);
        reset_btn.setBounds(135, 400, 90, 25);
        exit_btn.setBounds(250, 400, 90, 25);
        reg_frame.getContentPane().add(reg_btn);
        reg_frame.getContentPane().add(reset_btn);
        reg_frame.getContentPane().add(exit_btn);

        
        reg_frame.setExtendedState(MAXIMIZED_BOTH);
        reg_frame.setLocationRelativeTo(null);
        reg_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg_frame.setResizable(false);
        reg_frame.setVisible(true);
    }

    
    public void generateStuid()
    {
    	 
    	
         try {
        	 String q = "SELECT rollno FROM students WHERE stucourse=? and studegree =? and yoj=? ORDER BY rollno desc limit 1";
             PreparedStatement ps = con.prepareStatement(q);
			 ps.setString(1, course);
			 ps.setString(2, degree);
	         ps.setString(3, year);
	         ResultSet rs = ps.executeQuery();
	         if (rs.next()) {
	             rollno=Integer.parseInt(rs.getString("rollno"));
	         }
	         y=(Integer.parseInt(year)-2000);
	         rollno=rollno+1;
	         if(degree.equalsIgnoreCase("ug")) degcode="U";
	         else if (degree.equalsIgnoreCase("pg")) degcode="P"; 
	         
	         
	 		 stuid=y+degcode+deptcode+rollno;
	 		 t1.setText(stuid);
	 		 t2.requestFocus();
         } 
         catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(reg_frame, "Internale Error - "+e.getMessage(),"EASC",JOptionPane.ERROR_MESSAGE);
		}
         
    }
    
    
private void adminScreen2()
{
	JFrame adminFrame2=new JFrame("EASC");
	adminFrame2.getContentPane().setLayout(null);
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	
	int sw=(int) d.getWidth();
	int sh=(int) d.getHeight();
	
	JRadioButton adminR_btn=new JRadioButton("Update Admin Record");
	JRadioButton registerR_btn=new JRadioButton("New Student Registration");
	adminFrame2.setSize(400,400);
	adminFrame2.setDefaultCloseOperation(adminFrame2.EXIT_ON_CLOSE);
	adminFrame2.setLocationRelativeTo(mainframe);
	
	int RH=200;
	
	int centerH=(int)(sh-RH)/2;
	System.out.println(sh+"\n"+RH+"\n"+centerH);
	adminR_btn.setSize(200,20);
	adminR_btn.setLocation(10,centerH);
	adminFrame2.getContentPane().add(adminR_btn);
	
	registerR_btn.setSize(200,20);
	adminR_btn.setLocation(10,40);
	adminFrame2.getContentPane().add(registerR_btn);
	
	adminFrame2.setVisible(true);
}

       public MainFrame() 
       {
       	setResizable(false);
    	      
    	   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation(100, 100);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int sw=(int)d.getWidth();
        int sh=(int)d.getHeight();
       
        mainpanel = new JPanel();
        mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainpanel);
        mainpanel.setLayout(null);
      
        JPanel loginpanel = new JPanel();
        loginpanel.setBackground(new Color(255, 255, 255));
        loginpanel.setBounds(552, 301, 566, 289);
        mainpanel.add(loginpanel);
        
        
    
        loginpanel.setBackground(new Color(255, 255, 255));
        loginpanel.setBounds(530, 304, 566, 289);
        mainpanel.add(loginpanel);
        loginpanel.setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setBounds(10, 74, 82, 21);
        loginpanel.add(username);
        username.setFont(new Font("Arial", Font.BOLD, 17));
                
        usernameField = new JTextField();
        usernameField.setBounds(257, 72, 287, 30);
        loginpanel.add(usernameField);
        usernameField.setColumns(10);
                        
        JLabel label2 = new JLabel("Password");
        label2.setBounds(10, 143, 79, 21);
        loginpanel.add(label2);
        label2.setFont(new Font("Arial", Font.BOLD, 17));
                                
        passwordField = new JPasswordField();
        passwordField.setBounds(257, 141, 287, 30);
        loginpanel.add(passwordField);
                                
        JButton reg_button = new JButton("Verify");
        reg_button.setBounds(119, 215, 113, 30);
        loginpanel.add(reg_button);
        reg_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        reg_button.addActionListener(new ActionListener() {
            
        public void actionPerformed(ActionEvent e) 
        {
        	String mail_id = usernameField.getText();
        	String password = new String(passwordField.getPassword());
            if (!mail_id.isEmpty() && !password.isEmpty()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830", "root", "");
                    String q = "SELECT * FROM admin_Login WHERE admin_id=? AND pw=?";
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1, mail_id);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(mainframe, "Authentication Success..!", "EASC", JOptionPane.INFORMATION_MESSAGE);
                        mainframe.setVisible(false);
                        adminScreen2();
                    } else {
                        JOptionPane.showMessageDialog(mainframe, "Invalid User Name or Password..! Try Again..!", "EASC", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(mainframe, "Authentication Failed..!", "EASC", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
        
    reg_button.setMnemonic('v');
                                        
    JButton exit_button = new JButton("EXIT");
    exit_button.setBounds(373, 215, 130, 30);
    loginpanel.add(exit_button);
    exit_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
    exit_button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int res = JOptionPane.showConfirmDialog(mainpanel, "Are You Sure Want to Quit?", "EASC", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    });
    exit_button.setMnemonic('x');
                                                
    JPanel headpanel = new JPanel();
    headpanel.setBackground(new Color(166, 210, 255));
    headpanel.setBounds(354, 48, 918, 161);
    mainpanel.add(headpanel);
    headpanel.setLayout(null);
                                                
    JLabel headingLabel = new JLabel("ERODE ARTS AND SCIENCE COLLEGE");
    headingLabel.setBounds(270, 29, 399, 26);
    headpanel.add(headingLabel);
    headingLabel.setBackground(new Color(0, 0, 0));
    headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
    headingLabel.setForeground(new Color(183, 0, 0));
    headingLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
    
    int x1=100;int y1=100;
    ImageIcon icon1=new ImageIcon("D:\\Java\\DemoPrj\\src\\Images\\clglogo.png");
    Image img1=icon1.getImage();
    Image scaledImage1=img1.getScaledInstance(x1,y1,Image.SCALE_SMOOTH);
    
    ImageIcon icon2=new ImageIcon("D:\\Java\\DemoPrj\\src\\mypack\\clglogo1.png");
    Image img2=icon2.getImage();
    Image scaledImage2=img2.getScaledInstance(x1,y1,Image.SCALE_SMOOTH);
    
    JLabel logo1 = new JLabel("");
    logo1.setBounds(74, 0, 130, 150);
    headpanel.add(logo1);
    
    JLabel logo2 = new JLabel("");
    logo2.setBounds(736, 0, 130, 150);
    headpanel.add(logo2);
                                                                                                  
    logo1.setIcon(new ImageIcon(scaledImage1));
    logo2.setIcon(new ImageIcon(scaledImage2));
                                                        
    JLabel lblAutonomousCo = new JLabel("Autonomous ( Co - Education )");
    lblAutonomousCo.setBounds(373, 65, 213, 17);
    headpanel.add(lblAutonomousCo);
    lblAutonomousCo.setFont(new Font("Arial", Font.BOLD, 14));
    
    JLabel lblAfiliatedByBharathiar = new JLabel("Afiliated by Bharathiar University,Coimbatore");
    lblAfiliatedByBharathiar.setFont(new Font("Arial", Font.BOLD, 14));
    lblAfiliatedByBharathiar.setBounds(318, 92, 317, 17);
    headpanel.add(lblAfiliatedByBharathiar);
    
    JLabel lblErode = new JLabel("Erode-638009");
    lblErode.setFont(new Font("Arial", Font.BOLD, 14));
    lblErode.setBounds(423, 119, 94, 17);
    headpanel.add(lblErode);
    
    
    JLabel bgimglbl = new JLabel("");
    bgimglbl.setBounds(696, 269, sw, sh);
    mainpanel.add(bgimglbl);
    
    ImageIcon bgimg=new ImageIcon("D:\\Java\\DemoPrj\\src\\mypack\\ClgImg.png");
    Image bg=bgimg.getImage();
    Image bgScaled=img2.getScaledInstance(sw,sh,Image.SCALE_SMOOTH);

    logo2.setIcon(new ImageIcon(scaledImage2));
    headpanel.add(logo2);  
       
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainframe = new MainFrame();
                    mainframe.setLocationRelativeTo(null);
                    mainframe.setExtendedState(MAXIMIZED_BOTH);
                    mainframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
