/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Versand;

//import ReSTAdaptor.TransportdienstleisterAdapter;
import ReSTAdaptor.Server_Starten;

import Datentypen.AuftragTyp;
import Main.HibernateUtil;
import ReSTAdaptor.TDLAdapter;
import org.hibernate.Session;

/**
 *
 * @author Barzgun
 */
public class LieferungRepository {

    public static Lieferung erstelleLieferung(AuftragTyp auftrag) {
        Lieferung lieferung = new Lieferung(auftrag);
        Server_Starten server = new Server_Starten();
        server.start();
        Transportauftrag transportAuftrag = new Transportauftrag(lieferung.getTyp());
      //  TransportdienstleisterAdapter.versendeTransportauftrag(transportAuftrag.getTyp());
        TDLAdapter tdla = new TDLAdapter();
        tdla.sendeTransportAuftrag(transportAuftrag.getTyp());
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(lieferung);
        session.getTransaction().commit();
        return lieferung;
    }
}
