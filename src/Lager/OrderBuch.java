/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.LieferantTyp;
import Datentypen.OrderBuchTyp;
import Datentypen.ProduktTyp;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class OrderBuch {
    private Map<ProduktTyp, LieferantTyp> eintraege;
    
     public OrderBuch(){
        
    }

    public OrderBuch(Map<ProduktTyp, LieferantTyp> eintraege) {
        this.eintraege = eintraege;
    }

     public OrderBuchTyp getTyp() {
        return new OrderBuchTyp(eintraege);
    }
    public Map<ProduktTyp, LieferantTyp> getEintraege() {
        return eintraege;
    }

    public void setEintraege(Map<ProduktTyp, LieferantTyp> eintraege) {
        this.eintraege = eintraege;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.eintraege);
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
        final OrderBuch other = (OrderBuch) obj;
        if (!Objects.equals(this.eintraege, other.eintraege)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderBuch{" + "eintraege=" + eintraege + '}';
    }
     
    
}
