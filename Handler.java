/**
 * Handler class containing the logic for a proxy server that
 * executes a HTTP request and returns
 * the resource back to the client. 
 *
 * @author Francesco Galdiolo 
 */

import java.io.*;
import java.net.*;
import java.util.Vector;

public class Handler 
{

	/**
	 * this method is invoked by a separate thread
	 */
	public void process(Socket client, Vector<String> messageQueue) throws java.io.IOException {
		BufferedReader fromClient = null;
		String line;

		try {
			fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
					
					while ( (line = fromClient.readLine()) != null)
						messageQueue.add(line);
				
			
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
		finally {
			// close streams and socket
			if (fromClient != null)
				fromClient.close();
		}
	}
}
