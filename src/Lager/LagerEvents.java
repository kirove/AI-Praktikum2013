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
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.DateTimeAtProcessing;

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
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() + produktMenge));

    }

    @Override
    public void triggerWarenAusgang(ProduktTyp produkt, int produktMenge) {
        Produkt produktNeu = new Produkt(produkt.getName(), produkt.getProduktNr(), (produkt.getLagerBestand() - produktMenge));

    }

    @Override
    public WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp auftrag) {
        Map<ProduktTyp, Integer> produktListe = auftrag.getAngebot().getProduktListe();
        WarenAusgangMeldung wam = new WarenAusgangMeldung(new Date(), produktListe);
        return wam.getTyp();
    }

    @Override
    public WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung) {
        Map<ProduktTyp, Integer> produktListe = bestellung.getProduktListe();
        WarenEingangMeldung wem = new WarenEingangMeldung(new Date(), produktListe);
        return wem.getTyp();
    }

    @Override
    public void produktReservieren(AngebotTyp angebot) {
        for (Map.Entry<ProduktTyp, Integer> pr : angebot.getProduktListe().entrySet()) {
            ProduktTyp produktTyp = pr.getKey();
            Produkt produkt = new Produkt(produktTyp.getName(), produktTyp.getProduktNr(), produktTyp.getLagerBestand());
            produkt.setReserviert();
            int lagerBestand = produkt.getLagerBestand();
            int lagerBestandNeu = lagerBestand - pr.getValue();
            produkt.setLagerBestand(lagerBestandNeu);
        }
    }
}
