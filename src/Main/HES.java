package Main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Datentypen.AdresseTyp;
import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import Datentypen.TelefonNrTyp;
import Einkauf.Bestellung;
import Kunde.IKundeFassade;
import Kunde.Kunde;
import Kunde.KundenLogic;
import Lager.ILagerFassade;
import Lager.LagerLogic;
import Lager.Produkt;
import Lager.WarenAusgangMeldung;
import Lager.WarenEingangMeldung;
import Lieferant.Lieferant;
import Rechnung.IBank;
import Rechnung.IRechnungFassade;
import Rechnung.RechnungLogic;
import Transport.TransportRepository;
import Verkauf.AngebotLogic;
import Verkauf.AuftragLogic;
import Verkauf.IAngebotManager;
import Verkauf.IAuftragManager;
import Verkauf.IVerkauf;
import java.util.Date;
import java.util.HashMap;

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
        Date datum = new Date((long) 20000);
        KundenTyp kundenT = new KundenTyp("12-3", "Sohrab", "Duck", adr1, telNr);
        AngebotTyp angebotT = new AngebotTyp("222", kundenT, datum, produktListe, 1500.00);
        AuftragTyp auftragT = new AuftragTyp("2-3", angebotT, false, datum);

        AdresseTyp adr2 = new AdresseTyp("Hauptstr.", 1, 33423, "Hamburg", "Germany");
        Lieferant lieferant1 = new Lieferant("DELL", adr2);

        //Kunden erstellen
        IKundeFassade kf = new KundenLogic();
        kf.erstelleKunde("Sergej", "Chan", adr1, telNr);
        kf.erstelleKunde("Nicolay", "Anderson", adr1, telNr);
        kf.erstelleKunde("Nidal", "Smith", adr1, telNr);

        //Produkt erstellen
        ILagerFassade lf = new LagerLogic();
        lf.erstelleProdukt("Thinkpad", "435-f", 999, 1400);
        lf.erstelleProdukt("Macbook", "234-r", 999, 1700);
        lf.erstelleProdukt("ALDI-PC", "238-w", 999, 700);

        //Lieferung erstellen
        //TransportRepository.erstelleLieferung(auftragT);

        //Angebot erstellen
        IAngebotManager am1 = new AngebotLogic();
        // am1.erstelleAngebot(kundenT, datum, produktListe);

        //Auftrag erstellen
        IAuftragManager am2 = new AuftragLogic();
        //am2.erstelleAuftrag(angebotT);

        //Rechnung erstellen
        IRechnungFassade rf = new RechnungLogic();
        //rf.erstelleRechnung(3000.00, "234-r", datum, "345");
        // überall NULLPOINTER?!

        WarenAusgangMeldung wam = new WarenAusgangMeldung(datum, produktListe);
        WarenEingangMeldung wem = new WarenEingangMeldung(datum, produktListe);
        
        session.close();
        
        // Date ist irgendwie nicht richtig?!
        //saveOrUpdate(wam);
        //saveOrUpdate(wem);
    }

    private static void saveOrUpdate(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.saveOrUpdate(object);
            // Committing the change in the database.
            session.flush();
            transaction.commit();

        } catch (Exception ex) {
            ex.printStackTrace();

            // Rolling back the changes to make the data consistent in case of any failure
            // in between multiple database write operations.
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
