package Datentypen;

/**
 *
 * @author NED
 */
public class KundenTyp {

    private String kundenNr;
    private String vorname;
    private String nachname;
    private AdresseTyp adresse;
    private TelefonNrTyp telNr;

    public KundenTyp(String kundenNr, String vorname, String nachname, AdresseTyp adresse, TelefonNrTyp telNr) {
        this.kundenNr = kundenNr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.telNr = telNr;
    }

    public String getKundenNr() {
        return kundenNr;
    }

    public void setKundenNr(String kundenNr) {
        this.kundenNr = kundenNr;
    }

    public String getvorName() {
        return vorname;
    }

    public void setvorName(String vorname) {
        this.vorname = vorname;
    }

    public String getnachName() {
        return nachname;
    }

    public void setnachName(String nachname) {
        this.nachname = nachname;
    }

    public AdresseTyp getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseTyp adresse) {
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

        KundenTyp kundenTyp = (KundenTyp) object;

        if (kundenNr != null ? !kundenNr.equals(kundenTyp.kundenNr) : kundenTyp.kundenNr != null) {
            return false;
        }
        if (vorname != null ? !vorname.equals(kundenTyp.vorname) : kundenTyp.vorname != null) {
            return false;
        }
        if (nachname != null ? !nachname.equals(kundenTyp.nachname) : kundenTyp.nachname != null) {
            return false;
        }
        if (adresse != null ? !adresse.equals(kundenTyp.adresse) : kundenTyp.adresse != null) {
            return false;
        }
        if (telNr != null ? !telNr.equals(kundenTyp.telNr) : kundenTyp.telNr != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = kundenNr != null ? kundenNr.hashCode() : 0;
        result = 222 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 222 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 222 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 222 * result + (telNr != null ? telNr.hashCode() : 0);
        return result;
    }
}
