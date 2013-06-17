/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.LieferungTyp;
import Datentypen.Transportauftragstyp;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class Transportauftrag {

    public LieferungTyp lieferung;

    public Transportauftrag(LieferungTyp lieferung) {
        this.lieferung = lieferung;
    }
 
     public Transportauftragstyp getTyp() {
        return new Transportauftragstyp(lieferung);
    }

    public LieferungTyp getLieferung() {
        return lieferung;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.lieferung);
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
        final Transportauftrag other = (Transportauftrag) obj;
        if (!Objects.equals(this.lieferung, other.lieferung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transportauftrag{" + "lieferung=" + lieferung + '}';
    }
     

 

  
    
}
