import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
			boolean Test = true;
		
		ServerSocket server = new ServerSocket(9090);
		while (Test == true) {
			//System.out.println("Waiting for client message");
			Socket client = server.accept();
			DataInputStream inFromStream = new DataInputStream(client.getInputStream());
			String text = inFromStream.readUTF();
			//System.out.println(text);
			WriteToFile(text);
			DataOutputStream OutToStream  = new DataOutputStream(client.getOutputStream());
			OutToStream.writeUTF("Message Received");
			
			inFromStream.close(); 
            OutToStream.close();
            client.close();
			if(text.equalsIgnoreCase("exit")) break; 
							
		}
		}
	
	public static void WriteToFile(String Message) {
		String fileName = "DataTest.txt";
		System.out.println(Message);
		try {
		FileWriter fout = new FileWriter(fileName,true);
		PrintWriter pout = new PrintWriter(fout,false);
		pout.println(Message);
		pout.close();
		}
		catch (IOException e) {
			
		}
	}
}
