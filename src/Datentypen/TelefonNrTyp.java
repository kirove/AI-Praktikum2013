package Datentypen;

import java.io.Serializable;

/**
 *
 * @author NED
 */
public class TelefonNrTyp implements Serializable{

    private String vorwahl;
    private int nummer;

    public TelefonNrTyp(String vorwahl, int nummer) {
        this.vorwahl = vorwahl;
        this.nummer = nummer;
    }

    public String getVorwahl() {
        return vorwahl;
    }

    private void setVorwahl(String vorwahl) {
        this.vorwahl = vorwahl;
    }

    public int getNummer() {
        return nummer;
    }

    private void setNummer(int nummer) {
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
