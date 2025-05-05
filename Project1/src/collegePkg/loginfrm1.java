package collegePkg;

import javax.swing.border.Border;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class loginfrm1 {

    // Frame and panel declarations
    JFrame frm1 = new JFrame("EASC");
    JPanel mainpanel1 = new JPanel();
    JPanel mainpanel2 = new JPanel();
    JPanel headpanel = new JPanel();   
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int sh = (int) d.getHeight(), sw = (int) d.getWidth();
    String username,userID,userdept;
    
    
    //Panel and ScrollPane Declarations for mainpanel2..!
    JPanel updatecontent = new JPanel();
    JPanel details=new JPanel();
	JPanel academiccontent = new JPanel();
    JPanel examcontent = new JPanel();
    
    JScrollPane updatesp1= new JScrollPane(updatecontent);  
    JScrollPane academicsp1= new JScrollPane(academiccontent);
    JScrollPane examsp1= new JScrollPane(examcontent);

    
    //Constructor...!
    public loginfrm1() 
    {
        frameShow();
    }

    // Frame setup
    private void frameShow() 
    {
        frm1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frm1.setResizable(false);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.setLayout(new BorderLayout());

        frm1.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Project1\\Images\\clglogo1.png"));
        mainpanel1();
        frm1.setVisible(true);
    }

    // Header panel setup
    public void headpanel() {
        headpanel.setSize(800, 150);
        headpanel.setLayout(null);
        headpanel.setLocation((int) (sw - 800) / 2, 50);

        JLabel clgname = new JLabel("Erode Arts and Science College");
        int lb1w = 470;
        clgname.setSize(lb1w, 50);
        clgname.setForeground(new Color(199, 0, 26));
        clgname.setFont(new Font("Arial", Font.BOLD, 30));
        clgname.setLocation((780 - lb1w) / 2, 20);
        headpanel.add(clgname);

        JLabel autonomous = new JLabel("Autonomous (Co-Education), Re-Accredited by NAAC A+");
        int lb2w = 400;
        autonomous.setSize(lb2w, 20);
        autonomous.setFont(new Font("Arial", Font.BOLD, 14));
        autonomous.setLocation((780 - lb2w) / 2, 70);
        headpanel.add(autonomous);

        JLabel uniname = new JLabel("Affiliated to Bharathiar University, Coimbatore");
        int lb3w = 340;
        uniname.setSize(lb3w, 20);
        uniname.setFont(new Font("Arial", Font.BOLD, 14));
        uniname.setLocation((780 - lb3w) / 2, 90);
        headpanel.add(uniname);

        JLabel erd = new JLabel("Erode - 638009");
        int lb4w = 130;
        erd.setSize(lb4w, 20);
        erd.setFont(new Font("Arial", Font.BOLD, 14));
        erd.setLocation((780 - lb4w) / 2, 110);
        headpanel.add(erd);

        mainpanel1.add(headpanel);
    }

    // Login panel setup
    private void loginpanel() 
    {
        JPanel loginpanel = new JPanel();
        loginpanel.setBorder(new RoundedBorder(13));
        loginpanel.setSize(500, 300);
        loginpanel.setLayout(null);
        loginpanel.setBackground(new Color(230, 230, 230));
        loginpanel.setLocation((int) (sw - 500) / 2, 250);

        JLabel uidlbl = new JLabel("User-ID");
        uidlbl.setSize(100, 20);
        uidlbl.setLocation(125, 50);
        uidlbl.setFont(new Font("Arial", Font.PLAIN, 20));
        loginpanel.add(uidlbl);

        JTextField uidTF = new JTextField();
        uidTF.setSize(250, 30);
        uidTF.setLocation((500 - 250) / 2, 80);
        loginpanel.add(uidTF);

        JLabel pwlbl = new JLabel("Password");
        pwlbl.setSize(100, 20);
        pwlbl.setLocation(125, 130);
        pwlbl.setFont(new Font("Arial", Font.PLAIN, 20));
        loginpanel.add(pwlbl);

        JTextField pwTF = new JTextField();
        pwTF.setSize(250, 30);
        pwTF.setLocation((500 - 250) / 2, 160);
        loginpanel.add(pwTF);

        JButton loginbtn = new JButton("LOGIN");
        loginbtn.setSize(100, 30);
        loginbtn.setLocation((500 - 100) / 2, 220);
        loginbtn.setBackground(new Color(211, 211, 211));
        loginbtn.setBorder(new RoundedBorder(10));
        loginpanel.add(loginbtn);

        JLabel verifySuccesslbl = new JLabel("Your Id Verified. Redirecting is on the way, Please Wait..!");
        verifySuccesslbl.setSize(430, 30);
        verifySuccesslbl.setLocation(570, 600);
        verifySuccesslbl.setFont(new Font("Arial", Font.PLAIN, 16));
        verifySuccesslbl.setForeground(new Color(0, 200, 0));
        verifySuccesslbl.setVisible(false);
        mainpanel1.add(verifySuccesslbl);

        JLabel verifyfaillbl = new JLabel("Invalid ID or Password..! Try Again..!");
        verifyfaillbl.setSize(350, 30);
        verifyfaillbl.setLocation(650, 600);
        verifyfaillbl.setFont(new Font("Arial", Font.BOLD, 14));
        verifyfaillbl.setForeground(new Color(200, 0, 0));
        verifyfaillbl.setVisible(false);
        mainpanel1.add(verifyfaillbl);

        // Set up "Enter" key to trigger the login button
        loginbtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "press");
        loginbtn.getActionMap().put("press", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginbtn.doClick(); // Simulate a button click
            }
        });

        // Login button action listener
        loginbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String uid=uidTF.getText();
				String pw=pwTF.getText();
				
				try 
	            {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascdb","root","rootU");
					String q="select empname,empid,emppass from stafflogin where empid=? && emppass=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1,uid);
					ps.setString(2,pw);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next())
					{
						if(rs.getString("emppass").equals(pw))
						{
							username=rs.getString("empname");
							userID=rs.getString("empid");
				            uidTF.setEditable(false);
				            pwTF.setEditable(false);
				            loginbtn.setEnabled(false);
				            
				            verifyfaillbl.setVisible(false);
				            verifySuccesslbl.setVisible(true);
				            
				            // Timer event to redirect screen
				            Timer timer = new Timer(3000, new ActionListener() {
				            	@Override
				              	public void actionPerformed(ActionEvent evt) 
				               	{
				               		// Code to redirect to another screen..!
				   				    mainpanel1.setVisible(false);
				                    mainpanel2();
				                 }
				              });
				            timer.setRepeats(false); // Ensure the timer only runs once
				            timer.start();
						}
						else 
						{
							verifySuccesslbl.setVisible(false);
							verifyfaillbl.setVisible(true);
		                    Timer timer = new Timer(5000, new ActionListener() {
		                        @Override
		                        public void actionPerformed(ActionEvent evt) {
		                            
		                            verifyfaillbl.setVisible(false);
		                            loginbtn.setLocation((500 - 100) / 2, 220);
		                        }
		                    });
		                    timer.setRepeats(false); // Ensure the timer only runs once
		                    timer.start();
		                    
		                    pwTF.setText("");
		                    uidTF.setText("");
						}
					}//ResultSet If ends Here..!
					else
					{
						JOptionPane.showMessageDialog(frm1,"Exception Occured-","EASC",JOptionPane.INFORMATION_MESSAGE);
					}
	            } 
	            catch (ClassNotFoundException e1) 
	            {
					// TODO Auto-generated catch block
	            	JOptionPane.showMessageDialog(frm1,"Exception Occured-"+e1,"EASC",JOptionPane.INFORMATION_MESSAGE);
				} 
	            catch (SQLException e2)
	            {
					// TODO Auto-generated catch block
	            	JOptionPane.showMessageDialog(frm1,"Exception Occured-"+e2,"EASC",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

        mainpanel1.add(loginpanel);
    }

    // Profile Panel..!
    void profilepanel()
    {
        JPanel profilepanel = new JPanel();
        profilepanel.setSize(320,150);
//      profilepanel.setBackground(new Color(230,230,230));
        profilepanel.setLocation(sw-340, 10);
        profilepanel.setBorder(new RoundedBorder(10));
        profilepanel.setLayout(null);
           
        JLabel loggedin=new JLabel("Logged In");
        loggedin.setSize(100,20);
        loggedin.setLocation(40,10);
        loggedin.setForeground(new Color(255,0,0));
        profilepanel.add(loggedin);
              
        JLabel unameTF=new JLabel();
        unameTF.setText(username);
        unameTF.setSize(150,25);
        unameTF.setLocation(40,45);
        profilepanel.add(unameTF);
        
        JLabel uidTF=new JLabel();
        uidTF.setText(userID);
        uidTF.setSize(150,25);
        uidTF.setLocation(40,95);
        profilepanel.add(uidTF);
  
        //DB connection for Profile Picture..!
        String imgid="";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascdb","root","");
			String q1="select pic from staffdetails where staffid=?";
			PreparedStatement ps1=con.prepareStatement(q1);
			ps1.setString(1, userID);
			ResultSet rs1=ps1.executeQuery();
			
			JLabel profile=new JLabel("");
			if(rs1.next())
			{
		        int imgH3 = 130;
		        int imgW3 = 100;
		        profile.setSize(new Dimension(imgW3, imgH3));
		        imgid=rs1.getString("pic");
				ImageIcon ic3 = new ImageIcon(imgid);
		        Image img3 = ic3.getImage();
		        Image scImg3 = img3.getScaledInstance(imgW3, imgH3, img3.SCALE_SMOOTH);
		        profile.setIcon(new ImageIcon(scImg3));
		        profile.setBounds(200,10, imgW3, imgH3);
		        profilepanel.add(profile);
			}
			else
			{
				profile.setText("Photo Not Found..!");
			}		
		} 
        catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
     
        mainpanel2.add(profilepanel);
    }
    
    //menu-panel setup..!
    void menupanel()
    {
        JPanel menupanel=new JPanel();
        menupanel.setSize(250,sh-270);
        menupanel.setBorder(new RoundedBorder(10));
        menupanel.setBackground(new Color(230,230,230));
        menupanel.setLocation(10,180);
        menupanel.setLayout(null);
        mainpanel2.add(menupanel);

        //Label Setup..!
		JLabel menu = new JLabel("Menu");
	    menu.setSize(50,20);
	    menu.setFont(new Font("Arial black",Font.PLAIN,16));
	    menu.setLocation(100,20);
	    menupanel.add(menu);
		
        JLabel update = new JLabel("Update Profile");
        update.setSize(85,20);
        update.setLocation(83,80);
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menupanel.add(update);
     
        
        updatesp1.setSize(sw-280,sh-270);
		updatesp1.setLocation(260,180);
		updatesp1.setVisible(false);
		mainpanel2.add(updatesp1);
		
		academicsp1.setSize(sw-290,sh-270);
		academicsp1.setLocation(260,180);
		academicsp1.setVisible(false);
		mainpanel2.add(academicsp1);
		
 		examsp1.setSize(sw-290,sh-270);
 		examsp1.setLocation(260,180);
 		examsp1.setVisible(false);
 		mainpanel2.add(examsp1);

        
        update.addMouseListener(new MouseListener() 
        {
        	public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				examsp1.setVisible(false);
				academicsp1.setVisible(false);
				updatepanelContent();
			}
		});//update menu ends here..!
        
        JLabel academicDetails = new JLabel("Academic Details");
        academicDetails.setSize(100,20);
        academicDetails.setLocation(75,120);
        academicDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menupanel.add(academicDetails);
        
        academicDetails.addMouseListener(new MouseListener() 
        {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}		
			@Override
			public void mouseClicked(MouseEvent e)
			{
				examsp1.setVisible(false);
				updatesp1.setVisible(false);
				academicDetails();
			}
		});//academic details ends here..!
            
        JLabel exam = new JLabel("Exam");
        exam.setSize(30,20);
        exam.setLocation(108,160);
        exam.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menupanel.add(exam);
        
        exam.addMouseListener(new MouseListener() 
        {
			
			public void mouseReleased(MouseEvent e) {	
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				updatesp1.setVisible(false);
				academicsp1.setVisible(false);
				examScedules();
			}
		});//exam details ends here..!
        
        JLabel logout = new JLabel("Logout");
        logout.setSize(50,20);
        logout.setFont(new Font("Arial",Font.ITALIC,13));
        logout.setForeground(new Color(0,0,150));
        logout.setLocation(104,230);
        menupanel.add(logout);
        
        //Mouse Clicked Listener..!
        logout.addMouseMotionListener(new MouseMotionListener() {
        	public void mouseDragged(MouseEvent e) {	
			}
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
		});
        
        logout.addMouseListener(new MouseListener() 
        {
			
			public void mouseReleased(MouseEvent e) {	
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int res=JOptionPane.showConfirmDialog(mainpanel2, "Are you sure want to exit?","EASC",2);
				if(res==0)
				{
					System.exit(0);
				}
			}
		});
    }

    //update panel Setup..!
    void updatepanelContent()
    {       	
    	updatecontent.setLayout(null);
		updatecontent.setPreferredSize(new Dimension(500,400));
		//updatecontent.setBackground(new Color(211,211,211));
		updatesp1.setBorder(new RoundedBorder(10));	
		
		JLabel aboutlbl=new JLabel("Personal Details");
		aboutlbl.setSize(150,30);
		aboutlbl.setLocation(50,20);
		aboutlbl.setForeground(new Color(255,0,0));
		aboutlbl.setFont(new Font("Arial",Font.PLAIN,18));
		updatecontent.add(aboutlbl);
		
		JPanel pro_Photo = new JPanel();
		pro_Photo.setSize(1000,280);
		pro_Photo.setLocation(120,90);
		pro_Photo.setLayout(null);
		pro_Photo.setBorder(new RoundedBorder(10));
		pro_Photo.setBackground(new Color(230,230,230));

		
		 String imgid="",designation="",personalmail="",mob="",gender="",type="",officemail="",yoj="";
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascdb","root","");
				String q1="select * from staffdetails where staffid=?";
				PreparedStatement ps1=con.prepareStatement(q1);
				ps1.setString(1, userID);
				ResultSet rs1=ps1.executeQuery();
				
				JLabel profile=new JLabel("");
				if(rs1.next())
				{
			        int imgH = 220;
			        int imgW = 170;
			        profile.setSize(new Dimension(imgW, imgH));
			        imgid=rs1.getString("pic");
					ImageIcon ic3 = new ImageIcon(imgid);
			        Image img3 = ic3.getImage();
			        Image scImg3 = img3.getScaledInstance(imgW, imgH, img3.SCALE_SMOOTH);
			        profile.setIcon(new ImageIcon(scImg3));
			        profile.setBounds(10,15,imgW,imgH);
			        pro_Photo.add(profile);
			        
			        userdept=rs1.getString("sdept");
			        type=rs1.getString("stype");
			        mob=rs1.getString("smobile");
			        designation=rs1.getString("sdesignation");
			        personalmail=rs1.getString("semail");
			        officemail=rs1.getString("sofficemail");
			        gender=rs1.getString("sgender");
			        yoj=rs1.getString("yoj");
				}
				else
				{
					profile.setText("Photo Not Found..!");
				}		
			} 
	        catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	        
		JTextField uIDtf=new JTextField(userID);
		uIDtf.setSize(170,20);
		uIDtf.setLocation(10,250);
		uIDtf.setForeground(new Color(255,0,0));
		uIDtf.setHorizontalAlignment(uIDtf.CENTER);
		uIDtf.setEditable(false);
		pro_Photo.add(uIDtf);
		
		JSeparator sp1=new JSeparator();
		sp1.setOrientation(sp1.VERTICAL);
		sp1.setSize(4,260);
		sp1.setLocation(195,10);
		pro_Photo.add(sp1);
		
		//1st layer
		JLabel uID=new JLabel("Name");
		uID.setSize(50,20);
		uID.setLocation(220,10);
		pro_Photo.add(uID);
		
		JTextField Uname=new JTextField(username);
		Uname.setSize(150,25);
		Uname.setLocation(220,35);
		Uname.setEnabled(false);
