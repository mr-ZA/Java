import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class Client 
{
	public static void main(String[] args) {
		String host= "127.0.0.1";
		int port = 8000;
		
		try (
				Socket sock = new Socket(host, port);
				
				OutputStream streamW = sock.getOutputStream();
				OutputStreamWriter streamWriter = new OutputStreamWriter(streamW);
				BufferedWriter writer = new BufferedWriter(streamWriter);
				
				InputStream streamR = sock.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(streamR));
				) {
				
			System.out.println("Connected to server succesfully!");
			
			String request = "Ufa";
			System.out.println(request);
			
			writer.write(request);
			writer.newLine();
			writer.flush();
			
			String response = reader.readLine();
			System.out.println(response);
		} 
		catch (IOException e) {
			e.printStackTrace();	// print every error from stack
		}
	}
}
