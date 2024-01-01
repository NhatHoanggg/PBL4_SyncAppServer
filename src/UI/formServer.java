/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import syncServer.ClientHandler;
import syncServer.Server;
import syncServer.TrackingHistory;

import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class formServer extends javax.swing.JFrame {
    public void run()
    {
    }

    public String folderPath;
    public int port;

    private Server server;
    public formServer(String folderPath, int port) {
        this.folderPath = folderPath;
        this.port = port;


        initComponents();
        setTableFileShared("");
        setVisible(true);

    }

    public void startServer()
    {
        server = new Server(port, folderPath);
        server.startServer();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Parent = new javax.swing.JPanel();
        firstPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearchFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        secondPanel = new javax.swing.JPanel();
        txtSearchClient = new javax.swing.JTextField();
        btnSearchClient = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        thirdPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        txtSearchHistory = new javax.swing.JTextField();
        btnSearchHistory = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnListFileShared = new javax.swing.JButton();
        btnListUser = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" SERVER FORM");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setResizable(false);

        Parent.setLayout(new java.awt.CardLayout());

        firstPanel.setBackground(new java.awt.Color(250, 248, 240));

        txtSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));

        btnSearchFile.setBackground(new java.awt.Color(250, 248, 240));
        btnSearchFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearchFile.setBorder(null);
        btnSearchFile.setBorderPainted(false);
        btnSearchFile.setContentAreaFilled(false);
        btnSearchFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchFileMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
                firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(firstPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(firstPanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(firstPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSearchFile, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(101, 101, 101))))
        );
        firstPanelLayout.setVerticalGroup(
                firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(firstPanelLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchFile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        Parent.add(firstPanel, "card2");

        secondPanel.setBackground(new java.awt.Color(250, 248, 240));
        secondPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearchClient.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSearchClient.setForeground(new java.awt.Color(153, 153, 153));

        btnSearchClient.setBackground(new java.awt.Color(250, 248, 240));
        btnSearchClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearchClient.setBorder(null);
        btnSearchClient.setBorderPainted(false);
        btnSearchClient.setContentAreaFilled(false);
        btnSearchClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchClientMouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout secondPanelLayout = new javax.swing.GroupLayout(secondPanel);
        secondPanel.setLayout(secondPanelLayout);
        secondPanelLayout.setHorizontalGroup(
                secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(secondPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(secondPanelLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(txtSearchClient, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchClient, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        secondPanelLayout.setVerticalGroup(
                secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(secondPanelLayout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSearchClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        Parent.add(secondPanel, "card3");

        thirdPanel.setBackground(new java.awt.Color(250, 248, 240));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(jTable3);

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });

        btnSearchHistory.setBackground(new java.awt.Color(250, 248, 240));
        btnSearchHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnSearchHistory.setBorder(null);
        btnSearchHistory.setBorderPainted(false);
        btnSearchHistory.setContentAreaFilled(false);

        btnSearchHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout thirdPanelLayout = new javax.swing.GroupLayout(thirdPanel);
        thirdPanel.setLayout(thirdPanelLayout);
        thirdPanelLayout.setHorizontalGroup(
                thirdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdPanelLayout.createSequentialGroup()
                                .addGroup(thirdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(thirdPanelLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSearchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSearchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(thirdPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
        );
        thirdPanelLayout.setVerticalGroup(
                thirdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdPanelLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(thirdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdPanelLayout.createSequentialGroup()
                                                .addComponent(btnSearchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdPanelLayout.createSequentialGroup()
                                                .addGroup(thirdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSearchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        Parent.add(thirdPanel, "card4");

        jPanel2.setBackground(new java.awt.Color(250, 248, 240));

        btnListFileShared.setBackground(new java.awt.Color(250, 248, 240));
        btnListFileShared.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListFileShared.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Opened Folder_1.png"))); // NOI18N
        btnListFileShared.setBorderPainted(false);
        btnListFileShared.setContentAreaFilled(false);
        btnListFileShared.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListFileShared.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListFileSharedMouseClicked(evt);
            }
        });

        btnListUser.setBackground(new java.awt.Color(250, 248, 240));
        btnListUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Users.png"))); // NOI18N
        btnListUser.setBorderPainted(false);
        btnListUser.setContentAreaFilled(false);
        btnListUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListUserMouseClicked(evt);
            }
        });

        btnHistory.setBackground(new java.awt.Color(250, 248, 240));
        btnHistory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Time Machine_1.png"))); // NOI18N
        btnHistory.setBorderPainted(false);
        btnHistory.setContentAreaFilled(false);
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnListFileShared, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnListUser, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnListUser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnListFileShared, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>


    public void setTableFileShared( String filename) {
        File folder = new File(folderPath);


        File[] files = folder.listFiles();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("File name");
        model.addColumn("Size(KB)");
        model.addColumn("Date Modified");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains(filename)) {
                double fileSize = (double) file.length() / 1024;
                String modifiedDate = dateFormat.format(file.lastModified());

                model.addRow(new Object[]{fileName, fileSize, modifiedDate});
            }
        }

        jTable1.setModel(model);

    }

    public void setTableClient(String client) {

        ArrayList<ClientHandler> listClients = server.getListClients();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("IP Address");


        for(ClientHandler handler : listClients) {
            Socket clientSocket = handler.getMySocket();

            InetAddress clientAddress = clientSocket.getInetAddress();
            String clientIP = clientAddress.getHostAddress();

            model.addRow(new Object[] {clientIP});
        }


        jTable2.setModel(model);
    }

    public  void setTableHistory(String date, String fileName) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IP");
        model.addColumn("FILE");
        model.addColumn("ACTION");
        model.addColumn("TIME");

        TrackingHistory trackingHistory = new TrackingHistory();

        ArrayList<String> history = trackingHistory.getHistoryList();

        for (String historyItem : history) {
            String[] parts = historyItem.split("#");

            String ip = parts[0];
            String filename = parts[1];
            String action = parts[2];
            String time = parts[3];

            if (time.contains(date) && filename.contains(fileName)) {
                model.addRow(new Object[] {ip, filename, action, time});
            }
        }
        jTable3.setModel(model);
    }
    private void jDateChooserPropertyChange(PropertyChangeEvent evt) {

        if ("date".equals(evt.getPropertyName())) {
            Date selectedDate = (Date) evt.getNewValue();

            SimpleDateFormat inputDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date date = inputDateFormat.parse(String.valueOf(selectedDate));
                String dateFiltered = outputDateFormat.format(date);
                System.out.println(dateFiltered);
                setTableHistory(dateFiltered, "");

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void btnSearchFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListFileSharedMouseClicked
        String fileName = txtSearch.getText();
        System.out.println(fileName);
        setTableFileShared(fileName);
    }

    private void btnSearchClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListFileSharedMouseClicked
        String client = txtSearchClient.getText();
        setTableClient(client);
    }

    private void btnSearchHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListFileSharedMouseClicked
        setTableHistory("",txtSearchHistory.getText());
    }

    private void btnListFileSharedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListFileSharedMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(firstPanel);
        Parent.repaint();
        Parent.revalidate();
        setTableFileShared("");
    }
    private void btnListUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListUserMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(secondPanel);
        Parent.repaint();
        Parent.revalidate();
        Thread thread = new Thread(()->{
            setTableClient("");
        });
        thread.start();
    }//GEN-LAST:event_btnListUserMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        // TODO add your handling code here:
        jDateChooser.setDate(new Date());
        Parent.removeAll();
        Parent.add(thirdPanel);
        Parent.repaint();
        Parent.revalidate();
        setTableHistory("","");
    }//GEN-LAST:event_btnHistoryMouseClicked

    private javax.swing.JPanel Parent;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnListFileShared;
    private javax.swing.JButton btnListUser;
    private javax.swing.JButton btnSearchClient;
    private javax.swing.JButton btnSearchFile;
    private javax.swing.JButton btnSearchHistory;
    private javax.swing.JPanel firstPanel;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtSearchHistory;
    private javax.swing.JPanel secondPanel;
    private javax.swing.JPanel thirdPanel;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchClient;
    // End of variables declaration//GEN-END:variables
}
