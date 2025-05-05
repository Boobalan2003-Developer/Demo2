import java.io.*;

class ReadValues
{
  public static void main(String args[])throws Exception
  {
    DataInputStream dis = new DataInputStream(System.in);
    System.out.println("\n\t Assignment - 1");
    System.out.println("\n\t***************");
    String name, address, email, birthplace;
    long mob;
    System.out.println("Enter Your Name: ");
    name = dis.readLine();
    System.out.println("\n Enter Your Address: ");
    address = dis.readLine(); 
    System.out.println("\n Enter Your Mail-Id: ");
    email = dis.readLine();
    System.out.println("\n Enter Your BirthPlace: ");
    birthplace = dis.readLine();  
    System.out.println("\n Enter Your Mobile Number: ");
    mob = Long.parseLong(dis.readLine());
    System.out.print("\n\n\t Name: "+name);
    System.out.print("\n\n\t Address: "+address);
    System.out.print("\n\n\t Mail-Id: "+email);
    System.out.print("\n\n\t Birth place: "+birthplace);
    System.out.print("\n\n\t Mobile No: "+mob+"\n");   
  }
}