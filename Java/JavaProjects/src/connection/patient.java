package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class patient {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int sno;
		String name,disease,ward,mob;
		
		
		System.out.println("\t Welcome to ABC Hospital..!");
		System.out.println("Patients Details DB");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java830","root","");
			
			
			System.out.print("How many Records Insert into DB: ");
			int rec = s.nextInt();
			
			if(rec>0)
			{
				for(int i = 0;i<=rec;i++)
				{
					System.out.println("\nEnter the Seriel No: ");
					sno = s.nextInt();
					System.out.println("\nEnter the Patient Name: ");
					name = s.next();
					System.out.println("\nEnter the Patient Disease: ");
					disease = s.next();
					System.out.println("\nEnter the Patient Ward_No: ");
					ward = s.next();
					System.out.println("\nEnter the Patient Mob_NO: ");
					mob = s.next();	
					
					//Data Insertion..!
					
					if((sno>0) && (name!=null) && (disease!=null) && (ward!=null) && (mob!=null))
					{
						String q = "insert into patient(sno,name,disease,ward_no,mob)values(?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(q);
						ps.setInt(1, sno);
						ps.setString(2, name);
						ps.setString(3, disease);
						ps.setString(4, ward);
						ps.setString(5, mob);
						
						ps.execute();
						System.out.println("\t"+(i+1)+" Record Insertion Success..!");
						
					}
					else
					{
						System.out.print("Invalid Data Insertion..!");
					}
				}
			}
			else
			{
				System.out.println("Give the Value of insertion Records..! please try again..");
			}
			
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception Occured: "+e);
		}
		
		s.close();
	}

}
