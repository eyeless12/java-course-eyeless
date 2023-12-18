package edu.hw8.oskorbleniya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class QuoteClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int BYTES_COUNT = 124;
    private static final int SERVER_PORT = 8080;

    public void handle() {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

            while (true) {
                var request = reader.readLine();
                outputStream.write(request.getBytes());
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[BYTES_COUNT];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead > 0) {
                    String response = new String(buffer, 0, bytesRead);
                    //System.out.println("Server response: " + response);
                    //Do something with response
                }
            }
        } catch (IOException ignored) {
        }
    }
}

