package connect_tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientTest extends Thread{

    private Socket socket;

    public ClientTest(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if(socket != null) {
                PrintStream writer = new PrintStream(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer.println("Connect");
                writer.flush();
                System.out.println(reader.readLine());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}