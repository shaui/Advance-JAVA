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
			// TODO �۰ʲ��ͪ� catch �϶�
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
