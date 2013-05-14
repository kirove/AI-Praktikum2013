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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class KundeRepository {

    public Kunde erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws SQLClientInfoException {
        Kunde newkunde = new Kunde(vorName, nachName, adresse, telefon);

        try{
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newkunde);
        session.getTransaction().commit();
        }catch (Exception ex){
            KundeException ke = new KundeException();
            
        }
        return newkunde;
    }

    public Kunde getKunde(String kdnr) {

        Session session = HibernateUtil.getSession();
        List<Kunde> kunden = session
                .createQuery("FROM Kunde kunde WHERE kundenNr = :kdnr")
                .setParameter("kdnr", kdnr).list();
        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public Kunde getKunde(TelefonNrTyp tel) {

        Session session = HibernateUtil.getSession();
        List<Kunde> kunden = session
                .createQuery("FROM Kunde kunde WHERE telNr = :tel")
                .setParameter("tel", tel).list();
        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public Kunde getKunde(String vorname, String nachname, AdresseTyp adresse) {

        Session session = HibernateUtil.getSession();
        List<Kunde> kunden = session
                .createQuery("FROM Kunde kunde WHERE vorname = :vorname AND nachname = :nachname AND adresse = :adresse")
                .setParameter("nachname", nachname)
                .setParameter("vorname", vorname)
                .setParameter("adresse", adresse)
                .list();
        Kunde kunde = null;
        if (!kunden.isEmpty()) {
            kunde = kunden.get(0);
        }
        return kunde;
    }

    public static void save(Kunde kunde) {
        if (kunde != null) {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(kunde);
            session.getTransaction().commit();
        }
    }
}
