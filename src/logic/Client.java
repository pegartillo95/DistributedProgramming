package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{

    private int id;
    private String serverIP;
    private int serverPort;

    Socket socket;
    BufferedReader readChannel;
    PrintWriter writeChannel;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        connectToServer();
    }

    public void connectToServer() {
        System.out.println("Attempting Connection...");
        try {
            socket = new Socket(serverIP, serverPort);
            readChannel =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            writeChannel = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writeChannel.println("Client " + id + " says: " + message);
        writeChannel.flush();
    }

    public void setServerContext(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
}
