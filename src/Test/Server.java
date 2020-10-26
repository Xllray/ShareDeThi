package Test;

import DTO.MonHocDTO;
import java.net.*;
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server 
{ 
    private Socket socket = null;
    private ServerSocket server = null; 
    BufferedWriter out = null;
    BufferedReader in = null;
   
    ObjectInputStream ObjIn = null;
    
    public Server(int port) 
    { 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
            System.out.println("Waiting for a client ..."); 
            socket = server.accept(); 
            System.out.println("Client accepted"); 
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            InputStream inputStream = socket.getInputStream();
            String line = "";
            
            ObjIn  = new ObjectInputStream(inputStream);
            
            try 
                    {
                        //obj = (ChuDe) ObjIn.readObject();
                        MonHocDTO chude = (MonHocDTO) ObjIn.readObject();
                        System.out.println("Ma Chu De: "+chude.getMaMonHoc());
                    } catch (ClassNotFoundException ex) 
                    {
                        System.err.println(ex);
                    }
            
            /*while (!line.equals("Bye")) 
            { 
                try
                { 
                    line = in.readLine();
                }
                
                catch(IOException i) 
                { 
                    System.err.println(i); 
                } 
            } 
            System.out.println("Closing connection..."); 
            
            in.close(); 
            out.close();*/
            socket.close(); 
            server.close();
            System.out.println("Server is closed");
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        Server server = new Server(5000); 
    } 
}