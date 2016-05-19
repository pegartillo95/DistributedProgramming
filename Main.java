package borja.lab5;

import borja.lab5.views.ClientWindow;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        ClientWindow client = new ClientWindow("Client", 0);

        server.start();
    }

}
