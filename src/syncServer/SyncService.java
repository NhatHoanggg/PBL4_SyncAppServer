package syncServer;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;

public class SyncService implements Runnable {
    private final Server server;
    private final ClientHandler handler;
    private final Socket mySocket;
    private final String folderPath;
    private ArrayList<ClientHandler> listCLients;
    TrackingFolderChanges agent;
    public SyncService(Server server, TrackingFolderChanges agent, ArrayList<ClientHandler> listCLients, ClientHandler handler) {
        this.server = server;
        this.handler = handler;
        this.mySocket = handler.getMySocket();
        this.folderPath = handler.getFolderPath();
        this.agent = agent;
        this.listCLients = listCLients;
    }


    @Override
    public void run() {
        System.out.println("Starting SyncService");
        checkChangesAndSync(agent);
    }

    public void checkChangesAndSync(TrackingFolderChanges agent){
        System.out.println("checkChanges Service");
        System.out.println(server.getListClients());
        boolean checkState = false;
        while (true) {
                try{
                    Thread.sleep(3000);
                    checkState = handler.getCheckState();
                }catch (Exception e){
                    e.printStackTrace();
                }
            if (checkState) {
                agent.resetChangesLists();
                agent.checkForChanges();
                ArrayList<File> filesAdd = agent.getFilesAdd();
                ArrayList<File> filesModified = agent.getFilesModified();
                ArrayList<String> filenameDeleted = agent.getFilesDeleted();

                syncToClients(filenameDeleted, filesAdd, filesModified);

                handler.setCheckState(false);
            }
        }


    }
    public void syncToClients(ArrayList<String> filenameDeleted, ArrayList<File> filesAdd,
                              ArrayList<File> filesModified) {
        listCLients = server.getListClients();
        for (ClientHandler client : listCLients) {
            if(!(client.getIdClients().equals(handler.getIdClients()))){
                FileTransferProcessor fileProcessor = client.getFileProcessor();
//                fileProcessor.sendMessage("Request Synchronized");
                if (!filenameDeleted.isEmpty()) {
                    try{
                        System.out.println("1 delete ");
                        System.out.println(filenameDeleted);
                        fileProcessor.sendMessage("List file deleted");
                        fileProcessor.sendFileName(filenameDeleted);
                        System.out.println("1 xong ");
                        Thread.sleep(1000);
                    }   catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (!filesAdd.isEmpty()) {
                    try{
                        System.out.println("2 add ");
                        fileProcessor.sendMessage("List file added");
                        fileProcessor.send(filesAdd);
                        System.out.println("2 xong ");
                        Thread.sleep(1000);
                    }   catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (!filesModified.isEmpty()) {
                    try{
                        System.out.println("3 mdf ");
                        fileProcessor.sendMessage("List file modified");
                        fileProcessor.sendFilesModified(filesModified);
                        System.out.println("3 xong ");
                        Thread.sleep(1000);
                    }   catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }




}
