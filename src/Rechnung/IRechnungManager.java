
package Rechnung;

import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp2;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IRechnungManager {
    public RechnungTyp2 erstelleRechnung(int betrag, String auftragNr, Date date, String KundenNr);

    public List<RechnungTyp2> getRechnungenPerKunde(String kundenNr);

    public RechnungTyp2 getRechnungPerID(String rechnungsNr);
    
}
