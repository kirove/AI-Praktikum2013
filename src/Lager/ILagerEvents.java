/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.ProduktTyp;
import Datentypen.MeldungTyp;
import Datentypen.BestellungTyp;
import Einkauf.*;
import java.util.List;
import Verkauf.*;
/**
 *
 * @author NED
 */
public interface ILagerEvents {
    public List<ProduktTyp> getProduktList();
    public boolean isLagerbestandAusreichend(AngebotTyp angebot);
    public void triggerWareneingang(ProduktTyp produkt, int produktMenge);
    public MeldungTyp triggerWarenAusgangMeldung(AngebotTyp angebot);
    public MeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung);
    public ProduktTyp produktReservieren(AngebotTyp angebot);
}
