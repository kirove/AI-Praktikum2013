/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;

/**
 *
 * @author NED
 */
public interface IProduktManager extends ILagerManager{
    public ProduktTyp erstelleProdukt(String name,String produktNr,int lagerBestand, double preis);
    public ProduktTyp fordereProduktInformationen(int produktNummer);
    
    
}
