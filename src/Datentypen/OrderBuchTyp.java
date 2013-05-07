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
public class OrderBuchTyp implements Serializable {

    private Map<ProduktTyp, LieferantTyp> eintraege;

    public OrderBuchTyp(Map<ProduktTyp, LieferantTyp> eintrag) {
        this.eintraege = eintrag;
    }

    public Map<ProduktTyp, LieferantTyp> getEintraege() {
        return eintraege;
    }

    private void setEintraege(Map<ProduktTyp, LieferantTyp> eintraege) {
        this.eintraege = eintraege;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.eintraege);
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
        final OrderBuchTyp other = (OrderBuchTyp) obj;
        if (!Objects.equals(this.eintraege, other.eintraege)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderBuchTyp{" + "eintraege=" + eintraege + '}';
    }
}
