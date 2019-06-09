package dapp;

// ref: https://gist.github.com/CarlEkerot/2693246
import java.io.*;
import java.lang.ClassNotFoundException;


// Socket
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

// List
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class Daemon extends Thread {
    public Server serverInstance;
    public String method;

    public Daemon(Server serverInstance, String method) {
        this.serverInstance = serverInstance;
        this.method = method;
    }

    public void run() {
        Method func = null;
        try {
            func = this.serverInstance.getClass().getMethod(this.method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            func.invoke(this.serverInstance, (Object[]) null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    protected ServerSocket server;
    protected List<String> listClient = new ArrayList<String>();
    protected int clientThreadPort;
    protected int serverThreadPort;
    protected final int LIMIT = 4;
    protected Logger logger;

    public Server(int port) {
        this.serverThreadPort = port;
        this.clientThreadPort = port + 1000;
        this.logger = Logger.getLogger(this.getClass().getName());
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean IsFull() {
        if (this.listClient.size() == this.LIMIT) {
            return true;
        } else {
            return false;
        }
    }

    public void clientRun() {

    }

    public void serverRun() {

    }

    public void start() {
        // (new Daemon(this, "clientRun")).start();
        // (new Daemon(this, "serverRun")).start();
    }
}
