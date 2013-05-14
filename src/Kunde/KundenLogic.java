package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;
import Exceptions.SQLException;

/**
 *
 * @author NED
 */
public class KundenLogic implements IKundeFassade {

    KundeRepository KR;
    private Exception KundeException;

    public KundenLogic() {
        KR = new KundeRepository();
    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws KundeException {
        KundenTyp kunde;
        try {
            kunde = this.KR.erstelleKunde(vorName, nachName, adresse, telefon).getKundenTyp();

        } catch (SQLException ex) {
            throw new KundeException(ex.getMessage());
        }
        if (kunde == null) {
            throw new KundeException("Kann der Kunde " + vorName + " nicht erstellen!?");
        } else {
            return kunde;
        }

    }

    @Override
    public KundenTyp getKunde(String kundeNr) throws KundeException {

        KundenTyp kunde;
        try {
            kunde = this.KR.getKunde(kundeNr).getKundenTyp();

        } catch (SQLException ex) {
            throw new KundeException(ex.getMessage());
        }
        if (kunde == null) {
            throw new KundeException("Kann der Kunde mit der Kunden Nummer " + kundeNr + "nicht finden!?");
        } else {
            return kunde;
        }
    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) throws KundeException {

        KundenTyp kunde;
        try {
            kunde = this.KR.getKunde(tel).getKundenTyp();

        } catch (SQLException ex) {
            throw new KundeException(ex.getMessage());
        }
        if (kunde == null) {
            throw new KundeException("Kann der Kunde mit der Kunden TelefonNummer " + tel + "nicht finden!?");
        } else {
            return kunde;
        }
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) throws KundeException {

        KundenTyp kunde;
        try {
            kunde = this.KR.getKunde(vorname, nachname, adresse).getKundenTyp();

        } catch (SQLException ex) {
            throw new KundeException(ex.getMessage());
        }
        if (kunde == null) {
            throw new KundeException("Kann der Kunde " + vorname + "nicht finden!?");
        } else {
            return kunde;
        }
    }

    @Override
    public void save(KundenTyp kundeTyp) throws KundeException {
        Kunde kunde;
        kunde = new Kunde(kundeTyp.getvorName(), kundeTyp.getnachName(), kundeTyp.getAdresse(), kundeTyp.getTelNr());
        try {
            KR.save(kunde);
        } catch (SQLException sqlEx){
            sqlEx.getMessage();
        }
    }
}
