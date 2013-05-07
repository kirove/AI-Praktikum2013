/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public class RechnungRepository {

    public Rechnung createRechnung(int betrag, String auftragNr, Date date, String KundenNr) {
        Rechnung newRechnung = new Rechnung(betrag, auftragNr, date, KundenNr);

        //save in datenBank
        return newRechnung;
    }

    List<Rechnung> getRechnungen(String kundenNr) {
        // get from DB
        return rechnungenListe;
    }

    Rechnung getRechnung(String rechnungsNr) {
        //get from DB
        return rechnung;
    }
}
