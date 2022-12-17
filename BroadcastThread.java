import java.io.*;
import java.util.*;

public class BroadcastThread implements Runnable {

	Vector<String> messageQueue;
	ArrayList<BufferedWriter> sockets;
	String message;

	public BroadcastThread(ArrayList<BufferedWriter> clients, Vector<String> messageQueue) {
		this.sockets = clients;
		this.messageQueue = messageQueue;

	}

	public void run() {
		while(true) { 

			try {Thread.sleep(100); } catch(InterruptedException ie) { }

			while(!messageQueue.isEmpty()) {
				message = messageQueue.get(0);
				messageQueue.remove(0);
				System.out.println("removed: "+message);
				for(int i=0; i<sockets.size(); i++) {
					try { sockets.get(i).write(message+ "\r\n");
					sockets.get(i).flush();
					} catch (IOException e) {
						sockets.remove(i);
					}
				}
			}
		}
	}
}
