 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.BestellungTyp;
import Datentypen.WarenAusgangMeldungTyp;
import Datentypen.ProduktTyp;
import Datentypen.WarenEingangMeldungTyp;
import Main.HibernateUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.DateTimeAtProcessing;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class LagerLogic {

    public static boolean isLagerbestandAusreichend(AngebotTyp angebot) {
        boolean ausreichend = false;
        for (Map.Entry<ProduktTyp, Integer> entry : angebot.getProduktListe().entrySet()) {
            if (!(entry.getKey().getLagerBestand() - entry.getValue() >= 0)) {
                return false;
            } else {
                ausreichend = true;
            }
        }
        return ausreichend;
    }
    
    public static WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp auftrag) {
        return LagerRepository.triggerWarenAusgangMeldung(auftrag).getTyp();
    }

     public static WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung) {
        return LagerRepository.triggerWarenEingangMeldung(bestellung).getTyp();
    }
}
