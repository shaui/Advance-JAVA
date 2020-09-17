package client_test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread{
	private final String VIRTUAL_IP = "192.168.9.11";
	private final int PORT = 8000;
	private Socket socket = null;
	@Override
	public void run() {
		acceptData();
		if(socket.isClosed()) {
			sendData();
		}
		
	}
	
	private void acceptData() {
		
		String msg;
		long len = 0;
		byte[] data;
		try {
			socket = new Socket(VIRTUAL_IP, PORT);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			while(true) {
				
				/*data長度*/
				len = input.readLong();
				/*根據長度創建一個空的byte陣列，為了存訊息*/
				data = new byte[(int)len];
				/*把訊息放進陣列中*/
				input.read(data);
				/*byte陣列轉成字串*/
				msg = new String(data);
				System.out.println(msg);
				Thread.sleep(1000);
			}
			
		} catch (UnknownHostException e) {
			try {
				System.out.println("Close Socket!");
				socket.close();
			} catch (IOException e1) {
				// TODO 自動產生的 catch 區塊
				e1.printStackTrace();
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
	
	private void sendData() {
		try {
			socket = new Socket(VIRTUAL_IP, PORT);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			String msg = "Message From Client!";
			int i = 0;
			while(i < 5) {
				output.writeLong(msg.getBytes().length);
				output.write(msg.getBytes());
				output.flush();
				i++;
			}
			output.close();
			socket.close();
			System.out.println("Terminal...");
		} catch (UnknownHostException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	

}
