/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import java.util.*;

/**
 *
 * @author NED
 */
public interface IAngebotManager {

    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe);

    public List<AngebotTyp> sucheAngebote(String kundenName);

    public AngebotTyp sucheAngebotePerNr(String kundenNr);
}
