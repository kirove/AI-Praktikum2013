/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieferant;

import Datentypen.LieferantTyp;
import Datentypen.OrderBuchTyp;
import Einkauf.*;

/**
 *
 * @author Barzgun
 */
public interface ILieferant {
    public LieferantTyp getLieferant(OrderBuchTyp orderBuch);
}
