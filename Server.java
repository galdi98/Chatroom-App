import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
	public static final int DEFAULT_PORT = 15001;

	// construct a thread pool for concurrency	
	private static final Executor exec = Executors.newCachedThreadPool();

	public static void main(String[] args) throws IOException {
		ServerSocket sock = null;
		Vector<String> messageQueue;
		ArrayList<BufferedWriter> sockets;
		try {
			// establish the socket
			sock = new ServerSocket(DEFAULT_PORT);
			messageQueue = new Vector<String>();
			sockets = new ArrayList<BufferedWriter>();
			
			Runnable broadcast = new BroadcastThread(sockets, messageQueue);
			exec.execute(broadcast);
			
			while (true) {
				Socket client = sock.accept();
				BufferedWriter toClient = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				sockets.add(toClient);
				System.out.println("User added!");
				System.out.print(sockets.get(0).toString());
				/**
				 * now listen for connections
				 * and service the connection in a separate thread.
				 */
				Runnable task = new Connection(client, messageQueue);
				exec.execute(task);
				
				
			}
		}
		catch (IOException ioe) { System.err.println(ioe); }
		finally {
			if (sock != null)
				sock.close();
		}
	}
}
