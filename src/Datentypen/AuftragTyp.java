/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class AuftragTyp implements Serializable {

    private String auftragsNr;
    private AngebotTyp angebot;
    private boolean isAbgeschlossen;

    private AuftragTyp() {
    }

    public AuftragTyp(String auftragsNr,AngebotTyp angebot,boolean isAbgeschlossen, Date datesSS) {
        this.auftragsNr = auftragsNr;
        this.angebot = angebot;
        this.isAbgeschlossen = isAbgeschlossen;
    }

    
    public AngebotTyp getAngebot() {
        return angebot;
    }

    private void setAngebot(AngebotTyp angebot) {
        this.angebot = angebot;
    }

    public String getAuftragsNr() {
        return auftragsNr;
    }

    public void setAuftragsNr(String auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    public boolean isIsAbgeschlossen() {
        return isAbgeschlossen;
    }

    private void setIsAbgeschlossen(boolean isAbgeschlossen) {
        this.isAbgeschlossen = isAbgeschlossen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.angebot);
        hash = 97 * hash + (this.isAbgeschlossen ? 1 : 0);
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
        final AuftragTyp other = (AuftragTyp) obj;
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
        return "AuftragTyp{" + "angebot=" + angebot + ", isAbgeschlossen=" + isAbgeschlossen + '}';
    }
}
