package shaui.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 8787;
	ServerSocket serverSocket = null;
	Socket socket = null;
	
	
	public Server() {
		try {
			serverSocket = new ServerSocket();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
	
	private void closeServer() {
		try {
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
	}
	
}
