package views;

import logic.Client;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame{

    private Client client;

    public ClientWindow(String name, int id) {
        super(name);
        this.getContentPane().setLayout(new FlowLayout());

        initializeClient(id);
        initializeGUIComponents();

        this.pack();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeGUIComponents() {

        JPanel connectPanel = new ConnectToServerPanel(client);

        JTextField messageTexField = new JTextField();
        messageTexField.setPreferredSize(new Dimension(200, 30));

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> {
            client.sendMessage(messageTexField.getText());
            messageTexField.setText("");
        });

        this.add(connectPanel);
        this.add(messageTexField);
        this.add(sendButton);
    }

    private void initializeClient(int clientId) {
        client = new Client(clientId);
    }
}
