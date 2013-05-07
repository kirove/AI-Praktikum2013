/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class BestellungTyp implements Serializable {

    private String bestellungsNr;
    private Map<ProduktTyp, Integer> produktListe;
    private LieferantTyp lieferant;

    private BestellungTyp() {
    }

    public BestellungTyp(String bestellungsNr, Map<ProduktTyp, Integer> produktListe, LieferantTyp lieferant) {
        this.produktListe = produktListe;
        this.lieferant = lieferant;
        this.bestellungsNr = bestellungsNr;
    }

    public String getBestellungsNr() {
        return bestellungsNr;
    }

    private void setBestellungsNr(String bestellungsNr) {
        this.bestellungsNr = bestellungsNr;
    }

    public Map<ProduktTyp, Integer> getProduktListe() {
        return produktListe;
    }

    private void setProduktListe(Map<ProduktTyp, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    public LieferantTyp getLieferant() {
        return lieferant;
    }

    private void setLieferant(LieferantTyp lieferant) {
        this.lieferant = lieferant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.produktListe);
        hash = 23 * hash + Objects.hashCode(this.lieferant);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BestellungTyp other = (BestellungTyp) obj;
        if (!Objects.equals(this.produktListe, other.produktListe)) {
            return false;
        }
        if (!Objects.equals(this.lieferant, other.lieferant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BestellungTyp{" + "bestellungsNr=" + bestellungsNr + "produktListe=" + produktListe + ", lieferant=" + lieferant + '}';
    }
}
