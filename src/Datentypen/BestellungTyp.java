/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class BestellungTyp {
    private Map<ProduktTyp, Integer> produktListe;
    private LieferantTyp lieferant;
    
    private BestellungTyp(){
        
    }

    public BestellungTyp(Map<ProduktTyp, Integer> produktListe, LieferantTyp lieferant) {
        this.produktListe = produktListe;
        this.lieferant = lieferant;
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
        return "BestellungTyp{" + "produktListe=" + produktListe + ", lieferant=" + lieferant + '}';
    }
    
    
}
