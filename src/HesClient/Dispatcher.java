package HesClient;

import HESServer.RmiServerInterface;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.rmi.Naming;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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

    public List<RmiServerInterface> getOnlineRMIServers() throws Exception {
        for (InetAddress host : monitor.getOnlineListe()) {
            onlineRMIServers.add((RmiServerInterface) Naming.lookup("rmi://" + host + "/HESServer"));
        }

        return onlineRMIServers;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                List<RmiServerInterface> serverliste = getOnlineRMIServers();
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
                System.out.println("Noch ist keine Server Online!");
            }
        }
    }
}
