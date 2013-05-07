/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp;
import Exceptions.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public class RechnungRepository {
    private Exception SQLException;

    public Rechnung createRechnung(int betrag, String auftragNr, Date date, String KundenNr) {
        Rechnung newRechnung = new Rechnung(betrag, auftragNr, date, KundenNr);

        //save in datenBank
        return newRechnung;
    }

    List<Rechnung> getRechnungen(String kundenNr) {
        List<Rechnung> rechnungenListe = null;
        // get from DB
        return rechnungenListe;
    }

    Rechnung getRechnung(String rechnungsNr) throws Exception {
        //get from DB
        Rechnung rechnung = null ;
        if (rechnung == null)
            throw SQLException;
        return rechnung;
    }
}
