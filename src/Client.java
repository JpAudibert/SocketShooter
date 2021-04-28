import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {
    private static final int SERVER_PORT = 9090;
    private static final String SERVER_IP = "127.0.0.1";

    public Client() {
        super("Janela");
        setSize(600, 480);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConnection = new ServerConnection(socket);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConnection).start();

        while (true) {
            // todo game implementation
            // build a function
            sender.println(keyboard.readLine());
        }
    }

}
