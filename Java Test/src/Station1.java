import java.io.DataInputStream;
import java.time.LocalDateTime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Station1 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
			InetAddress host = InetAddress.getLocalHost();
			Socket socket = null;	
			DataInputStream inFromStream = null;
			DataOutputStream OutToStream  = null;
			while(true){
				LocalDateTime currTime = LocalDateTime.now();
	            //establish socket connection to server
	            socket = new Socket(host.getHostName(), 9090);
	            //write to socket using ObjectOutputStream
	            OutToStream = new DataOutputStream(socket.getOutputStream());
	            System.out.println("Sending request to Socket Server");
	            //if(i==4)OutToStream.writeUTF("exit");
	            OutToStream.writeUTF(" "+ " Time: "+currTime);
	            //read the server response message
	            inFromStream = new DataInputStream(socket.getInputStream());
	            String message = (String) inFromStream.readUTF();
	            System.out.println("Message: " + message );
	            //close resources
	            inFromStream.close();
	            OutToStream.close();
	            Thread.sleep(1000);
	        }


		}
		
	public static String[] calcData(String[] currData) {
		

	}
