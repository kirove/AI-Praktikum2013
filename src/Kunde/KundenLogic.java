package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;

/**
 *
 * @author NED
 */
public class KundenLogic implements IKundeFassade {

    KundeRepository KR;

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) {
        return this.KR.erstelleKunde(vorName, nachName, adresse, telefon).getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String kundeNr) {
        return this.KR.getKunde(kundeNr).getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) {
        return this.KR.getKunde(tel).getKundenTyp();
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) {
        return this.KR.getKunde(vorname, nachname, adresse).getKundenTyp();
    }
}
