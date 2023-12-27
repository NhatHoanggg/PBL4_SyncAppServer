package syncServer;

import java.net.InetAddress;
import java.net.Socket;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TrackingHistory {
    ArrayList<String> historyList = new ArrayList<String>();
    public void updateHistory(Socket socket, ArrayList<String> removeList, String action) {
        for (String filename : removeList) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = now.format(formatter);

            InetAddress inetAddress = socket.getInetAddress();


            String ip = inetAddress.getHostAddress();

            String history =ip + "#" + filename + "#" + action + "#" + time;
            historyList.add(history);
//            update database

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sync_app";
                Connection con = DriverManager.getConnection(url, "root", "");
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO `sync_history`(`IP`, `FILE`, `ACTION`, `TIME`) " +
                        "VALUES ('"+ip+"','"+filename+"','"+action+"','"+time+"')";
                stmt.executeUpdate(sql);

            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<String> getHistoryList() {
//        return historyList;
        ArrayList<String> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sync_app";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM `sync_history`";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ip = rs.getString("IP");
                String filename = rs.getString("FILE");
                String action = rs.getString("ACTION");
                String time = rs.getString("TIME");
                String row =ip + "#" + filename + "#" + action + "#" + time;

                list.add(row);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
