package collegePrj;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbCon {

	public static void main(String[] args) 
	{
		int rollno;
		DataInputStream dis = new DataInputStream(System.in);
		
		try
		{
			//JDBC Connection making ..!
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","");
			
			System.out.println("How many records insert into the Database: ");
			int rec = Integer.parseInt(dis.readLine());
			
			for(int i = 1; i<=rec;i++)
			{
				//Values getting i runtime..!
				
				System.out.println("Enter the Student rollno: ");
				rollno =Integer.parseInt(dis.readLine());
				System.out.println("Enter the Student ID: ");
				String id =dis.readLine();
				System.out.println("Enter the Student Name: ");
				String name = dis.readLine();
				System.out.println("Enter the Student E-Mail ID: ");
				String mail = dis.readLine();
				System.out.println("Enter the Student Mobile No: +91 ");
				String mob = dis.readLine();
				System.out.println("Enter the Student Address: ");
				String address = dis.readLine();
				System.out.println("Enter the Student City: ");				
				String city = dis.readLine();
				System.out.println("Enter the Student Department: ");
				String dept = dis.readLine();
				System.out.println("Enter the Student Course: ");
				String course = dis.readLine();
				
				//Records Insert into the DB
				if((id!=null)&&(name!=null)&&(mail!=null)&&(mob!=null)&&(address!=null)&&(city!=null)&&(dept!=null)&&(course!=null))
				{
					String q = "insert into studentstable(rollno,stuid,stuname,stuemail,stumob,stuadd,stucity,studept,stucourse)values(?,?,?,?,?,?,?,?,?)";
					
					//Values set into their types and execute the query..!
					
					PreparedStatement ps = con.prepareStatement(q);
					ps.setInt(1, rollno);
					ps.setString(2,id);
					ps.setString(3,name);
					ps.setString(4,mail);
					ps.setString(5,mob);
					ps.setString(6,address);
					ps.setString(7,city);
					ps.setString(8,dept);
					ps.setString(9,course);
					ps.execute();
					
					System.out.println(i+" Record Inserted");
				}
				else
				{
					System.out.print("\n\tRecords Mismatch");
				}
				
			}
			
			con.close();
		} 
		
		
		catch(IOException e)
		{
			//Catch block for IO Exception..!
			System.out.println("EXCEPTION OCCURED: "+e);
		}
		
		
		catch(SQLException s)
		{
			//Catch block for SQL..!
			System.out.print("SQL EXCEPTION OCCURED: "+s);
			
		} 
		
		
		catch (ClassNotFoundException c)
		{
			// Catch block for Class class..!
			System.out.println("EXCEPTION OCCURED: "+c);
		}
		
		catch(NumberFormatException n)
		{
			//Catch block for Input mismatch 
			System.out.println("EXCEPTION OCCURED: "+n);
		}
	}

}
