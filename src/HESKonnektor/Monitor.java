package HESKonnektor;

import Betriebsteam.Dashboard;
import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author NED
 */
public class Monitor extends Thread {

    private Map<InetAddress, Long[]> onlineServerListe;
    private JLabel labelAlpha, labelBeta, labelAlphaTime, labelBetaTime, labelAlphaCount, labelBetaCount;
    private JButton betaButton, alphaButton;
    private InetAddress server1;
    private InetAddress server2;
    Dashboard dashboard;

    public Monitor(Dispatcher dis) {
        System.out.println("Starting Monitor..");
        this.onlineServerListe = new HashMap<>();
        try {
            this.server1 = InetAddress.getByName("169.254.149.147");
            this.server2 = InetAddress.getByName("141.22.95.125");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //Dashboard Controller
        Dashboard dashboard = new Dashboard(dis);
        dashboard.setVisible(true);
        this.labelAlpha = dashboard.getLabelAlpha();
        this.labelBeta = dashboard.getLabelBeta();
        this.labelAlphaTime = dashboard.getLabelAlphaTime();
        this.labelBetaTime = dashboard.getLabelBetaTime();
        this.labelAlphaCount = dashboard.getLabelAlphaCount();
        this.labelBetaCount = dashboard.getLabelBetaCount();
        labelAlphaCount.setText("0 Anfragen");
        labelBetaCount.setText("0 Anfragen");
        this.alphaButton = dashboard.getAlphaButton();
        this.betaButton = dashboard.getBetaButton();
        this.alphaButton.setName(server1.getHostAddress());
        this.betaButton.setName(server2.getHostAddress());



    }

    @Override
    public void run() {

        //Thread to calculate the lastUpdateTime and remove Server from OnlineServerListe if time difference is more than 2 Seconds
        new Thread() {
            @Override
            public void run() {

                while (true) {
                    if (!onlineServerListe.isEmpty()) {
                        for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {
                            //if lastUpdateTime is longer than 3 Seconds remove Server from the list
                            if ((System.currentTimeMillis() - getlastUpdateTime(entry.getKey())) > 3000) {
                                System.out.println("Removing at: " + (System.currentTimeMillis() - getlastUpdateTime(entry.getKey())));
                                onlineServerListe.remove(entry.getKey());
                                updateDashboard();
                            }
                        }
                    }
                    //System.out.println("onlineServer Monitor sicht "+ onlineServerListe);

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

            System.out.println("Waiting for Server..");
            while (true) {
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println(" From: "+ receivePacket.getAddress()+" RECEIVED: " + sentence );

                if (sentence.indexOf("AM ALIVE") > -1) {

                    updateServerOnlineListe(receivePacket.getAddress());
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();


        } catch (IOException ex) {
            Logger.getLogger(Monitor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateDashboard(InetAddress server, Integer anzahl) {
        System.out.println("server to update " + server.getHostAddress());

        if (server.equals(server1)) {
            labelAlphaCount.setText(anzahl + " Anfragen");
        } else if (server.equals(server2)) {
            labelBetaCount.setText(anzahl + " Anfragen");
        }




    }

    private void updateDashboard() {

        if (onlineServerListe.keySet().contains(server1)) {
            labelAlpha.setForeground(Color.green);
            labelAlpha.setText("Online");
            alphaButton.setText("Off");
            
            labelAlphaTime.setText(((System.currentTimeMillis() - onlineServerListe.get(server1)[0]) / 1000) + " Seconds");
        } else {
            labelAlpha.setForeground(Color.red);
            labelAlpha.setText("Offline");
            alphaButton.setText("ON");
            labelAlphaTime.setText("0 Seconds");
        }
        if (onlineServerListe.keySet().contains(server2)) {
            labelBeta.setForeground(Color.green);
            labelBeta.setText("Online");
            betaButton.setText("Off");
            labelBetaTime.setText(((System.currentTimeMillis() - onlineServerListe.get(server2)[0]) / 1000) + " Seconds");
        } else {
            labelBeta.setForeground(Color.red);
            labelBeta.setText("Offline");
            betaButton.setText("ON");
            labelBetaTime.setText("0 Seconds");
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

    public List<InetAddress> getOnlineListe() {
        return new ArrayList<InetAddress>(onlineServerListe.keySet());
    }

    public Long getRegisterTime(InetAddress onlineServerAddress) {

        if (onlineServerListe.containsKey(onlineServerAddress)) {
            return onlineServerListe.get(onlineServerAddress)[0];
        } else {
            return Long.MIN_VALUE;
        }
    }

    public Long getlastUpdateTime(InetAddress onlineServerAddress) {
        if (onlineServerListe.containsKey(onlineServerAddress)) {
            return onlineServerListe.get(onlineServerAddress)[1];
        } else {
            return Long.MAX_VALUE;
        }
    }

    private void updateServerOnlineListe(InetAddress serverAdresse) {

        //loop throw onlineServerList to check if server already registered

        if (!onlineServerListe.keySet().contains(serverAdresse)) {
            //new Server
            Long[] serverStartTime = {System.currentTimeMillis(), System.currentTimeMillis()};
            onlineServerListe.put(serverAdresse, serverStartTime);
        } else {
            Long lastUpdateTime = System.currentTimeMillis();
            Long[] serverTimes = {getRegisterTime(serverAdresse), lastUpdateTime};
            onlineServerListe.put(serverAdresse, serverTimes);
        }

        updateDashboard();
    }
}
