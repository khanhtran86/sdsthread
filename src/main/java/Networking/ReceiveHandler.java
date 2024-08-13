package Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveHandler extends Thread {
    Socket socket = null;
    String Name;

    public ReceiveHandler(Socket socket, String Name) {
        this.socket = socket;
        this.Name = Name;
    }

    @Override
    public void run()
    {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println(Name + "say: "+ input.readUTF());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
