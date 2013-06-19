package HESKonnektor;

import Betriebsteam.Dashboard;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class Monitor extends Thread {

    private Map<InetAddress, Long[]> onlineServerListe;
    Dashboard dashboard;

    public Monitor(Dispatcher dis) {
        System.out.println("Starting Monitor..");
        this.onlineServerListe = new HashMap<>();
                
        //Dashboard Controller
        Dashboard dashboard = new Dashboard(dis);
        dashboard.setVisible(true);
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
                                dashboard.updateDashboard(onlineServerListe);
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

        dashboard.updateDashboard(onlineServerListe);
    }
    
      public void updateDashboard(InetAddress server, Integer anzahl){
          dashboard.updateDashboard(server, anzahl);
      }
              
}
