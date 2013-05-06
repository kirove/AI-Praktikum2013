/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

//@Entity
//@Table(name = "Angebot")
public class Angebot {

   //  @Id
    private String angebotsNr;
    private KundenTyp kunde;
    private Date gueltigBis;
    private Map<ProduktTyp, Integer> produktListe;
    private double preis;

    public Angebot() {
    }

    public Angebot(KundenTyp kunde, Date gueltigBis, Map<ProduktTyp, Integer> produktListe, double preis) {
        this.angebotsNr = "AngebotsNr:" + UUID.randomUUID();
        this.kunde = kunde;
        this.gueltigBis = gueltigBis;
        this.produktListe = produktListe;
        this.preis = preis;
    }
    
    public AngebotTyp getTyp(){
        return new AngebotTyp(angebotsNr, kunde, gueltigBis, produktListe, preis);
    }

    public String getAngebotsNr() {
        return angebotsNr;
    }

    public void setAngebotsNr(String angebotsNr) {
        this.angebotsNr = angebotsNr;
    }

    public KundenTyp getKunde() {
        return kunde;
    }

    public void setKunde(KundenTyp kunde) {
        this.kunde = kunde;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Map<ProduktTyp, Integer> getProduktListe() {
        return produktListe;
    }

    public void setProduktListe(Map<ProduktTyp, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.angebotsNr);
        hash = 97 * hash + Objects.hashCode(this.kunde);
        hash = 97 * hash + Objects.hashCode(this.gueltigBis);
        hash = 97 * hash + Objects.hashCode(this.produktListe);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.preis) ^ (Double.doubleToLongBits(this.preis) >>> 32));
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
        final Angebot other = (Angebot) obj;
        if (!Objects.equals(this.angebotsNr, other.angebotsNr)) {
            return false;
        }
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
        return "Angebot{" + "angebotsNr=" + angebotsNr + ", kunde=" + kunde + ", gueltigBis=" + gueltigBis + ", produktListe=" + produktListe + ", preis=" + preis + '}';
    }
    
    
}
