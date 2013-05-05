/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieferant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lieferant")
public class Lieferant {

    @Id
    private String lieferantenNr;
}
