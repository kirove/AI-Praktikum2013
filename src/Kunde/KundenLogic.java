package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class KundenLogic implements IKundeFassade {

    KundeRepository KR;
    IKundeFassade kf;
    private Exception KundeException;

    public KundenLogic() {
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws KundeException {
        try {
            return this.KR.erstelleKunde(vorName, nachName, adresse, telefon).getKundenTyp();
        } catch (Exception ex) {
            throw new KundeException();

        }
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

    @Override
    public void save(KundenTyp kunde) {
        Kunde kunde1;
        kunde1 = new Kunde(kunde.getvorName(), kunde.getnachName(), kunde.getAdresse(), kunde.getTelNr());
        if (kunde1 != null) {
            KundeRepository.save(kunde1);
        }
    }
}
