package com.nazarov.echo.server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);
        Socket socket = server.accept();
        while(true) {
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);
            String messageRecieved = new String(buffer, 0, count);
            System.out.println("MESSAGE FROM CLIENT: " + messageRecieved);
            System.out.println("ADDING PREFIX TO " + messageRecieved);
            String messageToSend = "ECHO_" + messageRecieved;
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(messageToSend.getBytes());
            System.out.println("SANDING TO CLIENT: " + messageToSend);
        }
    }
}
