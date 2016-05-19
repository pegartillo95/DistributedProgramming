package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Server extends Thread {

    private Hashtable tUsers = new Hashtable<Integer, UserInfo>(); // Key = ClientID | Value = ClientInformation
    private Hashtable tChannels = new Hashtable<Integer, PrintWriter>(); // Key = ClientID | Value = Fout
    
    public static final String IPServer = "127.0.0.1";
    public static final int PortServer = 5556;
    
    ServerSocket listen;
        
    @Override
    public void run() {
        initializeServer();

        while(true) {
            try {
            	Socket s = listen.accept();
            	(new ClientListener(s)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeServer() {
        try {
            listen = new ServerSocket(PortServer);
            System.out.println("Server started.");
            System.out.println("Listening on " + Server.IPServer + ":" + Server.PortServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientListener extends Thread {
    	
        Socket socket;
        ObjectInputStream fIn; // fin
        ObjectOutputStream fOut; // fout
        
        public ClientListener(Socket s) {
        	this.socket = s;
        	initializeClientListener();
        }

		@Override
		public void run() {
			
			initializeClientListener();
			
			while(true) {
				
				try {
					Message msg = (Message) fIn.readObject();
					executeMessage(msg.getType());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}			
			}
			
		}
		
		public void initializeClientListener() {
			try {
				this.fOut = new ObjectOutputStream(this.socket.getOutputStream());
				this.fIn = new ObjectInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void executeMessage(int msgType) {
			switch (msgType) {
			case 0:
				// Mensaje conexión
				
				break;
			case 1:
				// Mensaje lista de usuarios
				break;
			case 2:
				// Emitir ficheros
				break;
			default:
				break;
			}
		}
	    
    }
}
