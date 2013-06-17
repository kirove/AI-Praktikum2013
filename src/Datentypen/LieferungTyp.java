/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class LieferungTyp {

    AuftragTyp auftrag;
    String lieferungNr;
    boolean lieferungErfolgt;

    public LieferungTyp() {
    }

    public LieferungTyp(AuftragTyp auftrag, String lieferungNr, boolean lieferungErfolgt) {
        this.auftrag = auftrag;
        this.lieferungNr = lieferungNr;
        this.lieferungErfolgt = lieferungErfolgt;
    }

    public AuftragTyp getAuftrag() {
        return auftrag;
    }

    public String getLieferungNr() {
        return lieferungNr;
    }

    public boolean isLieferungErfolgt() {
        return lieferungErfolgt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.auftrag);
        hash = 13 * hash + Objects.hashCode(this.lieferungNr);
        hash = 13 * hash + (this.lieferungErfolgt ? 1 : 0);
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
        final LieferungTyp other = (LieferungTyp) obj;
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
        return "LieferungTyp{" + "auftrag=" + auftrag + ", lieferungNr=" + lieferungNr +  '}';
    }
}
