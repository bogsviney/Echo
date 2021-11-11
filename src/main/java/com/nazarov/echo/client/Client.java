package com.nazarov.echo.client;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 3000);
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String messageS = reader.readLine();
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(messageS.getBytes());
            System.out.println("SANDING TO SERVER: " + messageS);
            InputStream inputStream = client.getInputStream();
            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);
            String messageR = new String(buffer, 0, count);
            System.out.println("ANSWER FROM SERVER: " + messageR);
        }
    }
}
