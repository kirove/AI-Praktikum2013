package HesClient;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import java.rmi.*;
import HESServer.HESServer;
import HESServer.RmiServerInterface;

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

        // Call registry for PowerService
        RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://localhost/HESServer");
        RmiServerInterface service2 = (RmiServerInterface) Naming.lookup("rmi://141.22.81.199/HESServer");

        AdresseTyp adr1 = new AdresseTyp("Berliner Tors", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 12345689);
        System.out.println(service.erstelleKunde("first", "last", adr1, telNr).toString());

        AdresseTyp adr2 = new AdresseTyp("Berliner Tors", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr2 = new TelefonNrTyp("040", 12345689);
        System.out.println(service2.erstelleKunde("first2", "last2", adr2, telNr2).toString());

    }
}