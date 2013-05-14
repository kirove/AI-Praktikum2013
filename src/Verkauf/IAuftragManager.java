package Verkauf;

import Datentypen.*;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IAuftragManager {

    public List<AuftragTyp> sucheAuftrage(String kundenName);

    public AuftragTyp sucheAuftragePerNr(String auftragNr);

    public AuftragTyp schliesseAuftrag(AuftragTyp auftrag);

    public AuftragTyp erstelleAuftrag(AngebotTyp angebot);

    public List<AuftragTyp> getNichtAbgeschlosseneAuftraege();
    
    public void schliesseBezahlteAuftraege();
}
