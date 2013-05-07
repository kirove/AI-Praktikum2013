/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.AngebotTyp;
import Datentypen.RechnungTyp;
import Verkauf.Angebot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class RechnungLogic implements IRechnungFassade {

    RechnungRepository RR;

    @Override
    public RechnungTyp erstelleRechnung(double betrag, String auftragNr, Date date, String KundenNr) {

        return this.RR.createRechnung(betrag, auftragNr, date, KundenNr).getTyp();
    }

    @Override
    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr) {

        List<RechnungTyp> RechnungListe = new ArrayList<>();
        List<Rechnung> aListe = this.RR.getRechnungen(kundenNr);

        for (int i = 0; i < aListe.size(); i++) {
            RechnungListe.add(aListe.get(i).getTyp());
        }
        return RechnungListe;

    }

    @Override
    public RechnungTyp getRechnungPerID(String rechnungsNr) throws Exception{
            return this.RR.getRechnung(rechnungsNr).getTyp();
    }

    @Override
    public RechnungTyp getRechnungPerAuftragNr(String auftragNr) throws Exception {
        return this.RR.getRechnung(auftragNr).getTyp();
    }
}
