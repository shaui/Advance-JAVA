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
			/*從Server指定PORT創建Socket*/
			serverSocket = new ServerSocket(PORT);
		
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
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
			/*讓Socket呈現Accept狀態，等待連接。會回傳Socket物件來操作*/
			socket = serverSocket.accept();
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			String msg = "Link Start";
			int i = 0;
			while(i < 5) {
				if(socket.isConnected()) {
					System.out.println("Connect Success. Type: " + getServiceType(this));					
					/*一個Header，代表多少bit*/
					output.writeLong(msg.getBytes().length);
					/*傳送訊息，用byte型式*/
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
			// TODO 自動產生的 catch 區塊
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
				// TODO 自動產生的 catch 區塊
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			try {
				System.out.println("Close Socket!");
				socket.close();
			} catch (IOException e1) {
				// TODO 自動產生的 catch 區塊
				e1.printStackTrace();
			}
		}
	}

	

}
