/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieferant;

import Datentypen.AdresseTyp;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lieferant")
public class Lieferant {

    @Id
    private String lieferantenNr;
    private String name;
    private AdresseTyp adresse;
    
    public Lieferant(){
        
    }

    public Lieferant(String name, AdresseTyp adresse) {
        this.lieferantenNr = "LieferantID: " + UUID.randomUUID();
        this.name = name;
        this.adresse = adresse;
    }

    public String getLieferantenNr() {
        return lieferantenNr;
    }

    public void setLieferantenNr(String lieferantenNr) {
        this.lieferantenNr = lieferantenNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseTyp getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseTyp adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lieferantenNr);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.adresse);
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
        final Lieferant other = (Lieferant) obj;
        if (!Objects.equals(this.lieferantenNr, other.lieferantenNr)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lieferant{" + "lieferantenNr=" + lieferantenNr + ", name=" + name + ", adresse=" + adresse + '}';
    }
    
    
}
