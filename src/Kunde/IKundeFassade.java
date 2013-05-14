package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;

/**
 *
 * @author NED
 */
public interface IKundeFassade {

    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws KundeException;

    public KundenTyp getKunde(String kundeNr) throws KundeException;

    public KundenTyp getKunde(TelefonNrTyp tel)throws KundeException;

    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse)throws KundeException;

    public void save(KundenTyp kunde)throws KundeException;
}
