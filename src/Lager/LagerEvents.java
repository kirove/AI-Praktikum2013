 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.BestellungTyp;
import Datentypen.WarenAusgangMeldungTyp;
import Datentypen.ProduktTyp;
import Datentypen.WarenEingangMeldungTyp;
import Main.HibernateUtil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.DateTimeAtProcessing;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class LagerEvents implements ILagerEvents {

    @Override
    public List<ProduktTyp> getProduktList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLagerbestandAusreichend(AngebotTyp angebot) {
        boolean ausreichend = false;
        for (Map.Entry<ProduktTyp, Integer> entry : angebot.getProduktListe().entrySet()) {
            if (!(entry.getKey().getLagerBestand() - entry.getValue() >= 0)) {
                return false;
            } else {
                ausreichend = true;
            }
        }
        return ausreichend;
    }

    @Override
    public void triggerWareneingang(ProduktTyp produkt, int produktMenge) {
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() + produktMenge),produkt.getPreis());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(produktNeu);
        session.getTransaction().commit();
    }

    @Override
    public void triggerWarenAusgang(ProduktTyp produkt, int produktMenge) {
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() - produktMenge),produkt.getPreis());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(produktNeu);
        session.getTransaction().commit();
    }

    @Override
    public WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp auftrag) {
        Map<ProduktTyp, Integer> produktListe = auftrag.getAngebot().getProduktListe();
        WarenAusgangMeldung wam = new WarenAusgangMeldung(new Date(), produktListe);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(wam);
        session.getTransaction().commit();

        return wam.getTyp();
    }

    @Override
    public WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung) {
        Map<ProduktTyp, Integer> produktListe = bestellung.getProduktListe();
        WarenEingangMeldung wem = new WarenEingangMeldung(new Date(), produktListe);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(wem);
        session.getTransaction().commit();

        return wem.getTyp();
    }

    @Override
    public void produktReservieren(AngebotTyp angebot) {
        for (Map.Entry<ProduktTyp, Integer> pr : angebot.getProduktListe().entrySet()) {
            ProduktTyp produktTyp = pr.getKey();
            Produkt produkt = new Produkt(produktTyp.getName(), produktTyp.getProduktNr(), produktTyp.getLagerBestand(),produktTyp.getPreis());
            produkt.setReserviert();
            int lagerBestand = produkt.getLagerBestand();
            int lagerBestandNeu = lagerBestand - pr.getValue();
            produkt.setLagerBestand(lagerBestandNeu);
        }
    }
}
