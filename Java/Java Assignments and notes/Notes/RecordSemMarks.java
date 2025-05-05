package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RecordSemMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","");
			
			String semester;
			
			System.out.print("\n\tEnter the semester number(Roman Letter): ");
			semester=sc.next();
			
			String q="select * from subjectlist where sem=?";
			
			PreparedStatement ps=con.prepareStatement(q,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ps.setString(1, semester);
			
			ResultSet rs=ps.executeQuery();
		
			int count=0;
		
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					count++;
				}
			}
			else
			{
				System.out.print("\n\tNo Record Found");
			}
			
			System.out.print("\n\tNumber of subjects is sem "+semester+" is: "+count);
			
			String stuid;
			
			System.out.print("\n\tEnter the Student Id: ");
			stuid=sc.next();
			
			int marks[]=new int[count];
			int total=0;
			float avg=0;
			
			for(int i=0;i<count;i++) {
				System.out.print("\n\tEnter mark["+(i+1)+"]: ");
				marks[i]=sc.nextInt();
				total=total+marks[i];
			}
		
			avg=(float)total/count;
			
			System.out.print("\n\tTotal: "+total);
			System.out.print("\n\tAvg: "+Math.round(avg));
			
			q="insert into semestermarks(stuid,sem,s1,s2,s3,s4,s5,s6,s7,average)values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps1=con.prepareStatement(q);
			
			ps1.setString(1, stuid);
			ps1.setString(2, semester.toUpperCase());
			for(int i=3,j=0;i<=(count+2);i++,j++) {
				ps1.setInt(i, marks[j]);
			}
			ps1.setFloat(10, Math.round(avg));
			
			ps1.execute();
			
			System.out.print("\n\tSemester Marks Recorded Successfully");
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
