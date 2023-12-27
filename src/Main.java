import UI.formServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String folderPath = "D:\\1sv";
        int port = 8888;
        formServer  formServer = new formServer(folderPath, port);
        formServer.startServer();
    }
}