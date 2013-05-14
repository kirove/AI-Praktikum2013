/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp;
import Exceptions.RechnungException;
import Exceptions.SQLException;
import Main.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class RechnungRepository {

    private Exception SQLException;

    public Rechnung createRechnung(double betrag, String auftragNr, Date date, String KundenNr) throws SQLException {
        Rechnung newRechnung = new Rechnung(betrag, auftragNr, date, KundenNr);
        try {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(newRechnung);
            session.getTransaction().commit();
        } catch (Exception ex) {
            throw new SQLException("Rechnung könnte nicht erstellt worden!!");
        }
        return newRechnung;
    }

    List<Rechnung> getRechnungen(String kundeNr) throws SQLException, RechnungException {
        List<Rechnung> rechnungen = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();
            rechnungen = session.createQuery("FROM Rechnung rechnung WHERE kundeNr = :kundeNr")
                    .setParameter("kundeNr", kundeNr).list();
        } catch (Exception ex) {
            throw new SQLException("getRechnung per KundenNummer Exception!");
        }

        if (rechnungen.isEmpty()) {
            throw new RechnungException(" Keine Rechnung mit der KundenNummer " + kundeNr + " gefunden!");
        } else {

            return rechnungen;
        }
    }

    Rechnung getRechnung(String rechnungsNr) throws SQLException, RechnungException {
        List<Rechnung> rechnungen = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();
            rechnungen = session.createQuery("FROM Rechnung rechnung WHERE id = :rechnungsNr")
                    .setParameter("rechnungsNr", rechnungsNr).list();
        } catch (Exception ex) {
            throw new SQLException("getRechnung per RechnungNummer Exception!");
        }
        Rechnung rechnung = null;
        if (!rechnungen.isEmpty()) {
            rechnung = rechnungen.get(0);
        } else {
            throw new RechnungException(" Keine Rechnung mit der Nummer " + rechnungsNr + " gefunden!");
        }
        return rechnung;
    }

    Rechnung getRechnungPerAuftragNr(String auftragNr) throws SQLException, RechnungException {
        List<Rechnung> rechnungen = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();
            rechnungen = session.createQuery("FROM Rechnung rechnung WHERE auftragNr = :auftragNr")
                    .setParameter("auftragNr", auftragNr).list();
        } catch (Exception ex) {
            throw new SQLException("getRechnung per AuftragNummer Exception!");
        }
        Rechnung rechnung = null;
        if (!rechnungen.isEmpty()) {
            rechnung = rechnungen.get(0);
        } else {
            throw new RechnungException(" Keine Rechnung mit der AuftragNummer " + auftragNr + " gefunden!");
        }
        return rechnung;
    }
}
