package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Datentypen.KundenTyp;

/**
 *
 * @author NED
 */
public interface IKundeManager {

    public KundenTyp erstelleKunde(KundenTyp kunde);

    public KundenTyp getKunde(String kundeNr);
    
    public KundenTyp getKunde(TelefonNrTyp tel);
    
    public KundenTyp getKunde(String vorname,String nachname, AdresseTyp adresse);
}
