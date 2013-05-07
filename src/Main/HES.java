package Main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Datentypen.AdresseTyp;
import Datentypen.ProduktTyp;
import Datentypen.TelefonNrTyp;
import Einkauf.Bestellung;
import Kunde.Kunde;
import Lager.ILagerFassade;
import Lager.Produkt;
import Lieferant.Lieferant;
import Verkauf.IVerkauf;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NED
 */
public class HES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Kunden erstellen
        AdresseTyp adr1 = new AdresseTyp("Berliner Tor", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 123456);
        Kunde kunde1 = new Kunde("hans", "peter", adr1, telNr);
        
        //Lieferanten erstellen
        AdresseTyp adr2 = new AdresseTyp("Hauptstr.",1,33423,"Hamburg","Germany");
        Lieferant lieferant1 = new Lieferant("DELL",adr2);
        
        //Produkte erstellen
      //  Produkt produkt1 = new Produkt("Laptop", "42", 9999,5.2);
        ILagerFassade ip = null;
       ProduktTyp produktTyp;
        //Bestellung erstellen
      //  HashMap<ProduktTyp, Integer> produktListe;
     //   produktListe.put(produkt1, 2);
     //   Bestellung bestellung1= new Bestellung("213", produktliste, lieferant1);
        
        //Angebot erstellen
        IVerkauf verkaufInterface = null;
        verkaufInterface.erstelleKunde("sergej", "osman", adr1, telNr);
        verkaufInterface.getAngebot("sergej");
        //Auftrag erstellen
        
        //Bestellung erstellen
        produktTyp = ip.erstelleProdukt("Laptop", "42", 999,5.2);
        
        
        //in Datenbank persestieren
        saveOrUpdate(kunde1);
        saveOrUpdate(lieferant1);
        saveOrUpdate(produktTyp);
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

    private static void delete(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(object);
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
