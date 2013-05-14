/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.LieferungTyp;
import Datentypen.AuftragTyp;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lieferung")
public class Lieferung {

    @Id
    String lieferungNr;
    @Column(name="auftrag", length = 100000) 
    AuftragTyp auftrag;
    boolean lieferungErfolgt;

    public Lieferung() {
    }

    public Lieferung(AuftragTyp auftrag) {
        this.auftrag = auftrag;
        this.lieferungNr = "LieferungNr:" + UUID.randomUUID();
        this.lieferungErfolgt = false;
    }

    public LieferungTyp getTyp() {
        return new LieferungTyp(auftrag, lieferungNr, lieferungErfolgt);
    }

    public AuftragTyp getAuftrag() {
        return auftrag;
    }

    public void setTransportAuftrag(AuftragTyp auftrag) {
        this.auftrag = auftrag;
    }

    public String getLieferungNr() {
        return lieferungNr;
    }

    public void setLieferungNr(String lieferungNr) {
        this.lieferungNr = lieferungNr;
    }

    public boolean isLieferungErfolgt() {
        return lieferungErfolgt;
    }

    public void setLieferungErfolgt(boolean lieferungErfolgt) {
        this.lieferungErfolgt = lieferungErfolgt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.auftrag);
        hash = 79 * hash + Objects.hashCode(this.lieferungNr);
        hash = 79 * hash + (this.lieferungErfolgt ? 1 : 0);
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
        final Lieferung other = (Lieferung) obj;
        if (!Objects.equals(this.auftrag, other.auftrag)) {
            return false;
        }
        if (!Objects.equals(this.lieferungNr, other.lieferungNr)) {
            return false;
        }
        if (this.lieferungErfolgt != other.lieferungErfolgt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lieferung{" + "auftrag=" + auftrag + ", lieferungNr=" + lieferungNr + ", lieferungErfolgt=" + lieferungErfolgt + '}';
    }
}
