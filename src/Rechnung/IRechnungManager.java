
package Rechnung;

import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IRechnungManager {
    public RechnungTyp erstelleRechnung(int betrag, String auftragNr, Date date, String KundenNr);

    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr);

    public RechnungTyp getRechnungPerID(String rechnungsNr);
    
}
