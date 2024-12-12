import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientPart2 {
    public static void main(String[] args) {
        ClientPart2 client = new ClientPart2();
        client.bmi_client();
    }

    public void bmi_client() {
        int port = 50001; // Server's port number
        String hostname = "localhost"; // Server's hostname or IP address

        try (Socket socket = new Socket(hostname, port);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true);
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to Scalable BMI Server");

            // Get weight and height from the user
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

        } catch (IOException ex) {
            System.out.println("Error: Unable to connect to the server (" + ex.getMessage() + ")");
        }
    }
}
