/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Einkauf;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderBuch")
public class OrderBuch {
    
    @Id
    private String orderBuchNr;
    
}
