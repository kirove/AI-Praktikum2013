
package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author NED
 */
public class AngebotRepository {
    
    public Angebot erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe, Double gesamtKosten){
        Angebot angebot = new Angebot(kunde, gueltigBis, produktListe,gesamtKosten);
        
        // save in DatenBank Todo
        return angebot;
    }

    public List<Angebot> getAngebote(String kundenName) {
        List<Angebot> angebotListe = null;
        //get alle Angebot anhand KundenName
       return angebotListe;
    }

    public Angebot getAngebot(String angebotNr) {
        Angebot angebot = null;
        // get angebot from DatenBank anhand KundenNr
         return angebot;
    }
}
