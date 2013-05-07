package Kunde;

import Datentypen.*;

/**
 *
 * @author NED
 */
public interface IKundeManager {

    public KundenTyp erstelleKunde(String vorName, String nachName, String adresse, TelefonNrTyp telefon);

    public KundenTyp getKunde(String kundeNr);
    
    public KundenTyp getKunde(TelefonNrTyp tel);
    
    public KundenTyp getKunde(String vorname,String nachname, AdresseTyp adresse);
}
