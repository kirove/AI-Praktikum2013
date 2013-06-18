/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternTransportdienstleister;

import java.util.Objects;

/**
 *
 * @author Barzgun
 */
public class Transportdienstleister {
    public String name;
    public String nr;

    public Transportdienstleister(String name, String nr) {
        this.name = name;
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public String getNr() {
        return nr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.nr);
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
        final Transportdienstleister other = (Transportdienstleister) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.nr, other.nr)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transportdienstleister{" + "name=" + name + ", nr=" + nr + '}';
    }
   
}
