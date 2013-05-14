package Rechnung;

import Datentypen.AngebotTyp;
import Datentypen.RechnungTyp;
import Exceptions.RechnungException;
import Exceptions.SQLException;
import Verkauf.Angebot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public class RechnungLogic implements IRechnungFassade {

    RechnungRepository RR;

    public RechnungLogic() {
        this.RR = new RechnungRepository();
    }

    @Override
    public RechnungTyp erstelleRechnung(double betrag, String auftragNr, Date date, String KundenNr) throws RechnungException {
        RechnungTyp rechnungTyp;
        try {
            rechnungTyp = this.RR.createRechnung(betrag, auftragNr, date, KundenNr).getTyp();
        } catch (SQLException ex) {
            throw new RechnungException(ex.getMessage());
        }
        if (rechnungTyp == null) {
            throw new RechnungException("Kann die Rechnung mit der KundenNummer " + KundenNr + " nicht erstellen!?");
        } else {
            return rechnungTyp;
        }

    }

    @Override
    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr) throws RechnungException {

        List<RechnungTyp> rechnungListe = new ArrayList<>();
        List<Rechnung> aListe;
        try {
            aListe = this.RR.getRechnungen(kundenNr);

        } catch (SQLException sqlEx) {
            throw new RechnungException(sqlEx.getMessage());
        }
        // umwandeln auf Rechnung Typ
        for (int i = 0; i < aListe.size(); i++) {
            rechnungListe.add(aListe.get(i).getTyp());
        }
        if (rechnungListe.isEmpty()) {
            throw new RechnungException(" Keine Rechnungen mit der KundeNummer " + kundenNr + " gefunden");
        } else {
            return rechnungListe;
        }
    }

    @Override
    public RechnungTyp getRechnungPerID(String rechnungsNr) throws RechnungException {
        RechnungTyp rechnungTyp;

        try {
            rechnungTyp = this.RR.getRechnung(rechnungsNr).getTyp();
        } catch (SQLException sqlEx) {
            throw new RechnungException(sqlEx.getMessage());
        }
        if (rechnungTyp == null) {
            throw new RechnungException("Keine Rechnungen mit der RechnungNummer " + rechnungsNr + " gefunden ");
        } else {
            return rechnungTyp;
        }
    }

    @Override
    public RechnungTyp getRechnungPerAuftragNr(String auftragNr) throws RechnungException {

        RechnungTyp rechnungTyp;
        try {
            rechnungTyp = this.RR.getRechnungPerAuftragNr(auftragNr).getTyp();
        } catch (SQLException sqlEx) {
            throw new RechnungException(sqlEx.getMessage());
        }
        if (rechnungTyp == null) {
            throw new RechnungException("Keine Rechnungen mit der AuftragNr " + auftragNr + " gefunden ");
        } else {
            return rechnungTyp;
        }
    }
}
