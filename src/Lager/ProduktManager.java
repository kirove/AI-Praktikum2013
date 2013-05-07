/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.ProduktTyp;
import Main.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class ProduktManager implements IProduktManager{

    @Override
    public ProduktTyp erstelleProdukt(String name, String produktNr, int lagerBestand) {
        Produkt produkt = new Produkt(name, produktNr, lagerBestand);
        
        Session session = (Session) HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.save(produkt);
        session.getTransaction().commit();
        return produkt.getTyp();
    }

    @Override
    public ProduktTyp fordereProduktInformationen(int produktNummer) {
        
        return null;
    }
    
}
