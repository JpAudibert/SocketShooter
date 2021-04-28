import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader receiver;
    private PrintWriter sender;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket client, ArrayList<ClientHandler> clients) throws IOException {
        this.client = client;
        this.clients = clients;
        this.receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.sender = new PrintWriter(client.getOutputStream(), true);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String request = receiver.readLine();
            }
        }catch (IOException e){
            System.err.println("IO Exception in Client Handler");
            System.err.println(e.getStackTrace());
        }finally {

        }
    }
}
