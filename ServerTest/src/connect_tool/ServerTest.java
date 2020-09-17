package connect_tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Thread{

    private ServerSocket server;
    private Socket socket;

    public ServerTest(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("wait...");
        try {
            socket = server.accept();
            server.close();
            PrintStream writer = new PrintStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            writer.println("Succes");
            socket.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
