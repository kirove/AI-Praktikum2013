package Main;

import Datentypen.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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

        //Typen erstellen
        AdresseTyp adr1 = new AdresseTyp("Berliner Tor", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 123456);
        ProduktTyp produktT = new ProduktTyp("Laptop", "345", 9999, 1200);
        HashMap<ProduktTyp, Integer> produktListe = new HashMap<ProduktTyp, Integer>();
        produktListe.put(produktT, 1);
        Date datum = new Date((long) 10);
        AdresseTyp adr2 = new AdresseTyp("Hauptstr.", 1, 33423, "Hamburg", "Germany");

        //Produkt erstellen
        ILagerFassade lf = new LagerFassade();
        ProduktTyp thinkpad = lf.erstelleProdukt("Thinkpad", "435-f", 999, 1400);
        ProduktTyp macbook = lf.erstelleProdukt("Macbook", "234-r", 999, 1700);
        ProduktTyp aldiPC = lf.erstelleProdukt("ALDI-PC", "238-w", 999, 700);

        //Kunden erstellen
        IVerkauf verkaufF = new VerkaufFassade();
        KundenTyp sergej = verkaufF.erstelleKunde("Sergej", "Chan", adr1, telNr);
        KundenTyp niko = verkaufF.erstelleKunde("Nikolay", "Anderson", adr1, telNr);
        KundenTyp nidal = verkaufF.erstelleKunde("Nidal", "Smith", adr1, telNr);


        //Szenario
        //hole Kunde
        // KundenTyp kunde1 = verkaufF.getKunde("Nicolay","Anderson",adr1);
        //KundenTyp kunde1 = verkaufF.getKunde(niko.getKundenNr());
        KundenTyp kunde1 = verkaufF.getKunde(niko.getvorName(), niko.getnachName(), niko.getAdresse());
        System.out.println("Kunde Information: " + kunde1.toString());

        //hole Produktinformation
        ProduktTyp thinkPad = verkaufF.fordereProduktInformationen(thinkpad.getProduktNr());
        System.out.println("Produckt Information: " + thinkPad.toString());

        //erstelle Angebot
        AngebotTyp angebot1 = verkaufF.erstelleAngebot(kunde1, datum, produktListe);
        System.out.println("Angebot wurde erstellt: " + angebot1.toString());


        //erstelle Auftrag
        AuftragTyp auftrag1 = verkaufF.erstelleAuftrag(angebot1);
        System.out.println("Auftrag erstellt :" + auftrag1.toString());

        //auftrag status
        //  auftrag1.toString();

        // get rechnung 
        IRechnungFassade RF;
        RF = new RechnungLogic();
        RechnungTyp rechnung1 = RF.getRechnungPerAuftragNr(auftrag1.getAuftragsNr());

        //Überweisung ist angekommen
        IBank sparkasse;
        sparkasse = new ZahlungsEingangLogic();
        sparkasse.zahlungseingangBuchen(500000, rechnung1.getId());

        //nacht ablauf (bezahlte verträge abschliessen)

        IAuftragManager iam = new AuftragLogic();
        iam.schliesseBezahlteAuftraege();
        
       
        //get neue Auftrag status
        System.out.println(verkaufF.getAuftragPerAuftragNr(auftrag1.getAuftragsNr()));
        session.close();
    }
//    private static void saveOrUpdate(Object object) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = session.beginTransaction();
//
//            session.saveOrUpdate(object);
//            // Committing the change in the database.
//            session.flush();
//            transaction.commit();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//            // Rolling back the changes to make the data consistent in case of any failure
//            // in between multiple database write operations.
//            transaction.rollback();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
}
