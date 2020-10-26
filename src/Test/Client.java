package Test;

import DTO.MonHocDTO;
import java.net.*;
import java.io.*; 

public class Client 
{ 
	private Socket socket = null; 
	BufferedWriter out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null;
        
        ObjectOutputStream ObjOut = null;
        MonHocDTO chude=new MonHocDTO(1,"Toan","Bo mon toan hoc",1);

	public Client(String address, int port) throws UnknownHostException, IOException
	{ 
		socket = new Socket(address, port); 
		System.out.println("Connected"); 
		//out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//stdIn = new BufferedReader(new InputStreamReader(System.in));
                
                OutputStream outputStream = socket.getOutputStream();
                ObjOut = new ObjectOutputStream(outputStream);
                
                ObjOut.writeObject(chude);

		/*String line = "";
                String line2;
		while (!line.equals("Bye")) 
		{ 
			line = stdIn.readLine();
			System.out.println("Client sent: " + line);
		}
		in.close(); 
		out.close();*/ 
		socket.close(); 
                System.out.println("Client is closed");
	} 

	public static void main(String args[]) throws UnknownHostException, IOException 
	{ 
		Client client = new Client("127.0.0.1", 5000); 
	} 
} 
