/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NED
 */
public interface IAngebotManager {

    public Angebot erstelleAngebot(String kundenName,
            Date gueltigBis, Map<String, Integer> produktListe);

    public List<Angebot> sucheAngebote(String kundenName);
}
