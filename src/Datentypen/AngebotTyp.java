/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datentypen;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;



/**
 *
 * @author Barzgun
 */
public class AngebotTyp implements Serializable{
    private KundenTyp kunde;
    private Date gueltigBis;
    private Map<ProduktTyp, Integer> produktListe;
    private double preis;
    
    private AngebotTyp(){};

    public AngebotTyp(KundenTyp kunde, Date gueltigBis, Map<ProduktTyp, Integer> produktListe, double preis) {
        this.kunde = kunde;
        this.gueltigBis = gueltigBis;
        this.produktListe = produktListe;
        this.preis = preis;
    }

    public KundenTyp getKunde() {
        return kunde;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public Map<ProduktTyp, Integer> getProduktListe() {
        return produktListe;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.kunde);
        hash = 23 * hash + Objects.hashCode(this.gueltigBis);
        hash = 23 * hash + Objects.hashCode(this.produktListe);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.preis) ^ (Double.doubleToLongBits(this.preis) >>> 32));
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
        final AngebotTyp other = (AngebotTyp) obj;
        if (!Objects.equals(this.kunde, other.kunde)) {
            return false;
        }
        if (!Objects.equals(this.gueltigBis, other.gueltigBis)) {
            return false;
        }
        if (!Objects.equals(this.produktListe, other.produktListe)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preis) != Double.doubleToLongBits(other.preis)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AngebotTyp{" + "kunde=" + kunde + ", gueltigBis=" + gueltigBis + ", produktListe=" + produktListe + ", preis=" + preis + '}';
    }
    
    
}