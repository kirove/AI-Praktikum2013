/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class Transportauftragstyp implements Serializable{
public LieferungTyp lieferung;

    public Transportauftragstyp() {
    }

    public Transportauftragstyp(LieferungTyp lieferung) {
        this.lieferung = lieferung;
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
        final Transportauftragstyp other = (Transportauftragstyp) obj;
        if (!Objects.equals(this.lieferung, other.lieferung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transportauftragstyp{" + "lieferung=" + lieferung + '}';
    }
    

  

  
        
}
