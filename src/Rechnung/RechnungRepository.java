/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp;
import Exceptions.SQLException;
import Main.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class RechnungRepository {

    private Exception SQLException;

    public Rechnung createRechnung(double betrag, String auftragNr, Date date, String KundenNr) {
        Rechnung newRechnung = new Rechnung(betrag, auftragNr, date, KundenNr);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newRechnung);
        session.getTransaction().commit();

        return newRechnung;
    }

    List<Rechnung> getRechnungen(String kundenNr) {
        List<Rechnung> rechnungenListe = null;
        // get from DB
        return rechnungenListe;
    }

    Rechnung getRechnung(String rechnungsNr) {

        Session session = HibernateUtil.getSession();
        List<Rechnung> rechnungen = session
                .createQuery("FROM Rechnung rechnung WHERE id = :rechnungsNr")
                .setParameter("rechnungsNr", rechnungsNr).list();

        Rechnung rechnung = null;
        if (!rechnungen.isEmpty()) {
            rechnung = rechnungen.get(0);
        }

        return rechnung;
    }

    Rechnung getRechnungPerAuftragNr(String auftragNr) {
        
        Session session = HibernateUtil.getSession();
        List<Rechnung> rechnungen = session
                .createQuery("FROM Rechnung rechnung WHERE auftragNr = :auftragNr")
                .setParameter("auftragNr", auftragNr).list();

        Rechnung rechnung = null;
        if (!rechnungen.isEmpty()) {
            rechnung = rechnungen.get(0);
        }

        return rechnung;
    }
}
