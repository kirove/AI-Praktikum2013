/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Einkauf;

import Datentypen.BestellungTyp;
import Datentypen.OrderBuchTyp;
import Datentypen.ProduktTyp;

/**
 *
 * @author Barzgun
 */
public interface IEinkauf {
    public BestellungTyp erstelleBestellung(ProduktTyp produkt);
    public OrderBuchTyp zeigeOrderbuch(ProduktTyp produkt);
    public int zeigeEinkaufsInfosatz(ProduktTyp produkt);
    
}
