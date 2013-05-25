package HesClient;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import java.rmi.*;
import rmiServer.RmiServerInterface;

/**
 *
 * @author NED
 */
public class HesServiceClient {

    public static void main(String[] args) throws Exception {

        // Assign security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        // Call registry for PowerService
        RmiServerInterface service = (RmiServerInterface) Naming.lookup("rmi://localhost/HesServer");
        AdresseTyp adr1 = new AdresseTyp("Berliner Tors", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 12345689);
        System.out.println(service.erstelleKunde("first","last",adr1, telNr).toString());
        


    }
}
