package Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SDSServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Waiting client on port " + serverSocket.getLocalPort());
        Socket server = serverSocket.accept();
        //Create receive therad
        ReceiveHandler receiveHandler = new ReceiveHandler(server, "Client ");
        receiveHandler.start();

        while (true)
        {
            OutputStream outputStream = server.getOutputStream(); //socket
            DataOutputStream out = new DataOutputStream(outputStream);

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            out.writeUTF(userInput);
            out.flush();
            System.out.println("Sent: "+ userInput);
        }
    }

}
