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
public class WarenEingangMeldungTyp implements Serializable {

    private String id;
    private Date datum;
    private Map<ProduktTyp, Integer> produktListe;

    public WarenEingangMeldungTyp(String id, Date datum, Map<ProduktTyp, Integer> produktListe) {
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.datum);
        hash = 37 * hash + Objects.hashCode(this.produktListe);
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
        final WarenEingangMeldungTyp other = (WarenEingangMeldungTyp) obj;
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
        return "WarenEingangMeldungTyp{" + "id=" + id + ", datum=" + datum + ", produktListe=" + produktListe + '}';
    }
}
