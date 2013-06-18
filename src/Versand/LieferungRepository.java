/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

//import ReSTAdaptor.TransportdienstleisterAdapter;
import Main.HibernateUtil;
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
