package HesClient;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import java.rmi.*;
import HESServer.HESServer;
import HESServer.RmiServerInterface;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NED
 */
public class HesServiceClient {

    public static void main(String[] args) throws Exception {

        // Assign security manager
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }

        InetAddress host1 = InetAddress.getByName("141.22.95.128");
        InetAddress host3 = InetAddress.getByName("141.22.85.215");
        
        List<InetAddress> liste = new ArrayList<InetAddress>();
        liste.add(host1);
        liste.add(host3);
        HESMonitor hesMonitor = new HESMonitor(liste);
        hesMonitor.start();
        while(!hesMonitor.getOnlineListe().isEmpty()){
       InetAddress host2 =  hesMonitor.getOnlineListe().get(0);
        // Call registry for PowerService
   //     RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://localhost/HESServer");
       
        RmiServerInterface service2 = (RmiServerInterface) Naming.lookup("rmi://"+host2+"/HESServer");
        System.out.println("verbunden!");

//        AdresseTyp adr1 = new AdresseTyp("Berliner Tors", 5, 20537, "Hamburg", "Germany");
//        TelefonNrTyp telNr = new TelefonNrTyp("040", 12345689);
//        System.out.println(service.erstelleKunde("first", "last", adr1, telNr).toString());

        AdresseTyp adr2 = new AdresseTyp("Berliner Tors", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr2 = new TelefonNrTyp("040", 12345689);
        System.out.println(service2.erstelleKunde("first2", "last2", adr2, telNr2).toString());

      //  Boolean anwort = service.areYouAlive();
    }
    }
}
