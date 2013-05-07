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
public class WarenAusgangMeldungTyp implements Serializable {

    private String id;
    private Date datum;
    private Map<ProduktTyp, Integer> produktListe;

    public WarenAusgangMeldungTyp(String id, Date datum, Map<ProduktTyp, Integer> produktListe) {
        this.id = id;
        this.datum = datum;
        this.produktListe = produktListe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Map<ProduktTyp, Integer> getProduktListe() {
        return produktListe;
    }

    public void setProduktListe(Map<ProduktTyp, Integer> produktListe) {
        this.produktListe = produktListe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.datum);
        hash = 89 * hash + Objects.hashCode(this.produktListe);
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
        final WarenAusgangMeldungTyp other = (WarenAusgangMeldungTyp) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.produktListe, other.produktListe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WarenAusgangMeldungTyp{" + "id=" + id + ", datum=" + datum + ", produktListe=" + produktListe + '}';
    }
}
