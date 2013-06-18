package HESDispatcher;

import HESServer.RmiServerInterface;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class Dispatcher extends Thread {

    public HESMonitor monitor;
    private Deque<InetAddress> dq = new ArrayDeque<>();
    // private List<RmiServerInterface> onlineRMIServers;
    public List<InetAddress> onlineServers;
    // [Server, Anfragen] tubel
    private Map<InetAddress, Integer> serverAnfragen;

    public Dispatcher() {
        System.out.println("starting Dispatcher");
        monitor = new HESMonitor();
        monitor.start();
        //  onlineRMIServers = new ArrayList<>();
        this.serverAnfragen = new HashMap<>();

    }

    public RmiServerInterface liefereServer() {

        if (!dq.isEmpty()) {

            try {
                // Remove Host from the Top and connect RMI
                InetAddress server = dq.removeFirst();
                RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://" + server.getHostAddress() + "/HESServer");

                dq.addLast(server); // Put the Host back at the End
                setAnfragenZaehler(server);
                
                return service;
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.err.println("Noch sind keine Server angemeldet!");
        }
        return null;
    }

    public void setAnfragenZaehler(InetAddress server) {
        if (!serverAnfragen.containsKey(server)) {
            serverAnfragen.put(server, 1);
        } else {
            serverAnfragen.put(server, serverAnfragen.get(server) + 1);
        }
        monitor.updateMonitor(server,serverAnfragen.get(server));
    }
    /*
     public synchronized void getOnlineRMIServers() {
     onlineRMIServers.clear();
     List<InetAddress> monitorServerListe = monitor.getOnlineListe();
     if (!monitorServerListe.isEmpty()) {
     for (InetAddress host : monitorServerListe) {
     try {
     RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://" + host.getHostAddress() + "/HESServer");
     this.onlineRMIServers.add(service);
     this.serverAnfragen.put(host, 0);



     } catch (NotBoundException | MalformedURLException | RemoteException ex) {
     Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     }
     }
     */

    public void run() {
        while (!isInterrupted()) {
            try {
                updateQueue();
                sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void updateQueue() {
//        getOnlineRMIServers();
//        if (this.onlineRMIServers.isEmpty()) {
//            dq.clear();
//        } else {
//            //Add new Servers to the Quee
//            for (RmiServerInterface service : this.onlineRMIServers) {
//                if (!dq.contains(service)) {
//                    dq.addLast(service);
//                }
//            }
//            //Remove Servers that are in the Quee but not in the OnlineList
//            for (RmiServerInterface service : this.dq) {
//                if (!onlineRMIServers.contains(service)) {
//                    dq.remove(service);
//                }
//            }
//        }
//        System.out.println("verfügbare server: " + dq);
//    }
        this.onlineServers = monitor.getOnlineListe();
        if (onlineServers.isEmpty()) {
            dq.clear();
        } else {
            //Add new Servers to the Quee
            for (InetAddress server : this.onlineServers) {
                if (!dq.contains(server)) {
                    dq.addLast(server);
                }
            }
            //Remove Servers that are in the Quee but not in the OnlineList
            for (InetAddress server : this.dq) {
                if (!onlineServers.contains(server)) {
                    dq.remove(server);
                }
            }
        }
        System.out.println("verfügbare server: " + dq);
    }
}
