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
 * @author Barzgun
 */
public interface ILagerFassade extends ILagerManager {

    public ProduktTyp erstelleProdukt(String name, String produktNr, int lagerBestand, double preis);

    public List<ProduktTyp> getProduktList();

    public ProduktTyp fordereProduktInformationen(int produktNummer);

    public boolean isLagerbestandAusreichend(AngebotTyp angebot);

    public void triggerWareneingang(ProduktTyp produkt, int produktMenge);

    public void triggerWarenAusgang(ProduktTyp produkt, int produktMenge);

    public WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp angebot);

    public WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung);

    public List<ProduktTyp> produktReservieren(AngebotTyp angebot);
}
