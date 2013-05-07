/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produkt")
public class Produkt {

    @Id
    private String produktNr;
    private String name;
    private int lagerBestand;
    private boolean isReserviert;

    public Produkt() {
    }

    ;

    public Produkt(String name, String produktNr, int lagerBestand) {
        this.name = name;
        this.produktNr = produktNr;
        this.lagerBestand = lagerBestand;
        this.isReserviert = false;
    }

    public ProduktTyp getTyp() {
        return new ProduktTyp(name, produktNr, lagerBestand);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduktNr() {
        return produktNr;
    }

    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    public int getLagerBestand() {
        return lagerBestand;
    }

    public void setLagerBestand(int lagerBestand) {
        this.lagerBestand = lagerBestand;
    }

    public void setReserviert() {
        this.isReserviert = true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.produktNr);
        hash = 43 * hash + this.lagerBestand;
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
        final Produkt other = (Produkt) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.produktNr, other.produktNr)) {
            return false;
        }
        if (this.lagerBestand != other.lagerBestand) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produkt{" + "name=" + name + ", produktNr=" + produktNr + ", lagerBestand=" + lagerBestand + '}';
    }
}
