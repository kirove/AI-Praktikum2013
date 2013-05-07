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


public class KundeVerwalter implements IKundeManager {

    @Override
    public KundenTyp erstelleKunde(KundenTyp kunde) {
        Kunde newkunde = new Kunde(kunde.getvorName(), kunde.getnachName(), kunde.getAdresse(),kunde.getTelNr());
       // erstelle Kunde in der DatenBank
       // create(kunde);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newkunde);
        session.getTransaction().commit();
        
        return newkunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String kundeNr) {
        
        // select Kunde anhand kunde ID
        return null;//kunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) {
        
         // select Kunde anhand kunde TelefonNummer
        return null;//kunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) {
        
         // select Kunde anhand kunde Vorname, Nachname, Adresse
        return null;//kunde.getKundenTyp();
    }
}
