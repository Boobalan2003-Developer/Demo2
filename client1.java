import java.io.*;
import java.net.*;

public class client1 {
    public static void main(String args[])throws Exception
    {
        System.out.println("Client is Running");
        Socket s=new Socket("127.0.0.1",4002); 
        System.out.println("Our Request Accepted..!"); 
	PrintWriter pr=new PrintWriter(s.getOutputStream(),true);	
	BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	pr.println("Hi..! This is Client1 Machine.. Thank You For accept the Request..!");
	System.out.println("\nMesege From Server: "+in.readLine());      
    }
    
}

