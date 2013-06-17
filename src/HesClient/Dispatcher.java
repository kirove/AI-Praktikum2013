package HESClient;

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class Dispatcher extends Thread {

    public HESMonitor monitor;
    private Deque<RmiServerInterface> dq = new ArrayDeque<>();
    private List<RmiServerInterface> onlineRMIServers;

    public Dispatcher() {
        monitor = new HESMonitor();
        monitor.start();
        onlineRMIServers = new ArrayList<>();

    }

    public RmiServerInterface liefereServer() {

        if (!dq.isEmpty()) {

            RmiServerInterface host = dq.removeFirst(); // Remove Host from the Top
            dq.addLast(host); // Put the Host back at the End

            return host;
        } else {
            System.err.println("Noch sind keine Server angemeldet!");
            return null;
        }
    }

    public synchronized void getOnlineRMIServers() {
        onlineRMIServers.clear();
        List<InetAddress> monitorServerListe = monitor.getOnlineListe();
       
        for (InetAddress host : monitorServerListe) {
            try {
                RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://" + host.getHostAddress() + "/HESServer");
                this.onlineRMIServers.add(service);


            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void run() {
        while (!isInterrupted()) {
            try {
               /* getOnlineRMIServers();
                if (this.onlineRMIServers.isEmpty()) {
                    dq.clear();
                } else {
                    for (RmiServerInterface server : this.onlineRMIServers) {
                        if (!dq.contains(server)) {
                            dq.addLast(server);
                        }
                    }
                }
                System.out.println("verfügbare server: " + dq);*/
                updateQueue();
                sleep(3000);
            } catch (InterruptedException e) {
            } catch (Exception ex) {
            }
        }
    }
    
    private void updateQueue(){
        getOnlineRMIServers();
                if (this.onlineRMIServers.isEmpty()) {
                    dq.clear();
                } else {
                    for (RmiServerInterface server : this.onlineRMIServers) {
                        if (!dq.contains(server)) {
                            dq.addLast(server);
                        }
                    }
                }
                System.out.println("verfügbare server: " + dq);
    }
}
