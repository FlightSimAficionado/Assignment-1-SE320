
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ClientPart1 {
    public static void main(String[] args) {
        ClientPart1 client = new ClientPart1();
        client.bmi_client();
    }
        public void bmi_client() {
        int port = 50001; // Server's port number
        String hostname = "localhost"; // Server's hostname or IP address

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to BMI Server");

            // Create input and output streams
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Get weight and height from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your weight in kilograms: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter your height in meters: ");
            double height = scanner.nextDouble();

            // Send weight and height to the server
            writer.println(weight);
            writer.println(height);

            // Receive and display the BMI result from the server
            String response = reader.readLine();
            System.out.println(response);

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
    }
}
