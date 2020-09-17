package shaui.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Server {

	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 8787;
	private ServerSocket serverSocket = null;
	private Map<String, Socket> clients = new HashMap<>();
	private Map<String, Boolean> clientsStatus = new HashMap<>();
	private Boss boss;
	
	public Server() {
		boss = new Boss();
		try {
			//set the serverSocket
			serverSocket = new ServerSocket();
			SocketAddress socketAddress = new InetSocketAddress(IP_ADDRESS, PORT);
			serverSocket.bind(socketAddress);
			//set the socket for client
			while(true) {
				//wait for connect
				Socket socket = serverSocket.accept();
				clients.put(String.valueOf(socket.getPort()), socket);
				//initial the status with "true", mean that client can do action
				clientsStatus.put(String.valueOf(socket.getPort()), true);
				System.out.println(socket.getPort() + " connect");
				//set the socket and give it a thread
				setSocket(socket);
			}
			
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
			
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				// TODO 自動產生的 catch 區塊
				e1.printStackTrace();
			}
		}
	}
	
	//Because each socket will run independently, so it need to create a thread
	private void setSocket(Socket socket) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					DataInputStream input = new DataInputStream( socket.getInputStream());
					DataOutputStream output = new DataOutputStream( socket.getOutputStream());
					while(true) {
						try {
							/*get the message*/
							
							//get the data length
							int len = input.readInt();
							//build a byte[] with the length to store the data, avoid use the byte[1024] that will waste the memory
							byte[] data = new byte[len];
							//get the data
							input.read(data);
							String msg = new String(data);
							System.out.println("from:" + socket.getPort() + "\n" + "len:" + len + "\n" + "Data:" + msg);
							
							
							/*send a response*/
							String type = msg.split(":")[0];
							switch(type) {
								case "msg":
									byte[] resp0 = null;
									//check if the user in the map
									for(String ports: clients.keySet()) {
										//if send data to target user
										if(msg.split(":")[1].equals(ports)) {
											resp0 = ("send data to " + ports).getBytes();
											DataOutputStream output_user = new DataOutputStream(clients.get(ports).getOutputStream());
											String out_msg = "msg from " + String.valueOf(socket.getPort()) + ":" + msg.split(":")[2];
											byte[] out_data = out_msg.getBytes();
											output_user.writeInt(out_data.length);
											output_user.write(out_data);
											break;
										}else {
											resp0 = ("success!".getBytes());
										}
									}
									output.writeInt(resp0.length);
									output.write(resp0);
									break;
								case "searchUser":
									String tempMsg = "all users:";
									for(String ports: clients.keySet()) {
										if(!ports.equals(String.valueOf(socket.getPort())) ) {
											tempMsg += "\n" +ports ;
										}		
									}
									byte[] resp1 = tempMsg.getBytes();
									output.writeInt(resp1.length);
									output.write(resp1);
									break;
								case "attack":
									synchronized(boss) {
										Integer damage = Integer.valueOf(msg.split(":")[1]);
										System.out.println("Before:" + boss.getHP());
										System.out.println("After:" + (boss.getHP() - damage) );
										boss.setHP((boss.getHP() - damage));
										if(boss.getHP() <= 0) {
											sendWinMessage();
											break;
										}
									}
									//set the client's isAciton to false
									clientsStatus.put(String.valueOf(socket.getPort()), false);
									
									try {
										sendHPMessage();
//										System.out.println(isActionPhase());
										//if all the clients are finish action
										if(isActionPhase()) {
											//random damage
											Thread.sleep(1000);
											Random r = new Random();
											String damageData = String.valueOf("Damage:" + (r.nextInt(10) + 50));
											
											//random client
											int index = r.nextInt(clients.size());
											Socket target = selectTarget(index);
											DataOutputStream outTarget = new DataOutputStream(target.getOutputStream());
											
											//attack
											outTarget.writeInt(damageData.getBytes().length);
											outTarget.write(damageData.getBytes());	
											awakeClients();
										}
									} catch (InterruptedException e) {
										// TODO 自動產生的 catch 區塊
										System.out.println("Error attack");
									}
									break;
							}
						} catch (IOException e) {
							System.out.println("socket:" + socket.getPort() + " is closed");
							removeClient(String.valueOf(socket.getPort()));
							break;
						}	
					}
					input.close();
					output.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}).start();
	}
	
	private boolean isActionPhase() {
		for(String ports: clientsStatus.keySet()) {
			//make boss can act
			boss.setActionPhase(true);
			//if have any client still can act
			if(clientsStatus.get(ports)) {
				//make boss cannot act
				boss.setActionPhase(false);
				break;
			}
		}
		return boss.getActionPhase();
	}
	
	private Socket selectTarget(int index) {
		String[] keys = clients.keySet().toArray(new String[0]);
		return clients.get(keys[index]);
	}
	
	private void awakeClients() {
		//set all the client's action status to true
		for(String client: clientsStatus.keySet()) {
			clientsStatus.put(client, true);
		}
		for(String key: clients.keySet()) {
			try {
				DataOutputStream output = new DataOutputStream(clients.get(key).getOutputStream());
				String msg = "awake";
				output.writeInt(msg.getBytes().length);
				output.write(msg.getBytes());
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				System.out.println("All member is died");
			}
		}
		//the Boss cannot Action
		boss.setActionPhase(false);
	}
	
	private void removeClient(String port) {
		clients.remove(port);
		clientsStatus.remove(port);
	}
	
	private void sendWinMessage() {
		for(String key: clients.keySet()) {
			try {
				DataOutputStream output = new DataOutputStream(clients.get(key).getOutputStream());
				String msg = "win:you win!";
				output.writeInt(msg.getBytes().length);
				output.write(msg.getBytes());
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
	
	private void sendHPMessage() {
		for(String key: clients.keySet()) {
			try {
				DataOutputStream output = new DataOutputStream(clients.get(key).getOutputStream());
				String msg = "HP:" + boss.getHP();
				output.writeInt(msg.getBytes().length);
				output.write(msg.getBytes());
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
}
