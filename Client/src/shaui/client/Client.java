package shaui.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


public class Client {
	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 8787;
	private String msg = "";
	private boolean isAction = true;
	private int HP = 100;
	private DataOutputStream output;
	private DataInputStream input;
	
	public Client() {
		Socket socket = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(IP_ADDRESS, PORT);
		try {
			socket.connect(socketAddress);
			System.out.println("Command:");
			System.out.println("\"close\": exit");
			System.out.println("\"searchUser\": search the user online");
			System.out.println("\"msg:par1\": send msg to the server");
			System.out.println("\"msg:par1:par2\": send msg to \"par1\" with msg \"par2\" ");
			setReceiveDataThread(socket);
			
			output = new DataOutputStream( socket.getOutputStream());
			Scanner scan = new Scanner(System.in);
			msg =  scan.nextLine();
			String type = msg.split(":")[0];
			while(!msg.equals("close")) {
				byte[] data = msg.getBytes();
				int len = data.length;
				//if cannot attack but use attack command
				if(isAction == false && type.equals("attack")) {
					System.out.println("Not Action Phase");
				}else {
					output.writeInt(len);
					output.write(data);
				}
				//if attack, set the status to false
				if(type.equals("attack") && isAction) {
					isAction = false;
					System.out.println("Attack success! Damage:" + msg.split(":")[1]);
				}
				//reset the msg,type
				msg =  scan.nextLine();
				type = msg.split(":")[0];
			}
			output.close();
			
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		} finally {
			try {
				System.out.println("close");
				socket.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}

	}
	
	//use another Thread to handle the receive, because it may not always receive the data.
	private void setReceiveDataThread(Socket socket) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					input = new DataInputStream( socket.getInputStream( ));
					//Server can set the close command to close the client 
					while(!msg.equals("close")) {
						//read a int with 4 byte
						int len = input.readInt();
						byte[] data = new byte[len];
						input.read(data);
						String msg = new String(data);
						String type = msg.split(":")[0];
						
						if(msg.equals("awake")) {
							System.out.println("Action Status");
							isAction = true;
						}else if(type.equals("Damage")){
							System.out.println("Damage from boss:" + msg.split(":")[1]);
							HP -= Integer.valueOf(msg.split(":")[1]);
							if(HP > 0) {
								System.out.println("remain HP:" + HP);
							}else {
								System.out.println("You died...");
								input.close();
								output.close();
								socket.close();
							}		
						}else if (type.equals("win")){
							System.out.println(msg.split(":")[1]);
							input.close();
							output.close();
							socket.close();
						}else {
							System.out.println(msg);
						}
						
					}
					input.close();
				} catch (IOException e) {
					System.out.println("Socket is closed!");
				} finally {
					
				}
			}
		}).start();
	}
}
