// Server-Side 

import java.io.*;
import java.net.*;

class Server{
	private static final int PORT = 5500;
	public static void main(String args[]){
		//try (ServerSocket ss = new ServerSocket(4444)){
		//	System.out.println("Server is listening on port 4444...");
		//	
		//	Socket socket = ss.accept();
		//	System.out.println("Client Connected!...");
		//	
		//	InputStream input = socket.getInputStream();
		//	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		//	
		//	OutputStream output = socket.getOutputStream();
		//	PrintWriter Writer = new PrintWriter(output,true);
		//	
		//	String msg = reader.readLine();
		//	System.out.println("Received From Client : "+msg);
		//	
		//	Writer.println("Hello! Client");
		//	
		//	socket.close();
		//}catch(IOException e){
		//	e.printStackTrace();
		//	
		//}
		
		
		try(ServerSocket ss = new ServerSocket(PORT)){
			System.out.println("Server is listening on port : "+PORT+" ...");
			try(Socket client = ss.accept()){
				System.out.println("Client is Online...");
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				
				String msg;
				while( (msg = in.readLine())!=null){
					System.out.println("Client : "+msg);
					out.println("Server : "+msg);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}