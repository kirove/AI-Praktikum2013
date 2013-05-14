/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Datentypen.KundenTyp;
import Exceptions.KundeException;
import Exceptions.SQLException;
import Main.HibernateUtil;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class KundeRepository {

    public Kunde erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws SQLException {
        Kunde newkunde = new Kunde(vorName, nachName, adresse, telefon);

        try {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(newkunde);
            session.getTransaction().commit();
        } catch (Exception ex) {
            throw new SQLException("Kunde könnte nicht erstellt worden!!");

        }
        return newkunde;
    }

    public Kunde getKunde(String kdnr) throws SQLException {
        List<Kunde> kunden = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSession();
            kunden = session.createQuery("FROM Kunde kunde WHERE kundenNr = :kdnr")
                    .setParameter("kdnr", kdnr).list();
        } catch (Exception ex) {
            throw new SQLException("getKunde per kundenNummer Anfrage Exception!");
        }

        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public Kunde getKunde(TelefonNrTyp tel) throws SQLException {
        List<Kunde> kunden = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSession();
            kunden = session.createQuery("FROM Kunde kunde WHERE telNr = :tel")
                    .setParameter("tel", tel).list();
        } catch (Exception ex) {
            throw new SQLException("getKunde per TelefonNummer Anfrage Exception!");
        }
        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public Kunde getKunde(String vorname, String nachname, AdresseTyp adresse) throws SQLException {
        List<Kunde> kunden = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSession();
            kunden = session.createQuery("FROM Kunde kunde WHERE vorname = :vorname AND nachname = :nachname AND adresse = :adresse")
                    .setParameter("nachname", nachname)
                    .setParameter("vorname", vorname)
                    .setParameter("adresse", adresse)
                    .list();
        } catch (Exception ex) {
            throw new SQLException("getKunde per Name, Adresse Anfrage Exception!");
        }
        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public void save(Kunde kunde) throws SQLException, KundeException {
        if (kunde != null) {
            try {
                Session session = HibernateUtil.getSession();
                session.beginTransaction();
                session.save(kunde);
                session.getTransaction().commit();
            } catch (Exception ex) {
                throw new SQLException("saveKunde Exception!");
            }
        } else {
            throw new KundeException("kann nicht leeres KundenObject speichern!");
        }
    }
}
