/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class AuftragTyp {
    private AngebotTyp angebot;
    private boolean isAbgeschlossen;
    
    private AuftragTyp(){
        
    }

    public AuftragTyp(AngebotTyp angebot) {
        this.angebot = angebot;
        this.isAbgeschlossen = false;
    }

    public AngebotTyp getAngebot() {
        return angebot;
    }


    public boolean isIsAbgeschlossen() {
        return isAbgeschlossen;
    }

    public void setIsAbgeschlossen(boolean isAbgeschlossen) {
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
