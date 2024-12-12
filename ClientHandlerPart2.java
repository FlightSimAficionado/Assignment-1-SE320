import java.io.*;
import java.net.*;

// Runnable class to handle individual clients
class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            // Read weight and height from the client
            String weightString = reader.readLine();
            String heightString = reader.readLine();

            double weight = Double.parseDouble(weightString);
            double height = Double.parseDouble(heightString);

            // Calculate BMI
            double bmi = weight / (height * height);

            // Send BMI result back to the client
            writer.println(String.format("Your BMI is %.2f", bmi));

            System.out.println("Processed BMI for client: " + bmi);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}