/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp2;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public class RechnungLogic implements IRechnungManager{

    @Override
    public RechnungTyp2 erstelleRechnung(int betrag, String auftragNr, Date date, String KundenNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RechnungTyp2> getRechnungenPerKunde(String kundenNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RechnungTyp2 getRechnungPerID(String rechnungsNr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
