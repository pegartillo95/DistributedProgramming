package borja.lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    public static final String IPServer = "127.0.0.1";
    public static final int PortServer = 5556;

    ServerSocket listen;
    Socket socket;

    BufferedReader readChannel;
    PrintWriter writeChannel;

    @Override
    public void run() {
        initializeServer();

        while(true) {
            try {
                readInputAndPrintToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeServer() {
        try {
            listen = new ServerSocket(PortServer);
            socket = listen.accept();

            readChannel =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            writeChannel = new PrintWriter(socket.getOutputStream());

            System.out.println("Server started.");
            System.out.println("Listening on " + Server.IPServer + ":" + Server.PortServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInputAndPrintToConsole() throws IOException {
        System.out.println(readChannel.readLine());
    }
}
