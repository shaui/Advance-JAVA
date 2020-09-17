package shaui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Client {
	public static final String IP_ADDRESS = "127.0.0.1";
	public static final int PORT = 8787;
	private String msg = "";
	private boolean isAction = true;
	private int HP = 100;
	private DataOutputStream output;
	private DataInputStream input;
	
	//GUI
	private JButton btnAttack;
	private JLabel msgLabel;
	private JLabel hpLabel;
	
	public Client() {
		
		//GUI
		MainFrame mf = new MainFrame();
		btnAttack = mf.getBtnAttack();
		hpLabel = mf.getHpLabel();
		msgLabel = mf.getMsgLabel();
		
		
		Socket socket = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(IP_ADDRESS, PORT);
		try {
			socket.connect(socketAddress);
			setReceiveDataThread(socket);
			
			output = new DataOutputStream( socket.getOutputStream());
			btnAttack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Random r = new Random();
					int damage = r.nextInt(10) + 50;
					String msg = "attack:" + String.valueOf(damage);
					String type = msg.split(":")[0];
					byte[] data = msg.getBytes();
					try {
						//if cannot attack but use attack command
						if(isAction == false && type.equals("attack")) {
							msgLabel.setText("Not Action Phase");
						}else {
							output.writeInt(data.length);
							output.write(data);
						}
						
						//if attack, set the status to false
						if(type.equals("attack") && isAction) {
							isAction = false;
							msgLabel.setText("Attack success! Damage:" + msg.split(":")[1]);
						}
						
					} catch (IOException e1) {
						// TODO 自動產生的 catch 區塊
						e1.printStackTrace();
					}
				}			
			});

			//卡住GUI，讓程序繼續運行
			while(mf.isEnabled()) {

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
							HP -= Integer.valueOf(msg.split(":")[1]);
							if(HP > 0) {
								msgLabel.setText("Damage from boss:" + msg.split(":")[1] + "..." + "remain HP:" + HP);
							}else {
								input.close();
								output.close();
								socket.close();
								msgLabel.setText("Damage from boss:" + msg.split(":")[1] + "..." + "You died...");
							}		
						}else if (type.equals("win")){
							msgLabel.setText(msg.split(":")[1]);
							input.close();
							output.close();
							socket.close();
						}else {
							hpLabel.setText(msg);
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
