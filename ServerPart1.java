
import java.io.*;
import java.net.*;

public class ServerPart1 {
      int port = 50001;

    public static void main(String[] args) {
        ServerPart1 server = new ServerPart1();
        server.create_Server();
    }
    public void create_Server() {

        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            //listen for connection
            Socket client = s.accept();
            System.out.println("Client connected");

            bmi_Calculator(client);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void bmi_Calculator(Socket clientSocket){
        try (
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
        ) {
            // Read weight and height from the client
            String weightString = reader.readLine();
            String heightString = reader.readLine();

            double weight = Double.parseDouble(weightString);
            double height = Double.parseDouble(heightString);

            // Calculate BMI
            double bmi = weight / (height * height);

            // Send BMI and category back to the client
            writer.println(String.format("Your BMI is %.2f", bmi));

            clientSocket.close();
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }


}