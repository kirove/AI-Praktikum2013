package HesClient;

import Client.ClientInterface;
import HESServer.RmiServerInterface;
import java.awt.Color;
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
import javax.swing.JLabel;

/**
 *
 * @author NED
 */
public class Dispatcher extends Thread {

    public HESMonitor monitor;
    private Deque<RmiServerInterface> dq = new ArrayDeque<>();
    private List<RmiServerInterface> onlineRMIServers;


    public Dispatcher(JLabel LabelAlpha, JLabel LabelBeta) {
        monitor = new HESMonitor(LabelAlpha, LabelBeta);
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

    public List<RmiServerInterface> getOnlineRMIServers() {
        for (InetAddress host : monitor.getOnlineListe()) {
            try {
                RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://" + host.getHostAddress() + "/HESServer");
                onlineRMIServers.add(service);

               

            } catch (NotBoundException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return onlineRMIServers;
    }

    public void run() {
        List<RmiServerInterface> serverliste;
        while (!isInterrupted()) {
            try {
                serverliste = getOnlineRMIServers();
                if (dq.isEmpty()) {
                    dq.addAll(serverliste);
                } else {
                    for (RmiServerInterface server : dq) {
                        if (!serverliste.contains(server)) {
                            dq.addLast(server);
                        }
                    }
                }

                sleep(3000);
            } catch (InterruptedException e) {
            } catch (Exception ex) {
            }
        }
    }
}
