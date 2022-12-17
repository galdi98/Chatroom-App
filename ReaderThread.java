/**
 * This thread is passed a socket that it reads from. Whenever it gets input
 * it writes it to the ChatScreen text area using the displayMessage() method.
 */

import java.io.*;
import java.net.*;

public class ReaderThread implements Runnable
{
	Socket server;
	BufferedReader fromServer;
	BufferedWriter toSevrer;
	ChatScreen screen;

	public ReaderThread(Socket server, ChatScreen screen) {
		this.server = server;
		this.screen = screen;
	}

	public void run() {
		try {
			fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));

			while (true) {
				String line = fromServer.readLine();
				
					screen.displayMessage(line);
			}
		}
		catch (IOException ioe) { System.out.println(ioe); }

	}
}
