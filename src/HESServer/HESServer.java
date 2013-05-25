/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HESServer;

import Datentypen.AdresseTyp;
import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;
import Verkauf.IVerkauf;
import Verkauf.VerkaufFassade;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Server-Programme implementieren das Interface Remote und erweitern
 * java.rmi.server.UnicastRemoteObject, welches die wichtigsten Methoden für die
 * Verwendung von RMI bereitstellt.
 *
 */
public class HESServer extends UnicastRemoteObject implements RmiServerInterface {

    private static final long serialVersionUID = -851919772922635440L;
    private IVerkauf VF;

    HESServer() throws RemoteException {
        super();
        this.VF = new VerkaufFassade();
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        // Assign a security manager, in the event that dynamic
        // classes are loaded
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }
        try {

            Naming.rebind("HESServer", new HESServer());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public KundenTyp getKunde(String kundeNr) throws KundeException, RemoteException {
        return VF.getKunde(kundeNr);
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) throws KundeException, RemoteException {
        return VF.getKunde(vorname, nachname, adresse);
    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) throws KundeException, RemoteException {
        return VF.getKunde(tel);
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp dresse, TelefonNrTyp telefon) throws KundeException, RemoteException {
        return VF.erstelleKunde(vorName, nachName, dresse, telefon);
    }

    @Override
    public ProduktTyp fordereProduktInformationen(String produktNummer) throws RemoteException {
        return VF.fordereProduktInformationen(produktNummer);
    }

    @Override
    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe) throws RemoteException {
        return VF.erstelleAngebot(kunde, gueltigBis, produktListe);
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) throws RemoteException {
        return VF.erstelleAuftrag(angebot);
    }

    @Override
    public List<AngebotTyp> getAngebot(String kundenName) throws RemoteException {
        return VF.getAngebot(kundenName);
    }

    @Override
    public List<AuftragTyp> getAuftrag(String kundenName) throws RemoteException {
        return VF.getAuftrag(kundenName);
    }

    @Override
    public AngebotTyp getAngebotPerAngebotNr(String angebotNr) throws RemoteException {
        return VF.getAngebotPerAngebotNr(angebotNr);
    }

    @Override
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr) throws RemoteException {
        return VF.getAuftragPerAuftragNr(auftragNr);
    }
}