//		Uname.setBorder(new RoundedBorder(10));
		//Uname.setBackground(new Color(230,230,230));
		Uname.setHorizontalAlignment(Uname.CENTER);
		pro_Photo.add(Uname);
		
		
		JLabel udept=new JLabel("Department");
		udept.setSize(100,20);
		udept.setLocation(220,90);
		pro_Photo.add(udept);
	
		JTextField Udept=new JTextField(userdept);
		Udept.setSize(150,25);
		Udept.setLocation(220,115);
		Udept.setEnabled(false);
//		Udept.setBorder(new RoundedBorder(10));
		//Udept.setBackground(new Color(230,230,230));
		Udept.setHorizontalAlignment(Udept.CENTER);
		pro_Photo.add(Udept);
		
		JLabel utype=new JLabel("Teaching Type");
		utype.setSize(150,25);
		utype.setLocation(220,170);
		pro_Photo.add(utype);
		
		JTextField Utype=new JTextField(type);
		Utype.setSize(150,25);
		Utype.setLocation(220,195);
//		Utype.setBorder(new RoundedBorder(10));
		//Utype.setBackground(new Color(230,230,230));
		Utype.setHorizontalAlignment(Utype.CENTER);
		Utype.setEnabled(false);
		pro_Photo.add(Utype);
		
		
		//2nd Layer
		JLabel udesignation=new JLabel("Designation");
		udesignation.setSize(100,20);
		udesignation.setLocation(500,10);
		pro_Photo.add(udesignation);
		
		JTextField Udesignation=new JTextField(designation);
		Udesignation.setSize(150,25);
		Udesignation.setLocation(500,35);
		Udesignation.setEnabled(false);
