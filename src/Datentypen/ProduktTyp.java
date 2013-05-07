/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class ProduktTyp implements Serializable {

    private String name;
    private String produktNr;
    private int lagerBestand;
    private boolean isReserviert;
    private double preis;

    public ProduktTyp(String name, String produktNr, int lagerBestand, double preis) {
        this.name = name;
        this.produktNr = produktNr;
        this.lagerBestand = lagerBestand;
        this.isReserviert = false;
        this.preis = preis;
    }

    public double getPreis() {
        return preis;
    }

    private void setPreis(double preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public String getProduktNr() {
        return produktNr;
    }

    public int getLagerBestand() {
        return lagerBestand;
    }

    private void setLagerBestand(int lagerBestand) {
        this.lagerBestand = lagerBestand;
    }

    private void setReserviert() {
        this.isReserviert = true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.produktNr);
        hash = 31 * hash + this.lagerBestand;
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
        final ProduktTyp other = (ProduktTyp) obj;
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
        return "ProduktTyp{" + "name=" + name + ", produktNr=" + produktNr + ", lagerBestand=" + lagerBestand + '}';
    }
}
