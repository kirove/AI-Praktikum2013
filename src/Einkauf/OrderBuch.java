/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Einkauf;

import Datentypen.LieferantTyp;
import Datentypen.OrderBuchTyp;
import Datentypen.ProduktTyp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Barzgun
 */
@Entity
@Table(name = "OrderBuch")
public class OrderBuch {
    @Id
    private HashMap<ProduktTyp, LieferantTyp> eintraege;
//    private List<ProduktTyp> produkte;
//    private List<LieferantTyp> lieferante;
    
     public OrderBuch(){
        
    }

    public OrderBuch(HashMap<ProduktTyp, LieferantTyp> eintraege) {
        this.eintraege = eintraege;
    }

     public OrderBuchTyp getTyp() {
        return new OrderBuchTyp(eintraege);
    }
    public Map<ProduktTyp, LieferantTyp> getEintraege() {
        return eintraege;
    }

    public void setEintraege(HashMap<ProduktTyp, LieferantTyp> eintraege) {
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
