package Rechnung;

import Datentypen.RechnungTyp;
import Exceptions.RechnungException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class ZahlungsEingangLogic implements IBank {

    RechnungRepository RR;

    @Override
    public void zahlungseingangBuchen(double betrag, String rechnungsNr) {
        try {
            Rechnung rechnung = RR.getRechnung(rechnungsNr);
            if (rechnung.getBetrag() <= betrag) {
                rechnung.setIsBezahlt(true);
            } else {
                rechnung.setBetrag(rechnung.getBetrag() - betrag);

            }
        } catch (Exception ex) {
            Logger.getLogger(ZahlungsEingangLogic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
