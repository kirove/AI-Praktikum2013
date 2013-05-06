/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Einkauf;

import Datentypen.BestellungTyp;
import Datentypen.LieferantTyp;
import Datentypen.ProduktTyp;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bestellung")
public class Bestellung {

    @Id
    private String bestellungsNr;
    @Id
    private Map<ProduktTyp, Integer> produktListe;
    private LieferantTyp lieferant;

    public Bestellung() {
    }

    public Bestellung(String bestellungsNr, Map<ProduktTyp, Integer> produktListe, LieferantTyp lieferant) {
        this.bestellungsNr = bestellungsNr;
        this.produktListe = produktListe;
        this.lieferant = lieferant;
    }

    public BestellungTyp getTyp(){
        return new BestellungTyp(bestellungsNr,produktListe, lieferant);
    }
    
    public String getBestellungsNr() {
        return bestellungsNr;
    }

    public void setBestellungsNr(String bestellungsNr) {
        this.bestellungsNr = bestellungsNr;
    }

    public Map<ProduktTyp, Integer> getProduktListe() {
        return produktListe;
    }

    public void setProduktListe(Map<ProduktTyp, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    public LieferantTyp getLieferant() {
        return lieferant;
    }

    public void setLieferant(LieferantTyp lieferant) {
        this.lieferant = lieferant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.bestellungsNr);
        hash = 59 * hash + Objects.hashCode(this.produktListe);
        hash = 59 * hash + Objects.hashCode(this.lieferant);
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
        final Bestellung other = (Bestellung) obj;
        if (!Objects.equals(this.bestellungsNr, other.bestellungsNr)) {
            return false;
        }
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
        return "Bestellung{" + "bestellungsNr=" + bestellungsNr + ", produktListe=" + produktListe + ", lieferant=" + lieferant + '}';
    }
}
