package connection_service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service_Options extends Service{
	private ServerSocket serverSocket;
	private Socket socket;
	private static final int PORT = 8000;
	
	public Service_Options() {
		try {
			/*�qServer���wPORT�Ы�Socket*/
			serverSocket = new ServerSocket(PORT);
		
		} catch (IOException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
	protected void setOptions() {
		
	}
	
	@Override
	public void run() {
		sendData();
		if(socket.isClosed()) {
			acceptData();
		}
	}

	private void sendData() {
		System.out.println("Wait connect...");
		try {
			/*��Socket�e�{Accept���A�A���ݳs���C�|�^��Socket����Ӿާ@*/
			socket = serverSocket.accept();
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			String msg = "Link Start";
			int i = 0;
			while(i < 5) {
				if(socket.isConnected()) {
					System.out.println("Connect Success. Type: " + getServiceType(this));					
					/*�@��Header�A�N��h��bit*/
					output.writeLong(msg.getBytes().length);
					/*�ǰe�T���A��byte����*/
					output.write(msg.getBytes());
					output.flush();
//					Thread.sleep(1000);
					i++;	
				}
			}
			output.close();
			System.out.println(i + " " + socket.isClosed());
//			closeService(serverSocket, socket);
		} catch (IOException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
	private void acceptData() {
		System.out.println("Wait connect...");
		try {
			socket = serverSocket.accept();
			DataInputStream input = new DataInputStream(socket.getInputStream());
			long len = 0;
			byte[] data;
			String msg;
			
			while(true) {
				len = input.readLong();
				data = new byte[(int)len];
				input.read(data);
				msg = new String(data);
				System.out.println(msg);
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			try {
				System.out.println("Close Socket!");
				socket.close();
			} catch (IOException e1) {
				// TODO �۰ʲ��ͪ� catch �϶�
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			try {
				System.out.println("Close Socket!");
				socket.close();
			} catch (IOException e1) {
				// TODO �۰ʲ��ͪ� catch �϶�
				e1.printStackTrace();
			}
		}
	}

	

}
