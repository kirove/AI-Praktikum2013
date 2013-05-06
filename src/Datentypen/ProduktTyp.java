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
public class ProduktTyp implements Serializable{

    private String name;
    private String produktNr;
    private int lagerBestand;
    
    public ProduktTyp(String name, String produktNr, int lagerBestand){
        this.name = name;
        this.produktNr = produktNr;
        this.lagerBestand = lagerBestand;
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

    public void setLagerBestand(int lagerBestand) {
        this.lagerBestand = lagerBestand;
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
