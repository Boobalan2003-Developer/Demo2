import java.util.*;

class Students
{ 
   // This method is Calculate and print the Marks Details
   
  void aggregate(int a, int b, int c, int d, int e)
  {
    int total;
    total=a+b+c+d+d;
    float avg;
    avg=total/5.0f;
    System.out.println("\n  Aggregate ");
    System.out.println("\n*************");
    System.out.println("\nTotal is: "+total);
    System.out.println("\nAverage is: "+avg);
    System.out.println("\n*************");
  }

   // This method is print the student Details

  void details(String name, String rollno)
  { 
    System.out.println("\n  Details ");
    System.out.println("\n***********");
    System.out.println("\n Student Name: "+name);
    System.out.println("\n Student RollNo: "+rollno);
    System.out.println("\n***********");
 
  }

  public static void main(String args[])
  { 
    String name,rollno;
    int a,b,c,d,e;
    Scanner sa = new Scanner(System.in);
    System.out.println("\t  Students Details");
    System.out.println("\n*****************************"); 
    System.out.println("Enter The Student Name: ");
    name = sa.nextLine();
    System.out.println("Enter The Student RollNo: ");
    rollno = sa.nextLine();
    System.out.println("Enter The Mark 1: ");
    a = sa.nextInt();
    System.out.println("Enter The Mark 2: ");
    b = sa.nextInt();
    System.out.println("Enter The Mark 3: ");
    c = sa.nextInt();
    System.out.println("Enter The Mark 4: ");
    d = sa.nextInt();
    System.out.println("Enter The Mark 5: ");
    e = sa.nextInt();
    Students s1 = new Students();
    s1.details(name,rollno);
    s1.aggregate(a,b,c,d,e);
  
  }
}