package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class table1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try 
      { 
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306:/bharani","root",""); 
    	  int rollno,terms,i;
    	  String stuid,stuname,stumail,stumob,stuadd,studept,stucity,stucourse;
    	  Scanner s1=new Scanner(System.in);
    	  System.out.print("Enter the inserting terms:" );
    	  terms=s1.nextInt();
    	  for(i=1;i<terms;i++)
    	  {
    		  System.out.println("Enter the Student Rollno:");
    		  rollno=s1.nextInt();
    		  
    		  System.out.println("Enter the Student id:");
    		  stuid=s1.next();
    		  
    		  System.out.println("Enter the Student Name :");
    		  stuname=s1.next();
    		  
    		  System.out.println("Enter the Student Mailid:");
    		  stumail=s1.next();
    		  
    		  System.out.println("Enter the Student MobileNumber");
    		  stumob=s1.next();
    		  
    		  System.out.println("Enter the Address of the Student:");
    		  stuadd=s1.next();
    		  
    		  System.out.println("Enter the City of the Student:");
    		  stucity=s1.next();
    		  
    		  System.out.println("Enter the Department of the Student:");
    		  studept=s1.next();
    		  
    		  System.out.println("Enter the coure of Student:");
    		  stucourse=s1.next();  
    		  
    		  String query="insert into studentstable (rollno,stuid,stuname,stumail,stumob,stuadd,stucity,studept,stucourse)value(?,?,?,?,?,?,?,?,?)";
    		      		   
    		  PreparedStatement ps=c1.prepareStatement(query);
    		 
    		  ps.setInt(1,rollno);
    		  ps.setString(2,stuid);
    		  ps.setString(3,stuname);
    		  ps.setString(4,stumail);
    		  ps.setString(5,stumob);
    		  ps.setString(6,stuadd);
    		  ps.setString(7,stucity);
    		  ps.setString(8,studept);
    		  ps.setString(9,stucourse);
    		  
    		  ps.execute();
    		  
       	  }
       }
       catch(Exception e)
       {
    	   System.out.println("Exception Occured..."+e);  
       }
	   }

}
