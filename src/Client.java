import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;

    public void checkReconn() {

    }

    public Client(String host, int port, String file) {
        try {
            socket = new Socket(host, port);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client c = new Client("localhost", 7000, args[2]);
    }
}
