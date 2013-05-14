
package Rechnung;

import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp;
import Exceptions.RechnungException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IRechnungFassade {
    public RechnungTyp erstelleRechnung(double betrag, String auftragNr, Date date, String KundenNr) throws RechnungException ;

    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr)throws RechnungException ;

    public RechnungTyp getRechnungPerID(String rechnungsNr)throws RechnungException ;
    
    public RechnungTyp getRechnungPerAuftragNr(String auftragNr)throws RechnungException ;
    
}
