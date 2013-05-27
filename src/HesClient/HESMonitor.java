/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HesClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
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

    public HESMonitor(List<InetAddress> liste) {
        this.liste = liste;
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
                System.out.println("verfügbare server: "+onlineListe);
                sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void updateList() {
      //  boolean alive = false;
        onlineListe.clear();
        int port = Registry.REGISTRY_PORT;
        for (InetAddress adr : liste) {
            try {
              // long tm = System.nanoTime();
                Socket so = new Socket(adr, port);
                so.close();
          //      alive = true;
                onlineListe.add(adr);
            } catch (IOException ex) {
               // Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Server: "+adr+" ist ausgeschaltet!");
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
