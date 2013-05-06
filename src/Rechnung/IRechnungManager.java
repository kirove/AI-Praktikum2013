/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IRechnungManager {
    public RechnungTyp erstelleRechnung(int betrag, String auftragNr);

    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr);

    public RechnungTyp getRechnungPerID(String rechnungsNr);
    
}
