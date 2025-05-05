package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Sem{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s1=new Scanner(System.in);
	     
         try 
         {
          Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306:/bharani","root","");
		  String query1="create table semestermarks";
		} 
         catch (Exception e)
          {
			System.out.println("Exception Occured..."+e);
          }
    	
	}

}
