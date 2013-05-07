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
public class EinkaufsinfosatzTyp implements Serializable{
    private Map<ProduktTyp,Integer> eintraege;
    
    private EinkaufsinfosatzTyp(){
        
    }

    public EinkaufsinfosatzTyp(Map<ProduktTyp, Integer> eintraege) {
        this.eintraege = eintraege;
    }

    public Map<ProduktTyp, Integer> getEintraege() {
        return eintraege;
    }

    private void setEintraege(Map<ProduktTyp, Integer> eintraege) {
        this.eintraege = eintraege;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.eintraege);
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
        final EinkaufsinfosatzTyp other = (EinkaufsinfosatzTyp) obj;
        if (!Objects.equals(this.eintraege, other.eintraege)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EinkaufsinfosatzTyp{" + "eintraege=" + eintraege + '}';
    }
    
}
