import java.io.DataInputStream;
import java.time.LocalDateTime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Station1 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
			double[] Data = {0,0,0,0};
			Data =calcData(Data);
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
	            OutToStream.writeUTF("Station 1"+ " Time: "+currTime +" Temperature: "+Data[0] +" Wind speed: "+Data[1] +" Humidity "+Data[2] + " Soil Saturation: "+Data[3]);
	            Data =calcData(Data);
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
		
	public static double[] calcData(double[] currData) {
		double min;
		double value;
		double[] newData = new double[10];
		Random randomGen = new Random();
		for (int i = 0; i<4;i++) {
			double max = currData[i]+5;
			if (currData[i] > 0) {
				 min = currData[i]-5; }
			
			else {min = currData[i]; }
			
			value = min + (max - min) * randomGen.nextDouble();
			newData[i] = value;
		}
		return newData;
	}
}
