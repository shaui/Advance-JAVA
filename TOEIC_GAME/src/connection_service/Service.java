package connection_service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service extends Thread{
	
	protected void closeService(ServerSocket serverSocket, Socket socket) {
		try {
			socket.close();
			serverSocket.close();
			System.out.println("closeService");
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	protected String getServiceType(Service service) {
		return service.getClass().getSimpleName();
	}
	
	@Override
	public void run() {
		
	}
}
