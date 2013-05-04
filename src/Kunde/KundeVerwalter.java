/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Datentypen.KundenTyp;

/**
 *
 * @author NED
 */
public class KundeVerwalter implements IKundeManager {

    @Override
    public KundenTyp erstelleKunde(KundenTyp kunde) {
        Kunde newkunde = new Kunde(kunde.getvorName(), kunde.getnachName(), kunde.getAdresse(),kunde.getTelNr());
       // erstelle Kunde in der DatenBank
       // create(kunde);
        
        return newkunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String kundeNr) {
        
        // select Kunde anhand kunde ID
        return kunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) {
        
         // select Kunde anhand kunde TelefonNummer
        return kunde.getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) {
        
         // select Kunde anhand kunde Vorname, Nachname, Adresse
        return kunde.getKundenTyp();
    }
}
