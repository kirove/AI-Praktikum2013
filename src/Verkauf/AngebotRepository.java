
package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author NED
 */
public class AngebotRepository {
    
    public Angebot erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe, Double gesamtKosten) throws Exception{
        Angebot angebot = new Angebot(kunde, gueltigBis, produktListe,gesamtKosten);
        if (angebot == null)
            throw SQLException;
        
        // save in DatenBank Todo
        return angebot;
    }

    public List<Angebot> getAngebote(String kundenName) throws Exception  {
        if (null)
            throw SQLException
        //get alle Angebot anhand KundenName
       return angebotListe;
    }

    public Angebot getAngebot(String angebotNr) throws Exception{
        if (null)
            throw SQLException;
        // get angebot from DatenBank anhand KundenNr
         return angebot;
    }
}
