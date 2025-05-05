package mypack;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

class photo {
    
    JFrame jf = new JFrame("Upload Student Photo");
    JFrame retreiveFrame = new JFrame("Retrieve Photo");
    private JLabel photoLabel = new JLabel();
    JLabel l1 = new JLabel("Student ID: ");
    JTextField t1 = new JTextField();
    private JFileChooser fileChooser = new JFileChooser();
    private File selectedFile;
    private JButton uploadBTN = new JButton("Upload Photo");
    private JButton retrieveBTN = new JButton("Retrieve Photo");
    private JButton continueBTN = new JButton("Continue");
    private JButton exitBTN = new JButton("Exit");
    private JButton clearBTN = new JButton("Clear Photo");
    
    static Connection con;
    String path;
    
    void showframe() {
        jf.setLayout(null);
        jf.setSize(700, 500);
        
        l1.setSize(100, 20);
        l1.setLocation(20, 20);
        jf.add(l1);
        
        t1.setSize(90, 20);
        t1.setLocation(90, 21);
        t1.setText("21UCS1001");
        t1.setEditable(false);
        jf.add(t1);
        
        photoLabel.setSize(300, 400);
        photoLabel.setLocation(60, 50);
        jf.add(photoLabel);
        
        uploadBTN.setSize(150, 25);
        uploadBTN.setLocation(500, 50);
        jf.add(uploadBTN);
        
        retrieveBTN.setSize(150, 25);
        retrieveBTN.setLocation(500, 100);
        jf.add(retrieveBTN);
        
        clearBTN.setSize(150, 25);
        clearBTN.setLocation(500, 150);
        jf.add(clearBTN);
        
        exitBTN.setSize(150, 25);
        exitBTN.setLocation(500, 200);
        jf.add(exitBTN);
        
        continueBTN.setSize(100, 25);
        continueBTN.setLocation(550, 400);
        jf.add(continueBTN);
        
        uploadPhotoPath();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    
    private void uploadPhotoPath() {
        String url = "jdbc:mysql://localhost:3306/javafullstack830";
        String user = "root";
        String pw = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException classEXP) {
            classEXP.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        
        uploadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnval = fileChooser.showOpenDialog(jf);
                if (returnval == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageic = new ImageIcon(selectedFile.getAbsolutePath());
                    photoLabel.setIcon(imageic);
                }
            }
        });
        
        continueBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path targetDir = Paths.get("Student_Photos");
                if (!Files.exists(targetDir)) {
                    try {
                        Files.createDirectories(targetDir);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                
                int res = JOptionPane.showConfirmDialog(jf, "Are you sure you want to upload your image?", "Photo Uploader", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        Path targetPath = targetDir.resolve(selectedFile.getName());
                        Files.copy(selectedFile.toPath(), targetPath);
                        path = targetPath.toString();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    try {
                        String q = "INSERT INTO sphotos (stuid, picpath) VALUES (?, ?)";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, t1.getText());
                        ps.setString(2, path);
                        ps.execute();
                        JOptionPane.showMessageDialog(jf, "Insertion Successful!", "Photo Uploader", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException sql1) {
                        sql1.printStackTrace();
                    }
                }
            }
        });
        
        retrieveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idtf = new JTextField();
                JTextField dobtf = new JTextField();
                JLabel idlabel = new JLabel("Enter a Student ID: ");
                JLabel doblabel = new JLabel("Enter a Student D.O.B: ");
                JButton fetchBtn = new JButton("Fetch My Photo");
                
                idlabel.setSize(150, 20);
                idlabel.setLocation(30, 50);
                retreiveFrame.add(idlabel);
                
                idtf.setSize(100, 20);
                idtf.setLocation(200, 50);
                retreiveFrame.add(idtf);
                
                doblabel.setSize(150, 20);
                doblabel.setLocation(30, 90);
                retreiveFrame.add(doblabel);
                
                dobtf.setSize(100, 20);
                dobtf.setLocation(200, 90);
                retreiveFrame.add(dobtf);
                
                fetchBtn.setSize(150, 25);
                fetchBtn.setLocation(200, 200);
                retreiveFrame.add(fetchBtn);
                
                fetchBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = idtf.getText();
                        try {
                            String q = "SELECT picpath FROM sphotos WHERE stuid = ?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, id);
                            ResultSet rs = ps.executeQuery();
                            
                            if (rs.next()) {
                                ImageIcon imageic = new ImageIcon(rs.getString("picpath"));
                                retreiveFrame.setVisible(false);
                                photoLabel.setIcon(imageic);
                            } else {
                                JOptionPane.showMessageDialog(retreiveFrame, "Data Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                
                retreiveFrame.setLayout(null);
                retreiveFrame.setSize(400, 300);
                retreiveFrame.setLocationRelativeTo(jf);
                retreiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retreiveFrame.setVisible(true);
            }
        });
        
        clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                photoLabel.setIcon(null);
            }
        });
        
        exitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(jf, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    
    //photoUploader() {
       // showframe();
    }






public class PhotoUpload {
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
		
		l1=new JLabel("Select Year of Admission");	l2=new JLabel("Select the Degree");
		l3=new JLabel("Select the Department");	l4=new JLabel("Select the Course");
		l5=new JLabel("Student ID");	l6=new JLabel("Enter Student Name");
		l7=new JLabel("Enter Student Email ID");	l8=new JLabel("Enter Student Mobile No");
		l9=new JLabel("Enter Student Address");	l10=new JLabel("Enter Student City");
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
	
	
	
	void addListeners(Object pic) {
		
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
				if(degree.equals("UG")) dcode="U";
				else dcode="P";
				System.out.println(dcode);
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
					((photo) pic).showframe();
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
	void generateStuID()
	{
		System.out.println(deptcode);
		System.out.println(depttype);
		System.out.println(degree);
		try {
			String q4="select rollno from students where yoj=? and studept=? and stucourse=? and studegree=? limit 1";
			
			PreparedStatement ps = con.prepareStatement(q4);
			ps.setString(1,t1.getText());
			ps.setString(2,deptcode);
			ps.setString(3, depttype);
			ps.setString(4,degree);
			
			System.out.println(deptcode);
			System.out.println(depttype);
			System.out.println(degree);
			
			ResultSet rs=ps.executeQuery();
			if(rs.isAfterLast())
			{
				rollno=rs.getInt("rollno");
				System.out.println(rollno);
			
			}
			else 
			{
				if(degree.equals("UG")) rollno=1000;
				
				else if(degree.equals("PG")) rollno=2000;
			}
			
			rollno=rollno+1;
			stuid=year+dcode+deptcode+rollno;
			t1.setText(stuid);
			t2.requestFocus();

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	void showFrame() {
		jf1.setSize(450,500);
		jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	}
	
	PhotoUpload(Object pic){
		createControls();
		configureComboBoxes();
		addControlsToFrame();
		addListeners(pic);
		showFrame();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		photo pic = new photo();
		new PhotoUpload(pic);
	}

}
