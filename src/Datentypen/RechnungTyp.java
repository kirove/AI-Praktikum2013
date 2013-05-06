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
public class RechnungTyp {

    private int id;
    private boolean isBezahlt;
    private double betrag;
    private Date datum;

    public RechnungTyp(int id, boolean isBezahlt, double betrag, Date datum) {
        this.id = id;
        this.isBezahlt = isBezahlt;
        this.betrag = betrag;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsBezahlt() {
        return isBezahlt;
    }

    public void setIsBezahlt(boolean isBezahlt) {
        this.isBezahlt = isBezahlt;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
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
        final Datentypen.RechnungTyp other = (Datentypen.RechnungTyp) obj;
        if (this.id != other.id) {
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
        return "RechnungTyp{" + "id=" + id + ", isBezahlt=" + isBezahlt + ", betrag=" + betrag + ", datum=" + datum + '}';
    }
    
    
}
