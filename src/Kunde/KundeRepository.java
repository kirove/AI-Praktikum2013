/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Datentypen.KundenTyp;
import Main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class KundeRepository {

    public static Kunde erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) {
        Kunde newkunde = new Kunde(vorName, nachName, adresse, telefon);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newkunde);
        session.getTransaction().commit();

        return newkunde;
    }

    public Kunde getKunde(String kundeNr) {

        // select Kunde anhand kunde ID
        return null;//kunde.getKundenTyp();
    }

    public Kunde getKunde(TelefonNrTyp tel) {

        // select Kunde anhand kunde TelefonNummer
        return null;//kunde.getKundenTyp();
    }


    public Kunde getKunde(String vorname, String nachname, AdresseTyp adresse) {

        // select Kunde anhand kunde Vorname, Nachname, Adresse
        return null;//kunde.getKundenTyp();
    }
}
