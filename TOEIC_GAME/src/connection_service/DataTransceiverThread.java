package connection_service;

import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class DataTransceiverThread extends Thread{
	
	private HashMap<InetAddress, Socket> clients = new HashMap<InetAddress, Socket>();
	private HashMap<InetAddress, byte[]> clientsData = new HashMap<InetAddress, byte[]>();

	public DataTransceiverThread(InetAddress IP, Socket socket, byte[] data) {
		clients.put(IP, socket);
		clientsData.put(IP, data);
	}
	
	public void addClient(InetAddress IP, Socket socket, byte[] data) {
		clients.put(IP, socket);
		clientsData.put(IP, data);
	}
	
	@Override
	public void run() {
		//有客戶的data還未處理
		while(!clientsData.isEmpty()) {
			synchronized (clientsData) {
				Iterator<Entry<InetAddress, byte[]>> iter = clientsData.entrySet().iterator();
				while(iter.hasNext()) {
					Entry<InetAddress, byte[]> entry = iter.next();
					byte[] data = entry.getValue();
				}
			}
			
		}
	}
}