//		Udesignation.setBorder(new RoundedBorder(10));
		//Udesignation.setBackground(new Color(230,230,230));
		Udesignation.setHorizontalAlignment(Udesignation.CENTER);
		pro_Photo.add(Udesignation);
		
		
		JLabel umob=new JLabel("Contact");
		umob.setSize(50,20);
		umob.setLocation(500,90);
		pro_Photo.add(umob);
		
		JTextField Umob=new JTextField(mob);
		Umob.setSize(150,25);
		Umob.setLocation(500,115);
		Umob.setEnabled(false);
//		Umob.setBorder(new RoundedBorder(10));
		//Umob.setBackground(new Color(230,230,230));
		Umob.setHorizontalAlignment(Umob.CENTER);
		pro_Photo.add(Umob);
		
		JLabel umail=new JLabel("Personal Mail");
		umail.setSize(150,20);
		umail.setLocation(500,170);
		pro_Photo.add(umail);
		
		JTextField Umail=new JTextField(personalmail);
		Umail.setSize(150,25);
		Umail.setLocation(500,195);
		Umail.setEnabled(false);
//		Umail.setBorder(new RoundedBorder(10));
		//Umail.setBackground(new Color(230,230,230));
		Umail.setHorizontalAlignment(Umail.CENTER);
		pro_Photo.add(Umail);
		
		//3nd Layer
		JLabel ugender=new JLabel("Gender");
		ugender.setSize(80,20);
		ugender.setLocation(800,10);
		pro_Photo.add(ugender);
		
		JTextField Ugender=new JTextField(gender);
		Ugender.setSize(150,25);
		Ugender.setLocation(800,35);
		Ugender.setHorizontalAlignment(Ugender.CENTER);
		Ugender.setEnabled(false);
