/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HesClient;

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

/**
 *
 *
 */
public class HESMonitor extends Thread {
    
    private List<InetAddress> liste;
    private List<InetAddress> onlineListe;
    
    public HESMonitor() {
        this.liste = new ArrayList<>();
        try {
        InetAddress  host1 = InetAddress.getByName("141.22.88.112");
        InetAddress host2 = InetAddress.getByName("141.22.85.213");
 
        liste.add(host1);
        liste.add(host2);
        } catch (UnknownHostException ex) {
            System.out.println("Cannot find Host!");
        }
        this.onlineListe = new ArrayList<>();
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
                System.out.println("Verbunden mit dem Server "+adr.getHostName());
                
                onlineListe.add(adr);
            } catch (IOException ex) {
                // Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Server: " + adr + " ist ausgeschaltet!");
            }
        }
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
}
