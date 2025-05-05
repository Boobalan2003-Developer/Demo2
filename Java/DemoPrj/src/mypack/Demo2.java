package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner s1=new Scanner(System.in);
           try
           {
        	   int i,rows;
        	   Class.forName("com.mysql.cj.jdbc.Driver");
        	   Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bharani","root","");
        	   System.out.println("Enter the insert rows:");
        	   rows=s1.nextInt();
        	   for(i=0;i<rows;i++)
        	   {
        		   System.out.println("Enter the Employee no :");
        		   int eno=s1.nextInt();
        		   System.out.println("Enter the Employee Name :");
        		   String name=s1.next();
        		   System.out.println("Enter the salary of employee :");
        		   int salary=s1.nextInt();
        		   System.out.println("Enter the field of Employee :");
        		   String field=s1.next();
        		   System.out.println("Enter the Experience year of a Employee :");
        		   int experience=s1.nextInt();
        		   System.out.println("Enter the joining year of a Employee:");
        		   int jyear=s1.nextInt();

            	   String query="insert into employee(eno,ename,esal,efield,exyear,ejy)value(?,?,?,?,?,?)";
            	   PreparedStatement ps=c1.prepareStatement(query);
            	   ps.setInt(1,eno);
            	   ps.setString(2,name);
            	   ps.setInt(3,salary);
            	   ps.setString(4,field);
            	   ps.setInt(5,experience);
            	   ps.setInt(6,jyear);
            	   ps.execute();
        	   }
        	   System.out.println( " value inserted Succesfully..");
        	   c1.close();
           }
           catch(Exception e)
           {
        	   System.out.println("connection failed "+e);
           }
           
	    }

}
