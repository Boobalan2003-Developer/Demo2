package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack830","root","");
			System.out.print("\n\tDatabase connection success");
			
			String q="create table demo(idno int, stuname varchar(30),stupass varchar(30))";
			
			Statement stmt=con.createStatement();
			
			stmt.execute(q);
			
			System.out.print("\n\tTable created");
			
			
		}
		catch(SQLException e) {
			System.out.print("\n\tError in SQL Execution. "+e);
		}
		catch(Exception e) {
			System.out.print("\n\tDatabase connection Failed");
		}
			
		
	}

}
