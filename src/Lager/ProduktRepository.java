/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import Main.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

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
        return null;//produktListe;
    }
}
