package borja.lab5.views;

import borja.lab5.Client;
import borja.lab5.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectToServerPanel extends JPanel {

    private Client client;

    public ConnectToServerPanel(Client c) {
        super();
        this.client = c;
        this.setLayout(new BoxLayout(this, 3));

        initializeComponents();
    }

    private void initializeComponents() {
        JTextField ipTextField = new JTextField();
        ipTextField.setText(Server.IPServer);
        JTextField portTextField = new JTextField();
        portTextField.setText(Server.PortServer+"");

        JButton connectButton = new JButton("CONNECT");
        connectButton.addActionListener(e -> {
            client.setServerContext(
                    ipTextField.getText(),
                    Integer.parseInt(portTextField.getText())
            );
            client.start();
        });

        this.add(ipTextField);
        this.add(portTextField);
        this.add(connectButton);
    }

}
