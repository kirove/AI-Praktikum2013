package Kunde;

/**
 *
 * @author NED
 */
public class TelefonNrTyp {

    private String vorwahl;
    private int nummer;

    public TelefonNrTyp(String vorwahl, int nummer) {
        this.vorwahl = vorwahl;
        this.nummer = nummer;
    }

    public String getVorwahl() {
        return vorwahl;
    }

    public void setVorwahl(String vorwahl) {
        this.vorwahl = vorwahl;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telefon-Nummer{");
        sb.append(vorwahl).append("/").append(nummer);
        sb.append('}');
        return sb.toString();
    }

}
