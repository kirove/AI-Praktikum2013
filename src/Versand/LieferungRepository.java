/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

//import ReSTAdaptor.TransportdienstleisterAdapter;
import ReSTAdaptor.Server_Starten;

import Datentypen.AuftragTyp;
import Main.HibernateUtil;
import ReSTAdaptor.ITransportAuftrag;
import ReSTAdaptor.Verwalter.TDLAdapter;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class LieferungRepository {

    public static Lieferung erstelleLieferung(Lieferung lieferung) {


        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(lieferung);
        session.getTransaction().commit();
        return lieferung;
    }
}
