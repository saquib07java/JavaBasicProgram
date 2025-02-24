// Clien-Side

import java.io.*;
import java.net.*;
class Client {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 5500;
	public static void main (String args[]){
		//String hostname = "127.0.0.1";
		//int port = 4444;
		//try(Socket socket = new Socket(hostname,port)){
		//	 
		//	OutputStream output = socket.getOutputStream();
		//	PrintWriter writer = new PrintWriter(output,true);
		//
		//	InputStream input = socket.getInputStream(); 
		//	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		//	
		//	writer.println("Hello Server!...");
		//	String response = reader.readLine();
		//	System.out.println("Received From Server : "+response);
		//	
		//	socket.close();
		//}catch(UnknownHostException e){
		//	e.printStackTrace();
		//}catch(IOException e){
		//	e.printStackTrace(); 
		//}
		
		try(Socket socket = new Socket(HOST,PORT);
		BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){
			System.out.print("Connected To The Server...\nType Your Message : ");
			String ui;
			while( (ui=cr.readLine())!=null ){
				out.println(ui);
				System.out.println(in.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
