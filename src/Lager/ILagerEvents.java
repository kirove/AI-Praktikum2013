/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.ProduktTyp;
import Datentypen.WarenAusgangMeldungTyp;
import Datentypen.BestellungTyp;
import Datentypen.WarenEingangMeldungTyp;
import Einkauf.*;
import java.util.List;
import Verkauf.*;

/**
 *
 * @author NED
 */
public interface ILagerEvents extends ILager{

    public List<ProduktTyp> getProduktList();

    public boolean isLagerbestandAusreichend(AngebotTyp angebot);

    public void triggerWareneingang(ProduktTyp produkt, int produktMenge);

    public void triggerWarenAusgang(ProduktTyp produkt, int produktMenge);

    public WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp angebot);

    public WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung);

    public void produktReservieren(AngebotTyp angebot);
}
