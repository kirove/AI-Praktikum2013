/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HESClient;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 *
 */
public class HESMonitor extends Thread {

    private List<InetAddress> liste;
    private List<InetAddress> onlineListe;
    private JLabel labelAlpha, labelBeta;
    private InetAddress host1, host2;
    final private static int udpPort = 55555;

    public HESMonitor() {
        this.liste = new ArrayList<>();
        try {
            this.host1 = InetAddress.getByName("141.22.84.202");
            this.host2 = InetAddress.getByName("141.22.87.102");

            liste.add(host1);
            liste.add(host2);
        } catch (UnknownHostException ex) {
            System.out.println("Cannot find Host!");
        }
        this.onlineListe = new ArrayList<>();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        JLabel labelAl = dashboard.getLabelAlpha();
        JLabel labelBe = dashboard.getLabelBeta();
        this.labelAlpha = labelAl;
        this.labelBeta = labelBe;
    }

    public List<InetAddress> getOnlineListe() {
        return onlineListe;
    }

    public void addElem(InetAddress inetAdress) {
        liste.add(inetAdress);
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                updateList();
                sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void updateList() {



        DatagramSocket serverSocket;

        try {
            serverSocket = new DatagramSocket(udpPort);

            for (InetAddress adr : liste) {
                byte[] sendData = new byte[256];

                sendData = (adr.getHostAddress() + " is Connecting...").getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, adr, udpPort);
                try {
                    serverSocket.send(sendPacket);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

            while (true) {
                onlineListe.clear();
                byte[] receiveData = new byte[256];


                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);

                if (sentence.equalsIgnoreCase("AM ALIVE")) {
                    onlineListe.add(receivePacket.getAddress());
                }
                updateMonitor(onlineListe);
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        /////////////////////////////////////////////////////////////////////////
/*
         onlineListe.clear();

         for (InetAddress adr : liste) {
         try {
         SocketAddress sockaddr = new InetSocketAddress(adr, port);
         Socket socket = new Socket();
         socket.connect(sockaddr, 3000);
         socket.close();
         System.out.println("Verbunden mit dem Server " + adr.getHostName());

         onlineListe.add(adr);
         } catch (IOException ex) {
         // Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
         System.err.println("Server: " + adr + " ist ausgeschaltet!");
         }
         }
         updateMonitor(onlineListe);
         */
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.liste);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HESMonitor other = (HESMonitor) obj;
        if (!Objects.equals(this.liste, other.liste)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HESMonitor{" + "liste=" + liste + '}';
    }

    private void updateMonitor(List<InetAddress> onlineListe) {

        //  if (!onlineListe.isEmpty() || onlineListe == null) {

        if (onlineListe.contains(host1)) {
            labelAlpha.setText("Online");
            labelAlpha.setForeground(Color.green);
        } else {
            labelAlpha.setText("Offline");
            labelAlpha.setForeground(Color.red);
        }
        if (onlineListe.contains(host2)) {
            labelBeta.setText("Online");
            labelBeta.setForeground(Color.green);
        } else {
            labelBeta.setText("Offline");
            labelBeta.setForeground(Color.red);
        }

//        } else {
//            labelAlpha.setText("Offline");
//            labelAlpha.setForeground(Color.red);
//            labelBeta.setText("Offline");
//            labelBeta.setForeground(Color.red);
//        }
    }
}
