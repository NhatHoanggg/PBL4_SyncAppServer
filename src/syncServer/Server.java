package syncServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    int port;
    private ArrayList<ClientHandler> listClients = new ArrayList<>();

    String folderPath;

    public ArrayList<ClientHandler> getListClients() {
        return listClients;
    }

    public Server(int port, String folderPath) {
        this.port = port;
        this.folderPath = folderPath;
    }

    public void startServer(){
        try {
            ServerSocket socket = new ServerSocket(port);
            TrackingFolderChanges agent = new TrackingFolderChanges(folderPath);
            agent.getInitialState();
            while (true){
                Socket clientSocket = socket.accept();
                System.out.println("Client: " + clientSocket);

                ClientHandler handler = new ClientHandler(clientSocket, folderPath, "ID:"+System.currentTimeMillis());
                new Thread(handler).start();
                listClients.add(handler);

                // get ra instance cua handler
                SyncService service = new SyncService(this, agent, listClients, handler);
                new Thread(service).start();
            }
        }
        catch (IOException e) {
            System.out.println("Server I/O error: " + e.getMessage());
        }
    }

    public void getHistory() {

    }
}