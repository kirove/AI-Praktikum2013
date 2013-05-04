package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.TelefonNrTyp;
import Datentypen.KundenTyp;
import java.util.UUID;

/**
 *
 * @author NED
 */
public class Kunde {

    private String kundenNr;
    private String vorname;
    private String nachname;
    private AdresseTyp adresse;
    private TelefonNrTyp telNr;

    private Kunde() {
    }

    public Kunde(String vorname, String nachname, AdresseTyp adresse, TelefonNrTyp telNr) {
        this.kundenNr = "KundeID:" + UUID.randomUUID();
        this.vorname = vorname;
        this.adresse = adresse;
        this.telNr = telNr;
    }

    public KundenTyp getKundenTyp() {
        return new KundenTyp(kundenNr, vorname, nachname, adresse, telNr);
    }

    String getKundenNr() {
        return kundenNr;
    }

    void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    String getvorName() {
        return vorname;
    }

    void setvorName(String vorname) {
        this.vorname = vorname;
    }

    String getnachName() {
        return nachname;
    }

    void setnachName(String nachname) {
        this.nachname = nachname;
    }

    AdresseTyp getAdresse() {
        return adresse;
    }

    void setAdresse(AdresseTyp adresse) {
        this.adresse = adresse;
    }

    public TelefonNrTyp getTelNr() {
        return telNr;
    }

    public void setTelNr(TelefonNrTyp telNr) {
        this.telNr = telNr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kunde{");
        sb.append("kunden-Nummer='").append(kundenNr);
        sb.append(", Vorname='").append(vorname);
        sb.append(", Nachname='").append(nachname);
        sb.append(", Adresse='").append(adresse);
        sb.append(", Telefon-Nummer='").append(telNr);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Kunde kunde = (Kunde) object;

        if (!kundenNr.equals(kunde.kundenNr)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return kundenNr.hashCode();
    }
}
