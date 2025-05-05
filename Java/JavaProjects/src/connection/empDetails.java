package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class empDetails {

	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome to ABC Hospital..!");
		System.out.println("Doctors Details DB");
		
		
		//Value Getting..!
		System.out.print("\n Enter Your Employee ID: ");
		String id = s.next();
		System.out.print("\n Enter Your Employee Name: ");
		String name = s.next();
		System.out.print("\n Enter Your Employee Designation: ");
		String designation = s.next();
		System.out.print("\n Enter Your Employee Role: ");
		String role = s.next();
		
		if((name!=null)&& (id!=null) && (designation!=null))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java830","root","");
				String q="insert into abchospital (empid,empname,designation,role) value(?,?,?,?) ";
				
				PreparedStatement ps = con.prepareStatement(q);
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, designation);
				ps.setString(4,role);
				
				ps.execute();
				System.out.println("\n 1 Record Insertion Success..!");
				con.close();
			}

			catch(Exception e)
			{
				System.out.print("\nException Occured: "+e);
			}
		}
		else
		{
			System.out.println("Invalid Record Insertion..! Please Try Again..!");
		}
		
	s.close();		
	}

}
