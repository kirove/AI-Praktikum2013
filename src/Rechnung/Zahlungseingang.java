package Rechnung;

import Datentypen.ZahlungseingangTyp;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Zahlungseingang")
public class Zahlungseingang {
    
    @Id
    private int id;
    
    @OneToOne
    private Rechnung rechnung;
    private Date datum;
    private double betrag;

    public Zahlungseingang() {
    }

    public Zahlungseingang(int id, Rechnung rechnung, Date datum, double betrag) {
        this.id = id;
        this.rechnung = rechnung;
        this.datum = datum;
        this.betrag = betrag;
    }
    
    public ZahlungseingangTyp getTp(){
        return new ZahlungseingangTyp(rechnung, datum, betrag, id);
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.rechnung);
        hash = 19 * hash + Objects.hashCode(this.datum);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.betrag) ^ (Double.doubleToLongBits(this.betrag) >>> 32));
        hash = 19 * hash + this.id;
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
        final Zahlungseingang other = (Zahlungseingang) obj;
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
        return "Zahlungseingang{" + "rechnung=" + rechnung + ", datum=" + datum + ", betrag=" + betrag + ", id=" + id + '}';
    }
    
    
    
}
