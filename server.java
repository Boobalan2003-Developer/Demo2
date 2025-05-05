import java.io.*;
import java.net.*;

public class server {
    public static void main(String args[]) throws IOException
    {
        System.out.println("Server is Running");
        ServerSocket ss=new ServerSocket(4002);
        Socket s=ss.accept();
	System.out.println("Client Request accepted..!");
	PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
	BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
	pr.println("Hi..! This is Server...");
	System.out.println("\nMesege From Client: "+in.readLine());
    }
}
