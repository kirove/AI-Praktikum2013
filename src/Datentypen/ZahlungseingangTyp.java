/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import Rechnung.Rechnung;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class ZahlungseingangTyp {
     private Rechnung rechnung;
    private Date datum;
    private double betrag;
    private int id;

    public ZahlungseingangTyp(Rechnung rechnung, Date datum, double betrag, int id) {
        this.rechnung = rechnung;
        this.datum = datum;
        this.betrag = betrag;
        this.id = id;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    private void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public Date getDatum() {
        return datum;
    }

    private void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getBetrag() {
        return betrag;
    }

    private void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.rechnung);
        hash = 41 * hash + Objects.hashCode(this.datum);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.betrag) ^ (Double.doubleToLongBits(this.betrag) >>> 32));
        hash = 41 * hash + this.id;
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
        final ZahlungseingangTyp other = (ZahlungseingangTyp) obj;
        if (!Objects.equals(this.rechnung, other.rechnung)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (Double.doubleToLongBits(this.betrag) != Double.doubleToLongBits(other.betrag)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ZahlungseingangTyp{" + "rechnung=" + rechnung + ", datum=" + datum + ", betrag=" + betrag + ", id=" + id + '}';
    }
    
    
    
}
