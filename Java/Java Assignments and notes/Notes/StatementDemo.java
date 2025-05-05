package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class StatementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			int id;
			String username,pass;
			
			Scanner s1=new Scanner(System.in);
			
			System.out.print("\n\tEnter the idno: ");
			id=s1.nextInt();
			
			System.out.print("\n\tEnter the name: ");
			username=s1.next();
			
			System.out.print("\n\tEnter the password: ");
			pass=s1.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830","root","");
			
			//String query="insert into demo(idno,stuname,stupass)value(101,'ARUN','123456')";
			String query="insert into demo(idno,stuname,stupass)value(?,?,?)";
			
			//Statement stmt=con.createStatement();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, pass);
			boolean result=ps.execute();
			
			
			//boolean result=stmt.execute(query);
		
			System.out.print("\n\tresult = "+result);
			if(result) {
				System.out.print("\n\tUser Data Inserted");
			}
			else {
				System.out.print("\n\tUser Data Insertion Failed");
			}
			
			con.close();
			
		}
		catch(Exception e) {
			System.out.print("\n\tUser Data Insertion Failed. "+e);
		}
	}

}
