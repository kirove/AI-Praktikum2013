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
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Entfernte Methoden werden durch das Interface java.rmi.Remote definiert
 *
 */
public interface RmiServerInterface extends Remote {
    //   public void method() throws RemoteException;//Eine RemoteException kann z.B. auftreten, wenn das entfernte Objekt nicht mehr verfügbar ist oder wenn das Netz gestört ist.

    public KundenTyp getKunde(String kundeNr) throws KundeException, RemoteException;

    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) throws KundeException, RemoteException;

    public KundenTyp getKunde(TelefonNrTyp tel) throws KundeException, RemoteException;

    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp dresse, TelefonNrTyp telefon) throws KundeException, RemoteException;

    public ProduktTyp fordereProduktInformationen(String produktNummer) throws RemoteException;

    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe) throws RemoteException;

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) throws RemoteException;

    public List<AngebotTyp> getAngebot(String kundenName) throws RemoteException;

    public List<AuftragTyp> getAuftrag(String kundenName) throws RemoteException;

    public AngebotTyp getAngebotPerAngebotNr(String angebotNr) throws RemoteException;

    public AuftragTyp getAuftragPerAuftragNr(String auftragNr) throws RemoteException;

//    public Boolean areYouAlive() throws RemoteException;
}
