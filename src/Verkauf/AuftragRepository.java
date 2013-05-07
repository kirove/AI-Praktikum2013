package Verkauf;

import Datentypen.AngebotTyp;
import Main.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author NED
 */
public class AuftragRepository {

    public Auftrag createAuftrag(AngebotTyp angebot) {

        Auftrag newAuftrag = new Auftrag(angebot);
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(newAuftrag);
        session.getTransaction().commit();

        return newAuftrag;
    }

    public Auftrag getAuftragPerNr(String auftragNr) {
        Auftrag auftrag = null;
        //get Auftrag anhand auftragNr
        return auftrag;
    }

    public List<Auftrag> getAuftrage(String kundenName) {
        List<Auftrag> auftraegeListe = null;
        //get aufträge Liste anhand KundenName
        return auftraegeListe;
    }

    public Auftrag updateAuftrag(Auftrag auftrag) {

        // update auftrag
        return auftrag;
    }

    public List<Auftrag> getAuftrag(boolean isAbgeschlossen) {
        List<Auftrag> auftraegeListe = null;
       //get alle aufträge die noch nicht abgeschlossen sind
        return auftraegeListe;
    }
}
