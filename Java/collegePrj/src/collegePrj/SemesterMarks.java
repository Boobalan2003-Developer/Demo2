package collegePrj;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SemesterMarks {
	
	
	void DBConnection(String sem)
	{
		DataInputStream dis = new DataInputStream(System.in);
		int count=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","");
			System.out.println("Connection Success..!");
			
			String q = "select * from semestermarks where sem = ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1,sem);
			ResultSet rs = ps.executeQuery();
			
			for(int i = 1;i<=10;i++)
			{
				if(rs.next())
				{
					//System.out.println(rs.getRow());
					count++;
				}
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("\n\t Exception Occured: "+e);
		}
	}
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub\
		SemesterMarks sm = new SemesterMarks();
		String sem;
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("\t\t\tEASC-ERODE");
		System.out.println("\n Enter the Semester Number(In Roman Letter..\n\tEg..!(I,II,III,IV,V,VI)):");
		sem = dis.readLine();
		
		sem = sem.toUpperCase();
		switch(sem)
		{
			case "I":
			{
				System.out.println("I - st Sem");
				sm.DBConnection(sem);
				break;
			}
			case "II":
			{
				System.out.println("II - st Sem");
				break;
			}
			case "III":
			{
				System.out.println("III - st Sem");
				break;
			}
			case "IV":
			{
				System.out.println("IV - st Sem");
				break;
			}
			case "V":
			{
				System.out.println("V - st Sem");
				break;
			}
			case "VI":
			{
				System.out.println("VI - st Sem");
				break;
			}
			default:
			{
				System.out.println("Invalid Value..!");
				break;
			}
			
		}
		
	}

}
