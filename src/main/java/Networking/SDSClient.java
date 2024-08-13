package Networking;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SDSClient {
    public static void main(String[] args) {
        String server = "localhost"; //127.0.0.1
        int port = 9999;

        try {
            Socket client = new Socket(server, port);

            ReceiveHandler receiveHandler = new ReceiveHandler(client, "Server ");
            receiveHandler.start();

            //Get input from user
            while (true)
            {
                OutputStream outputStream = client.getOutputStream(); //socket
                DataOutputStream out = new DataOutputStream(outputStream);

                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                out.writeUTF(userInput);
                out.flush();
                System.out.println("Sent: "+ userInput);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
