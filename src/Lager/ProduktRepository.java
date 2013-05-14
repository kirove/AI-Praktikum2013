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

    public static Produkt getProdukt(String produktNummer) {

        Session session = HibernateUtil.getSession();
        List<Produkt> produkte = session
                .createQuery("FROM Produkt produkt WHERE produktNr = :produktNummer")
                .setParameter("produktNummer", produktNummer).list();
        Produkt produkt = null;
        if (!produkte.isEmpty()) {
            produkt = produkte.get(0);
        }

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
