/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import Main.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author NED
 */
public class ProduktRepository {

    public static Produkt erstelleProdukt(String name, String produktNr, int lagerBestand, double preis) {
        Produkt produkt = new Produkt(name, produktNr, lagerBestand, preis);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(produkt);
        session.getTransaction().commit();
        return produkt;
    }

    public static List<ProduktTyp> getProduktList() {
        // get liste aller Produkte
        List<ProduktTyp> result = null;

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        result = session.createSQLQuery(null).list();

        session.flush();
        tx.commit();
        session.close();

        return result;//produktListe;
    }

    public static Produkt getProdukt() {
        Produkt produkt = null;
        // hybernate
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        produkt = (Produkt) session.createSQLQuery(null);

        session.flush();
        tx.commit();
        session.close();
        // hybernate
        return produkt;//produkt;
    }

    public static void save(Produkt produkt) {
        if (produkt != null) {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(produkt);
            session.getTransaction().commit();
        }
    }
}
