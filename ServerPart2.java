import java.io.*;
import java.net.*;

public class ServerPart2 {
    int port = 50001;

    public static void main(String[] args) {
        ServerPart2 server = new ServerPart2();
        server.create_Server();
    }

    public void create_Server() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // Listen for a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client in a new thread
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while starting the server: " + e.getMessage(), e);
        }
    }
}
