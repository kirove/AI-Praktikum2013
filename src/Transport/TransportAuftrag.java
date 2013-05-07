/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import Datentypen.TransportAuftragTyp;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class TransportAuftrag {

    Date datum;
    LieferungTyp lieferung;

    public TransportAuftrag() {
    }

    public TransportAuftrag(Date datum, LieferungTyp lieferung) {
        this.datum = datum;
        this.lieferung = lieferung;

    }

    public TransportAuftragTyp getTyp() {
        return new TransportAuftragTyp(datum, lieferung);
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public LieferungTyp getLieferung() {
        return lieferung;
    }

    public void setLieferung(LieferungTyp lieferung) {
        this.lieferung = lieferung;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.datum);
        hash = 19 * hash + Objects.hashCode(this.lieferung);
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
        final TransportAuftrag other = (TransportAuftrag) obj;
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
        return "TransportAuftrag{" + "datum=" + datum + ", lieferung=" + lieferung + '}';
    }
}
