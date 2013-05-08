/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import java.util.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Auftrag")
public class Auftrag {

    @Id
    private String auftragsNr;
     
    private AngebotTyp angebot;
    private boolean isAbgeschlossen;
    private Date date;

    public Auftrag() {
    }

    
    public Auftrag(AngebotTyp angebot) {
        this.auftragsNr = "AuftragsNr:" + UUID.randomUUID();;
        this.angebot = angebot;
        this.isAbgeschlossen = false;
        this.date = new Date();
    }
    public AuftragTyp getTyp(){
        return new AuftragTyp(auftragsNr, angebot, isAbgeschlossen,date);
    }

    public String getAuftragsNr() {
        return auftragsNr;
    }

    public AngebotTyp getAngebot() {
        return angebot;
    }

    public void setAngebot(AngebotTyp angebot) {
        this.angebot = angebot;
    }

    public boolean isIsAbgeschlossen() {
        return isAbgeschlossen;
    }

    public void setIsAbgeschlossen(boolean isAbgeschlossen) {
        this.isAbgeschlossen = isAbgeschlossen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.auftragsNr);
        hash = 67 * hash + Objects.hashCode(this.angebot);
        hash = 67 * hash + (this.isAbgeschlossen ? 1 : 0);
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
        final Auftrag other = (Auftrag) obj;
        if (!Objects.equals(this.auftragsNr, other.auftragsNr)) {
            return false;
        }
        if (!Objects.equals(this.angebot, other.angebot)) {
            return false;
        }
        if (this.isAbgeschlossen != other.isAbgeschlossen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auftrag{" + "auftragsNr=" + auftragsNr + ", angebot=" + angebot + ", isAbgeschlossen=" + isAbgeschlossen + '}';
    }
    
}