//		Ugender.setBorder(new RoundedBorder(10));
		//Ugender.setBackground(new Color(230,230,230));
		pro_Photo.add(Ugender);
				
		JLabel uyoj=new JLabel("Year of Joining");
		uyoj.setSize(150,20);
		uyoj.setLocation(800,90);
		pro_Photo.add(uyoj);
		
		JTextField Uyoj=new JTextField(yoj);
		Uyoj.setSize(150,25);
		Uyoj.setLocation(800,115);
//		Uyoj.setBorder(new RoundedBorder(10));
		//Uyoj.setBackground(new Color(230,230,230));
		Uyoj.setHorizontalAlignment(Uyoj.CENTER);
		Uyoj.setEnabled(false);
		pro_Photo.add(Uyoj);
			
		JLabel uofficemail=new JLabel("Office Mail");
		uofficemail.setSize(150,20);
		uofficemail.setLocation(800,170);
		pro_Photo.add(uofficemail);
		
		JTextField Uofficemail=new JTextField(officemail);
		Uofficemail.setSize(150,25);
//		Uofficemail.setBackground(new Color(230,230,230));
//		Uofficemail.setBorder(new RoundedBorder(10));
		Uofficemail.setHorizontalAlignment(Uofficemail.CENTER);
		Uofficemail.setLocation(800,195);
		Uofficemail.setEnabled(false);
		pro_Photo.add(Uofficemail);

    	JLabel updationtrue= new JLabel("Your Record Updated Successfully..!");
    	updationtrue.setSize(350,25);
		updationtrue.setForeground(new Color(0,255,0));
		updationtrue.setLocation(500,450);
		updationtrue.setFont(new Font("Arial",Font.ITALIC,18));
		updationtrue.setVisible(false);
		updatecontent.add(updationtrue);
		
		JLabel updationfalse= new JLabel("Your Record Updated Faild..!");
		updationfalse.setSize(350,25);
		updationfalse.setForeground(new Color(255,0,0));
		updationfalse.setLocation(500,450);
		updationfalse.setFont(new Font("Arial",Font.ITALIC,18));
		updationfalse.setVisible(false);
		updatecontent.add(updationfalse);
		
		JButton save=new JButton("Save");
		save.setSize(150,25);
		save.setBorder(new RoundedBorder(5));
		save.setLocation(800,245);
		save.setFont(new Font("Arial",Font.PLAIN,14));
		save.setBackground(new Color(230,230,230));
		save.setVisible(false);
		save.setForeground(new Color(255,0,0));
		pro_Photo.add(save);
		
		save.addActionListener(new ActionListener() {
			
			String ofmail="",permail="",mob="",designation="",type="",dept="";
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ofmail=Uofficemail.getText();
				permail=Umail.getText();
				mob=Umob.getText();
				designation=Udesignation.getText();
				type=Utype.getText();
				dept=Udept.getText();
				
				int result=JOptionPane.showConfirmDialog(updatecontent, "Are You sure Want make a changes?","EASC",2);
				if(result==0)
				{
					try 
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascdb","root","");
						String q2="update staffdetails set sofficemail=? ,semail=?,stype=?,smobile=?,sdept=?,sdesignation=? where staffid=?";
						PreparedStatement ps2=con.prepareStatement(q2);
						ps2.setString(1, ofmail);
						ps2.setString(2, permail);
						ps2.setString(3, type);
						ps2.setString(4, mob);
						ps2.setString(5, dept);
						ps2.setString(6, designation);
						ps2.setString(7, userID);
						int res=ps2.executeUpdate();
						
						if(res==1)
						{
							
							updationfalse.setVisible(false);
							updationtrue.setVisible(true);
							Timer timer = new Timer(5000, new ActionListener() {
		                        @Override
		                        public void actionPerformed(ActionEvent evt) 
		                        {
		    							updationtrue.setVisible(false);
		    							Uofficemail.setEnabled(false);
		    							Umail.setEnabled(false);
		    							Umob.setEnabled(false);
		    							Udesignation.setEnabled(false);
		    							Utype.setEnabled(false);
		    							Udept.setEnabled(false);
		    							save.setVisible(false);
		                        }
		                    });
		                    timer.setRepeats(false); // Ensure the timer only runs once
		                    timer.start();
							
							
						}
						else
						{
							updationfalse.setVisible(true);
							Timer timer = new Timer(3000, new ActionListener() {
		                        @Override
		                        public void actionPerformed(ActionEvent evt) 
		                        {
		    							updationfalse.setVisible(false);
		                        }
		                    });
		                    timer.setRepeats(false); // Ensure the timer only runs once
		                    timer.start();
						}
						
						
					}
					 catch (ClassNotFoundException e2) 
					{
							// TODO Auto-generated catch block
							e2.printStackTrace();
					} 
				    catch (SQLException e3) 
					{
				    	// TODO Auto-generated catch block
							e3.printStackTrace();
					} 
				}
				else
				{
					System.out.println(result);
				}
			}
		});
		
		JLabel editbtn=new JLabel();
		editbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editbtn.setSize(new Dimension(20,20));
		ImageIcon editlogo=new ImageIcon("D:\\Project1\\Images\\editlogo.png");
		Image editlogoimg=editlogo.getImage();
		Image scalededitlogo=editlogoimg.getScaledInstance(20, 20, editlogoimg.SCALE_SMOOTH);
		editbtn.setIcon(new ImageIcon( scalededitlogo));
		editbtn.setBounds(130,390,20,20);
		updatecontent.add(editbtn);
		
		JLabel editlb=new JLabel("Edit");
		editlb.setSize(50,20);
		editlb.setLocation(150,390);
		editlb.setFont(new Font("Arial",Font.ITALIC,14));
		editlb.setForeground(new Color(0,0,255));
		editlb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updatecontent.add(editlb);
		
		editbtn.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Uofficemail.setEnabled(true);
				Umail.setEnabled(true);
				Umob.setEnabled(true);
				Udesignation.setEnabled(true);
				Utype.setEnabled(true);
				Udept.setEnabled(true);
				save.setVisible(true);
			}
		});
		
		editlb.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Uofficemail.setEnabled(true);
				Umail.setEnabled(true);
				Umob.setEnabled(true);
				Udesignation.setEnabled(true);
				Utype.setEnabled(true);
				Udept.setEnabled(true);
				save.setVisible(true);
			}
		});
		
		updatecontent.add(pro_Photo);
		updatesp1.setVisible(true);
    }

   
    //academic Setup..!
    void academicDetails()
    {  
    	academiccontent.setLayout(null);
	    academiccontent.setPreferredSize(new Dimension(500,5000));
	    academiccontent.setBackground(new Color(2,211,211));
	    academicsp1.setBorder(new RoundedBorder(10));
	    academicsp1.setVisible(true);
    }
    
    //examSchedule Setup..!
    void examScedules()
    {
    	examcontent.setLayout(null);
 		examcontent.setPreferredSize(new Dimension(500,sh-310));
 		examcontent.setBackground(new Color(211,2,211));
 		examsp1.setBorder(new RoundedBorder(10));
 		examsp1.setVisible(true);
    }
    
    
    // Main panel for the 2nd page..!
    public void mainpanel2() 
    {
    	profilepanel();
    	menupanel();
    	mainpanel2.setSize(sw, sh);
        mainpanel2.setLayout(null);
        headpanel.setLocation(0, 0);

        int imgW = 90, imgH = 90;
        JLabel icon1 = new JLabel();
        icon1.setSize(new Dimension(imgW, imgH));
        ImageIcon ic1 = new ImageIcon("D:\\GUI_Projects\\Images\\clglogo1.png");
        Image img1 = ic1.getImage();
        Image scImg1 = img1.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
        icon1.setIcon(new ImageIcon(scImg1));
        icon1.setBounds(20, 10, imgW, imgH);
        headpanel.add(icon1);

        // 2nd Logo Setup
        int imgH2 = 140;
        int imgW2 = 140;
        JLabel icon2 = new JLabel();
        icon2.setSize(new Dimension(imgW2, imgH2));
        ImageIcon ic2 = new ImageIcon("D:\\GUI_Projects\\Images\\clglogo2.png");
        Image img2 = ic2.getImage();
        Image scImg2 = img2.getScaledInstance(imgW2, imgH2, Image.SCALE_SMOOTH);
        icon2.setIcon(new ImageIcon(scImg2));
        icon2.setBounds(630, -10, imgW2, imgH2);
        headpanel.add(icon2);

        mainpanel2.add(headpanel);

        frm1.add(mainpanel2); 
    }

    // Main panel for 1st page..!
    public void mainpanel1() 
    {
        mainpanel1.setSize(sw, sh);
        mainpanel1.setLayout(null);
        headpanel();
        loginpanel();
        frm1.add(mainpanel1);
    }

    // Main method
    public static void main(String[] args) {
        new loginfrm1();
    }
}

class RoundedBorder implements Border {
    private final int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 2, radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

