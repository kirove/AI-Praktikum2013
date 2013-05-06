package Main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Kunde.Kunde;

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

        AdresseTyp adr = new AdresseTyp("Berliner Tor", 5, 20537, "Hamburg", "Germany");
        TelefonNrTyp telNr = new TelefonNrTyp("040", 123456);
        Kunde k1 = new Kunde("hans", "peter", adr, telNr);
        saveOrUpdate(k1);
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
