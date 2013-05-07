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
public class RechnungTyp2 {

    private String id;
    private boolean isBezahlt;
    private double betrag;
    private Date datum;
    private String auftragNr;
    private String kundeNr;

    public RechnungTyp2(String id, boolean isBezahlt, double betrag, Date datum, String auftragNr, String kundeNr) {
        this.id = id;
        this.isBezahlt = isBezahlt;
        this.betrag = betrag;
        this.datum = datum;
        this.auftragNr = auftragNr;
        this.kundeNr = kundeNr;
    }

    public String getKundenNr() {
        return this.kundeNr;
    }

    public String getId() {
        return id;
    }

    public boolean IsBezahlt() {
        return isBezahlt;
    }

    public double getBetrag() {
        return betrag;
    }

    public Date getDatum() {
        return datum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id.hashCode();
        hash = 47 * hash + (this.isBezahlt ? 1 : 0);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.betrag) ^ (Double.doubleToLongBits(this.betrag) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.datum);
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
        final Datentypen.RechnungTyp2 other = (Datentypen.RechnungTyp2) obj;
        if (this.id == null ? other.id != null : !this.id.equals(other.id)) {
            return false;
        }
        if (this.isBezahlt != other.isBezahlt) {
            return false;
        }
        if (Double.doubleToLongBits(this.betrag) != Double.doubleToLongBits(other.betrag)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rechnung{");
        sb.append("ID: ").append(id);
        sb.append(", Auftrag-Nummer: ").append(auftragNr);
        sb.append(", Kunde-Nummer: ").append(kundeNr);
        sb.append(", istBezahlt: ").append(isBezahlt);
        sb.append(", Date: ").append(datum).append("} ");
        return sb.toString();
    }
}
