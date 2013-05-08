/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.AuftragTyp;
import Datentypen.LieferungTyp;
import Main.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class TransportRepository {

  

    public static TransportAuftrag erstelleTransportAuftrag(LieferungTyp lieferung) {
        TransportAuftrag ta = new TransportAuftrag(new Date(), lieferung);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(ta);
        session.getTransaction().commit();
        return ta;
    }
}
