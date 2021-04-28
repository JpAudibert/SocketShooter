import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private Socket server;
    private BufferedReader receiver;

    public ServerConnection(Socket server) throws IOException {
        this.server = server;
        this.receiver = new BufferedReader(new InputStreamReader(server.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String serverResponse = null;
            while (true) {
                serverResponse = receiver.readLine();
                if (serverResponse == null) break;
                System.out.println("Server says" + serverResponse);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                receiver.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
