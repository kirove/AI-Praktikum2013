/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AuftragTyp;
import Datentypen.BestellungTyp;
import Datentypen.ProduktTyp;
import Main.HibernateUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class LagerRepository {

    public static void triggerWareneingang(ProduktTyp produkt, int produktMenge) {
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() + produktMenge), produkt.getPreis());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(produktNeu);
        session.getTransaction().commit();
    }

    public static void triggerWarenAusgang(ProduktTyp produkt, int produktMenge) {
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() - produktMenge), produkt.getPreis());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(produktNeu);
        session.getTransaction().commit();
    }

    public static WarenAusgangMeldung triggerWarenAusgangMeldung(AuftragTyp auftrag) {
        HashMap<ProduktTyp, Integer> produktListe = auftrag.getAngebot().getProduktListe();
        WarenAusgangMeldung wam = new WarenAusgangMeldung(new Date(), produktListe);
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//        session.save(wam);
//        session.getTransaction().commit();

        return wam;
    }

    public static WarenEingangMeldung triggerWarenEingangMeldung(BestellungTyp bestellung) {
        HashMap<ProduktTyp, Integer> produktListe = bestellung.getProduktListe();
        WarenEingangMeldung wem = new WarenEingangMeldung(new Date(), produktListe);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(wem);
        session.getTransaction().commit();

        return wem;
    }
}
