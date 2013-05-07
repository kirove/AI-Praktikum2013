/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

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

    public static Lieferung erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(lieferung);
        session.getTransaction().commit();
        
        return lieferung;
    }

    public static TransportAuftrag erstelleTransportAuftrag(LieferungTyp lieferung) {
        TransportAuftrag ta = new TransportAuftrag(new Date(), lieferung);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(ta);
        session.getTransaction().commit();
        return ta;
    }
}
