/**
 * This is the separate thread that services each
 * incoming echo client request.
 *
 * @author Greg Gagne 
 */

import java.net.*;
import java.util.Vector;

public class Connection implements Runnable
{
	private Socket client;
	private Vector<String> message;
	private static Handler handler = new Handler();
	
	public Connection(Socket client, Vector<String> messageQueue) {
		this.client = client;
		this.message = messageQueue;
	}

    /**
     * This method runs in a separate thread.
     */	
	public void run() { 
		try {
			handler.process(client, message);
		}
		catch (java.io.IOException ioe) {
			System.err.println(ioe);
		}
	}
}

