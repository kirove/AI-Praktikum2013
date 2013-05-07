/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import Datentypen.WarenAusgangMeldungTyp;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Barzgun
 */
public class WarenAusgangMeldung {

    private String id;
    private Date datum;
    private Map<ProduktTyp, Integer> produktListe;
//    private int menge;
//    private ProduktTyp produkt;

    public WarenAusgangMeldung() {
    }

    public WarenAusgangMeldung(Date datum, Map<ProduktTyp, Integer> produktListe) {
        this.id = "WarenAusgangMeldungID:" + UUID.randomUUID();
        this.datum = datum;
        this.produktListe = produktListe;
    }

    public WarenAusgangMeldungTyp getTyp() {
        return new WarenAusgangMeldungTyp(id, datum, produktListe);
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
        final WarenAusgangMeldung other = (WarenAusgangMeldung) obj;
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
        return "WarenAusgangMeldung{" + "id=" + id + ", datum=" + datum + ", produktListe=" + produktListe + '}';
    }
}
