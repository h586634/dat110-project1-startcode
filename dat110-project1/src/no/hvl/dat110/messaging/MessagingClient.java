package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {
		// TODO
		// create TCP socket for client and connection
		// create connection object
		Socket clientSocket = new Socket();
		Connection connection = null;
		
		try {
			
			clientSocket.connect(new InetSocketAddress(server,port));
			connection = new Connection(clientSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return connection;
	}
}
