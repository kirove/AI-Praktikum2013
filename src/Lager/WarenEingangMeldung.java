/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import Datentypen.WarenEingangMeldungTyp;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Barzgun
 */
public class WarenEingangMeldung {

    private String id;
    private Date datum;
    private Map<ProduktTyp, Integer> produktListe;

    public WarenEingangMeldung() {
    }

    public WarenEingangMeldung(Date datum,Map<ProduktTyp, Integer> produktListe) {
        this.id = "WarenEingangMeldungID:" + UUID.randomUUID();
        this.datum = datum;
        this.produktListe = produktListe;
    }

    public WarenEingangMeldungTyp getTyp() {
        return new WarenEingangMeldungTyp(id, datum, produktListe);
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
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.datum);
        hash = 79 * hash + Objects.hashCode(this.produktListe);
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
        final WarenEingangMeldung other = (WarenEingangMeldung) obj;
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
        return "WarenEingangMeldung{" + "id=" + id + ", datum=" + datum + ", produktListe=" + produktListe + '}';
    }
}
