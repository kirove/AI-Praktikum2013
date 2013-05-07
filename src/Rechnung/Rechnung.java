/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rechnung;

import Datentypen.RechnungTyp2;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "Rechnung")
public class Rechnung {

    @Id
    private String id;
    
    private boolean isBezahlt;
    private double betrag;
    private String auftragNr;
    private Date datum;
    private String kundeNr;

    public Rechnung() {
    }

    public Rechnung(double betrag, String auftragNr, Date datum, String kundeNr) {
        this.id = "Rechnung-Nr: " + UUID.randomUUID();
        this.betrag = betrag;
        this.auftragNr = auftragNr;
        this.datum = datum;
        this.isBezahlt = false;
        this.kundeNr = kundeNr;
    }

    public RechnungTyp2 getTyp(){
        return new RechnungTyp2(id, isBezahlt, betrag, datum, auftragNr, kundeNr);
    }
    
    public String getId() {
        return id;
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
    
    public String getKundenNr(){
        return this.kundeNr;
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
        final Rechnung other = (Rechnung) obj;
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
