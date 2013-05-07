/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class TransportAuftragTyp {
    Date datum;
    LieferungTyp lieferung;
    

    public TransportAuftragTyp() {
    }

    public TransportAuftragTyp(Date datum, LieferungTyp lieferung) {
        this.datum = datum;
        this.lieferung = lieferung;
       
    }

    public Date getDatum() {
        return datum;
    }

    public LieferungTyp getLieferung() {
        return lieferung;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.datum);
        hash = 37 * hash + Objects.hashCode(this.lieferung);
        
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
        final TransportAuftragTyp other = (TransportAuftragTyp) obj;
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.lieferung, other.lieferung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransportAuftragTyp{" + "datum=" + datum + ", lieferung=" + lieferung + '}';
    }

   
    
    
}
