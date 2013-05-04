/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.BestellungTyp;
import Datentypen.MeldungTyp;
import Datentypen.ProduktTyp;
import java.util.List;

/**
 *
 * @author NED
 */
public class LagerEvents implements ILagerEvents {

    @Override
    public List<ProduktTyp> getProduktList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLagerbestandAusreichend(AngebotTyp angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerWareneingang(ProduktTyp produkt, int produktMenge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MeldungTyp triggerWarenAusgangMeldung(AngebotTyp angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProduktTyp produktReservieren(AngebotTyp angebot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
