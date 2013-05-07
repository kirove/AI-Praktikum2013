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
public interface IProduktManager extends ILager{
    public ProduktTyp erstelleProdukt(String name,String produktNr,int lagerBestand);
    public ProduktTyp fordereProduktInformationen(int produktNummer);
    
    
}
