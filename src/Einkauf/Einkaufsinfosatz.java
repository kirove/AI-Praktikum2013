/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Einkauf;

import Datentypen.EinkaufsinfosatzTyp;
import Datentypen.ProduktTyp;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Barzgun
 */
@Entity
@Table(name = "OrderBuch")
public class Einkaufsinfosatz {
    @Id
    private Map<ProduktTyp,Integer> eintraege;
    public Einkaufsinfosatz(){
        
    }

    public Einkaufsinfosatz(Map<ProduktTyp, Integer> eintraege) {
        this.eintraege = eintraege;
    }
    
     public EinkaufsinfosatzTyp getTyp() {
        return new EinkaufsinfosatzTyp(eintraege);
    }

    public Map<ProduktTyp, Integer> getEintraege() {
        return eintraege;
    }

    public void setEintraege(Map<ProduktTyp, Integer> eintraege) {
        this.eintraege = eintraege;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.eintraege);
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
        final Einkaufsinfosatz other = (Einkaufsinfosatz) obj;
        if (!Objects.equals(this.eintraege, other.eintraege)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Einkaufsinfosatz{" + "eintraege=" + eintraege + '}';
    }
    
}