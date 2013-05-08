/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

import Datentypen.AuftragTyp;
import Main.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class LieferungRepository {
      public static Lieferung erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(lieferung);
        session.getTransaction().commit();
        return lieferung;
    }
}
