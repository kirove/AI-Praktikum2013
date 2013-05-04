/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

/**
 *
 * @author NED
 */
public class AdresseTyp {

    private String strasse;
    private int hausNr;
    private int plz;
    private String stadt;
    private String land;

    public AdresseTyp(String strasse, int hausNr, int plz, String stadt, String land) {
        this.strasse = strasse;
        this.hausNr = hausNr;
        this.plz = plz;
        this.stadt = stadt;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausNr() {
        return hausNr;
    }

    public int getPlz() {
        return plz;
    }

    public String getStadt() {
        return stadt;
    }

    public String getLand() {
        return land;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append(strasse).append(" ").append(hausNr).append("\n");
        sb.append(plz).append(" ").append(stadt).append("\n");
        sb.append(land);
        sb.append('}');
        return sb.toString();
    }
}
