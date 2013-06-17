
package HESDispatcher;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 *@author NED
 */
public class HESMonitor extends Thread {

    private Map<InetAddress, Long[]> onlineServerListe;
    private JLabel labelAlpha, labelBeta;

    public HESMonitor() {
        System.out.println("Starting Monitor..");
        this.onlineServerListe = new HashMap<>();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.labelAlpha = dashboard.getLabelAlpha();
        this.labelBeta = dashboard.getLabelBeta();

    }

    public void run() {

        //Thread to calculate the lastUpdateTime and remove Server from OnlineServerListe if time difference is more than 2 Seconds
        new Thread() {
            public void run() {

                while (true) {
                    for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {
                        //if lastUpdateTime is longer than 2 Seconds remove Server from the list
                        if (System.currentTimeMillis() - getlastUpdateTime(entry.getKey()) > 2000) {
                            onlineServerListe.remove(entry);
                            updateMonitor();
                        }
                    }
                }
            }
        }.start();

        ////// end Thread Definition////////



        ///// Start Thread for listening to Server Broadcast////////
        try {
            int udpPort = 55555;
            DatagramSocket serverSocket = new DatagramSocket(udpPort);
            byte[] receiveData = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while (true) {
                System.out.println("Waiting for Server..");
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);

                if (sentence.equalsIgnoreCase("AM ALIVE")) {
                    updateServerOnlineListe(receivePacket.getAddress());
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateMonitor() {

        if (onlineServerListe.contains(host1)) {
            labelAlpha.setText("Online");
            labelAlpha.setForeground(Color.green);
        } else {
            labelAlpha.setText("Offline");
            labelAlpha.setForeground(Color.red);
        }
        if (onlineServerListe.contains(host2)) {
            labelBeta.setText("Online");
            labelBeta.setForeground(Color.green);
        } else {
            labelBeta.setText("Offline");
            labelBeta.setForeground(Color.red);
        }

    }

    public long getUpTime(InetAddress serverAdresse) {
        for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {

            if (serverAdresse.equals(entry.getKey())) {
                Long currentTime = System.currentTimeMillis();
                return currentTime - getRegisterTime(serverAdresse);
            }
        }

        return Long.MIN_VALUE;
    }

    public Set<InetAddress> getOnlineListe() {
        return onlineServerListe.keySet();
    }

    public Long getRegisterTime(InetAddress onlineServerAddress) {

        for (Map.Entry<InetAddress, Long[]> entry : this.onlineServerListe.entrySet()) {
            if (onlineServerAddress.equals(entry.getKey())) {
                return entry.getValue()[0];
            }
        }
        return Long.MIN_VALUE;
    }

    public Long getlastUpdateTime(InetAddress onlineServerAddress) {

        for (Map.Entry<InetAddress, Long[]> entry : this.onlineServerListe.entrySet()) {
            if (onlineServerAddress.equals(entry.getKey())) {
                return entry.getValue()[1];
            }
        }
        return Long.MAX_VALUE;
    }

    private void updateServerOnlineListe(InetAddress serverAdresse) {

        for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {

            //Server Vorhanden nur lastUpdateTime erstezen
            if (serverAdresse.equals(entry.getKey())) {

                // LastUpdateTime erstezen 
                Long lastUpdateTime = System.currentTimeMillis();
                Long[] serverTimes = {getRegisterTime(serverAdresse), lastUpdateTime};
                entry.setValue(serverTimes);

            } //neuer Server
            else {
                Long[] serverStartTime = {System.currentTimeMillis(), System.currentTimeMillis()};
                onlineServerListe.put(serverAdresse, serverStartTime);
            }
        }
        updateMonitor();
    }
}
