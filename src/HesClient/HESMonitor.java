/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HesClient;

import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
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
    private JLabel LabelAlpha, LabelBeta;

    public HESMonitor(JLabel LabelAlpha, JLabel LabelBeta) {
        this.liste = new ArrayList<>();
        try {
            InetAddress host1 = InetAddress.getByName("141.22.88.112");
            InetAddress host2 = InetAddress.getByName("141.22.85.213");

            liste.add(host1);
            liste.add(host2);
        } catch (UnknownHostException ex) {
            System.out.println("Cannot find Host!");
        }
        this.onlineListe = new ArrayList<>();
        this.LabelAlpha = LabelAlpha;
        this.LabelBeta = LabelBeta;
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
                System.out.println("verfügbare server: " + onlineListe);
                sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void updateList() {

        onlineListe.clear();
        int port = Registry.REGISTRY_PORT;
        for (InetAddress adr : liste) {
            try {
                SocketAddress sockaddr = new InetSocketAddress(adr, port);
                Socket socket = new Socket();
                socket.connect(sockaddr, 500);
                socket.close();
                System.out.println("Verbunden mit dem Server " + adr.getHostName());

                onlineListe.add(adr);
                updateMonitor(onlineListe);
            } catch (IOException ex) {
                // Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Server: " + adr + " ist ausgeschaltet!");
            }
        }
        updateMonitor(onlineListe);
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
        System.out.println("updating monitor");
        System.out.println("online liste " + onlineListe);
        if (!onlineListe.isEmpty() || onlineListe == null) {
            for (InetAddress host : onlineListe) {
                if (host.getHostAddress().equals("141.22.88.112")) {
                    LabelAlpha.setText("Online");
                    LabelAlpha.setForeground(Color.green);
                } else {
                    System.out.println("am here");
                    LabelAlpha.setText("Offline");
                    LabelAlpha.setForeground(Color.red);
                }
                if (host.getHostAddress().equals("141.22.85.213")) {
                    LabelBeta.setText("Online");
                    LabelBeta.setForeground(Color.green);
                } else {
                    System.out.println("am here beta");
                    LabelBeta.setText("Offline");
                    LabelBeta.setForeground(Color.red);
                }
            }
        } else {
            System.out.println("liste ist empty");
            LabelAlpha.setText("Offline");
            LabelAlpha.setForeground(Color.red);
            LabelBeta.setText("Offline");
            LabelBeta.setForeground(Color.red);
        }
    }
}
