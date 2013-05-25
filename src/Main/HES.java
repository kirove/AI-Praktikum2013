package Main;

import Client.ClientInterface;
import Datentypen.*;
import Exceptions.KundeException;
import Exceptions.RechnungException;
import Lager.ILagerFassade;
import Lager.LagerFassade;


import Rechnung.IBank;
import Rechnung.IRechnungFassade;
import Rechnung.RechnungLogic;
import Rechnung.ZahlungsEingangLogic;
import Verkauf.AuftragLogic;
import Verkauf.IAuftragManager;

import Verkauf.IVerkauf;
import Verkauf.VerkaufFassade;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NED
 */
public class HES {

    /**
     * @param args the command line arguments
     */
    private static Session session;

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

        ClientInterface gui= new ClientInterface();
        gui.setVisible(true);
        //Typen erstellen
        AdresseTyp adr1 = new AdresseTyp("Berliner Tor", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 123456);
        HashMap<ProduktTyp, Integer> produktEinkaufList = new HashMap<ProduktTyp, Integer>();
        Date datum = new Date((long) 10);

        //Produkt erstellen @Der Lagerist
        ILagerFassade lf = new LagerFassade();
        ProduktTyp thinkpad = lf.erstelleProdukt("Thinkpad", "435-f", 999, 1400);
        ProduktTyp macbook = lf.erstelleProdukt("Macbook", "234-r", 999, 1700);
        ProduktTyp aldiPC = lf.erstelleProdukt("ALDI-PC", "238-w", 999, 700);

        //Zugriff auf die Fassade per GUI 
        IVerkauf verkaufFassade = new VerkaufFassade();

        /* 
         * Kunde interiessert sich für Produkte
         * Kunde ruft an 
         * Agent legt neu Kunde im System
         * oder ruft vorhandene Kunden aus dem Datenbank
         */

        //Kunden erstellen
        try {
            KundenTyp neueKundeSergej = verkaufFassade.erstelleKunde("Sergej", "Chan", adr1, telNr);
            KundenTyp neueKundeNiko = verkaufFassade.erstelleKunde("Nikolay", "Anderson", adr1, telNr);
            KundenTyp neueKundeNidal = verkaufFassade.erstelleKunde("Nidal", "Smith", adr1, telNr);


            //Kunde holen per vorname, nachname, Adresse
            KundenTyp stammKundeNiko1 = verkaufFassade.getKunde("Nikolay", "Anderson", adr1);
            //Kunde holen per KundenNummer
            KundenTyp stammKundeNiko2 = verkaufFassade.getKunde(neueKundeNiko.getKundenNr());
            //Kunde holen per TelefonNummer
            KundenTyp stammKundeNiko3 = verkaufFassade.getKunde(neueKundeNiko.getTelNr());

            System.out.println("Kunde Information: " + stammKundeNiko2.toString());


            /*
             * Kunde fragt nach Produkte
             * Agent ruft Produkt aus dem DatenBank per ProduktNummer
             */

            ProduktTyp thinkPad = verkaufFassade.fordereProduktInformationen(thinkpad.getProduktNr());

            System.out.println("Produckt Information: " + thinkPad.toString());

            /*
             * Kunde hat mehrere Produkte zusammen gefasst
             * Agent erstellt Angebot
             */
            
            produktEinkaufList.put(aldiPC, 20);
            produktEinkaufList.put(thinkPad, 2);
            produktEinkaufList.put(macbook, 20);
            AngebotTyp angebotfüerNiko = verkaufFassade.erstelleAngebot(stammKundeNiko1, datum, produktEinkaufList);

            System.out.println("Angebot wurde erstellt: " + angebotfüerNiko.toString());

            /*
             * Kunde entscheidet sich für das Angebot
             * Agent legt Auftrag im DatenBank per angebot
             */

            AuftragTyp auftragfuerNiko = verkaufFassade.erstelleAuftrag(angebotfüerNiko);

            System.out.println("Auftrag erstellt :" + auftragfuerNiko.toString());

            /*
             * nach dem Auftrag Erstellung wird eine Lieferung automatich (falls lager Bestand ausreichend ist)erstellt 
             * sowie eine Rechnung
             */

            /*
             *  Die Bank greift auf unser Schnitstelle (IBank) und benachricht ZahlungEingan
             *  per RechnungNummer und Betrag
             */

            IRechnungFassade RF = new RechnungLogic();
            RechnungTyp rechnung1 = RF.getRechnungPerAuftragNr(auftragfuerNiko.getAuftragsNr());

            //Überweisung ist angekommen
            IBank sparkasse = new ZahlungsEingangLogic();
            sparkasse.zahlungseingangBuchen(500000, rechnung1.getId());

            /*
             * Jede Nacht wird diese Process aufgerufen um bezahlte Auftrage ab zu schliessen
             */
            IAuftragManager iAuftragManager = new AuftragLogic();
            iAuftragManager.schliesseBezahlteAuftraege();


            //Zeige das Neue Status des Auftrages
            System.out.println(verkaufFassade.getAuftragPerAuftragNr(auftragfuerNiko.getAuftragsNr()));

        } catch (KundeException kEx) {
            System.out.println(kEx.getMessage());
        } catch (RechnungException rEx) {
            System.out.println(rEx.getMessage());
        }
        session.close();
    }
}
