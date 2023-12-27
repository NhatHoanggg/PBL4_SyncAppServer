package syncServer;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class ClientHandler implements Runnable{
    private String idClients;
    private final Socket mySocket;
    private final String folderPath;
    private Boolean checkState = false;
    FileTransferProcessor fileProcessor;
    TrackingHistory trackingHistory = new TrackingHistory();
    private String username = "111";
    public String getIdClients() {
        return idClients;
    }
    public Socket getMySocket() {
        return mySocket;
    }
    public String getFolderPath() {
        return folderPath;
    }
    public Boolean getCheckState() {
        return checkState;
    }

    public FileTransferProcessor getFileProcessor() {
        return fileProcessor;
    }

    public void setCheckState(Boolean checkState) {
        this.checkState = checkState;
    }

    public ClientHandler(Socket clientSocket, String folderPath, String idClients) {
        this.mySocket = clientSocket;
        this.folderPath = folderPath;
        this.idClients = idClients;
    }


    @Override
    public void run() {
        try{
            System.out.println("Started Client Handler");
            fileProcessor = new FileTransferProcessor(mySocket, folderPath);
            fileProcessor.openSocket();
            fileProcessor.syncWithMD5(fileProcessor.getFilesFromFolder());
            ListenMessage();
        }
        catch (Exception e) {
        }
    }


    public void ListenMessage()  {


        System.out.println(fileProcessor);
        String status;

        while (true) {
            status = fileProcessor.receiveMessage();
            if(status.contains("Disconnected")){
                break;
            }

            System.out.println("Receive from Client: " + status);
            switch (status) {
                case "List file deleted":
                    ArrayList<String> listFileDelete = fileProcessor.receiveAndDeletedFile();
                    trackingHistory.updateHistory( mySocket, listFileDelete,"Delete" );
                    break;
                case "List file added":
                    ArrayList<String> listFileAdd = fileProcessor.receive();
                    trackingHistory.updateHistory( mySocket, listFileAdd,"Add" );
                    break;
                case "List file modified":
                    Map<String, String> fileServer = fileProcessor.getMap(fileProcessor.getFilesFromFolder());
                    fileProcessor.sendMap(fileServer);
                    ArrayList<String> listFileModified = fileProcessor.receive();
                    trackingHistory.updateHistory( mySocket, listFileModified,"Modify" );
                    break;
                default:
                    break;
            }

            if (status.equals("Done")) {
                checkState = true;
                System.out.println("CheckState Success");
            }
        }
        System.out.println(status);

    }
}
