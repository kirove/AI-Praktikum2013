/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.ProduktTyp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Barzgun
 */
public class ProduktLogic {

    public static List<ProduktTyp> produktReservieren(AngebotTyp angebot) {
        List<ProduktTyp> produktListe = new ArrayList<>();

        for (Map.Entry<ProduktTyp, Integer> pr : angebot.getProduktListe().entrySet()) {
            ProduktTyp produktTyp = pr.getKey();
            Produkt produkt = new Produkt(produktTyp.getName(), produktTyp.getProduktNr(), produktTyp.getLagerBestand(), produktTyp.getPreis());
            produkt.setReserviert();
            int lagerBestand = produkt.getLagerBestand();
            int lagerBestandNeu = lagerBestand - pr.getValue();
            produkt.setLagerBestand(lagerBestandNeu);

            produktListe.add(produkt.getTyp());
        }
        return produktListe;
    }
}
