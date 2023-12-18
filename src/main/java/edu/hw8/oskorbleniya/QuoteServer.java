package edu.hw8.oskorbleniya;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuoteServer {
    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 5;

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            //System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException ignored) {
        } finally {
            executorService.shutdown();
        }
    }

    class ClientHandler implements Runnable {
        private static final HashMap<String, String> RESPONSES = new HashMap<String, String>() {{
            put(
                "личности",
                "Не переходи на личности там, где их нет"
            );
            put(
                "оскорбления",
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
            );
            put(
                "глупый",
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
            );
            put(
                "интеллект",
                "Чем ниже интеллект, тем громче оскорбления"
            );
        }};
        private static final int BYTES_COUNT = 124;

        private final Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()) {

                ByteBuffer buffer = ByteBuffer.allocate(BYTES_COUNT);
                int bytesRead = inputStream.read(buffer.array());

                if (bytesRead > 0) {
                    String request = new String(buffer.array(), 0, bytesRead);
                    String response = getResponse(request);

                    outputStream.write(response.getBytes());
                }
            } catch (IOException ignored) {
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException ignored) {
                }
            }
        }

        private String getResponse(String request) {
            return RESPONSES.getOrDefault(request, "Не понял запроса");
        }
    }
}
