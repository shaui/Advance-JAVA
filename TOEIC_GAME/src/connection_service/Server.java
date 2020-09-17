package connection_service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class Server {
	
	private ServerSocket serverSocket;
	private static final int PORT = 8000;
	private boolean isServerClose = false;
	private String[] types = {"Message to server"};
	private HashMap<InetAddress, Socket> clients = new HashMap<InetAddress, Socket>();
	
	private DataInputStream input;
	private DataTransceiverThread dtc = null;
	
	private Thread acceptDataThread = null;
	private Runnable acceptData = () -> {
		System.out.println("Accept data. Processing...");
		while(!clients.isEmpty()) {
			synchronized (clients) {
				Iterator<Entry<InetAddress, Socket>> iter = clients.entrySet().iterator();
				while(iter.hasNext()) {
					Entry<InetAddress, Socket> entry = iter.next();
					Socket socket = entry.getValue();
					if(socket.isClosed()) {
						clients.remove(entry.getKey());
					}
					else {
						try {
							input = new DataInputStream(socket.getInputStream());
							
							//accept data,直到客戶端把這一次傳送的所有資料送完 //!socket.isOutputShutdown()
							while(!socket.isClosed()) {
								if(input.available() > 4) {
									//取得header已決定開啟何種服務
									byte type = input.readByte();
									int typeCode = type;
									int len = input.readInt();
									//裝資料用的
									byte[] data = new byte[len];
									input.read(data);
									System.out.println(entry.getKey() + " open service. Type:" + types[typeCode]);
									switch(typeCode) {
										case 0:
											printData();
											break;
										case 1:
											
											break;
									}
									
								}
							}
						} catch (IOException e) {
							// TODO 自動產生的 catch 區塊
							e.printStackTrace();
						}
						
					}
				}
			}
		}
	};
	private Thread acceptConnectThread = new Thread(() -> {
					if(!isServerClose) {
						try {
							serverSocket = new ServerSocket(PORT);
							System.out.println("Server Start!");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					while(!isServerClose) {
						try {
							Socket socket = serverSocket.accept();
							System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " connecting.");
							clients.put(socket.getInetAddress(), socket);
							//如果沒有負責接收data的Thread，就 new 一個
							if(!acceptDataThread.isAlive()) {
								acceptDataThread = new Thread(acceptData);
								acceptDataThread.start();
							}
							
						} catch (IOException e) {
							// TODO 自動產生的 catch 區塊
							e.printStackTrace();
						}
					}
					
					
				}
			);
	private Thread scanCommandThread = new Thread(() -> {
					Scanner s = new Scanner(System.in);
					System.out.println("Enter \"strat\" to start the server.");
					while(!isServerClose) {
						String cmd = s.nextLine();
						String[] args = cmd.split(" ");
						switch(args.length) {
							case 1:
								switch(args[0]) {
									case "start":
										//start the server
										acceptConnectThread.start();
										break;
									case "close":
										//close the server
										break;
								}
								break;
							case 2:
								switch(args[0]) {
									case "msg":
										//send message to server
										break;
								}
								break;
							case 3:
								switch(args[0]) {
									case "msg":
										switch(args[1]) {
											case "clientName":
												//send message to clientName
												break;						
										}
										break;
								}
								break;
						}
					}
				}
			);
	
	private void printData() {
		
	}
	public Server() {
		scanCommandThread.start();
	}
}
