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
				
				/*data����*/
				len = input.readLong();
				/*�ھڪ��׳Ыؤ@�ӪŪ�byte�}�C�A���F�s�T��*/
				data = new byte[(int)len];
				/*��T����i�}�C��*/
				input.read(data);
				/*byte�}�C�ন�r��*/
				msg = new String(data);
				System.out.println(msg);
				Thread.sleep(1000);
			}
			
		} catch (UnknownHostException e) {
			try {
				System.out.println("Close Socket!");
				socket.close();
			} catch (IOException e1) {
				// TODO �۰ʲ��ͪ� catch �϶�
				e1.printStackTrace();
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
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
	

}
