package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NED
 */
public class AuftragLogic implements IAuftragManager {

    AuftragRepository AR;

    @Override
    public List<AuftragTyp> sucheAuftrage(String kundenName) {
        List<AuftragTyp> auftragListe = new ArrayList<>();
        List<Auftrag> aListe = this.AR.getAuftrage(kundenName);

        for (int i = 0; i < aListe.size(); i++) {
            auftragListe.add(aListe.get(i).getTyp());
        }

        return auftragListe;
    }

    @Override
    public AuftragTyp sucheAuftragePerNr(String auftragNr) {
        return this.AR.getAuftragPerNr(auftragNr).getTyp();
    }

    @Override
    public AuftragTyp schliesseAuftrag(Auftrag auftrag) {
        auftrag.setIsAbgeschlossen(true);
        
        return this.AR.updateAuftrag(auftrag).getTyp();
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        
    }
}
